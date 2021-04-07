package com.bo.xMarket.bl;

import com.bo.xMarket.dao.*;
import com.bo.xMarket.dto.*;
import com.bo.xMarket.model.*;
//import io.swagger.models.auth.In;
//import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private ProductBranchDao productBranchDao;
    private MediaDao mediaDao;
    private StockDao stockDao;
    private OfferRegisterDao offerRegisterDao;
    private BranchOfficeDao branchOfficeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBl.class);

    @Autowired
    public ProductBl(ProductDao productDao, CategoryDao categoryDao, ProductBranchDao productBranchDao, MediaDao mediaDao, StockDao stockDao, OfferRegisterDao offerRegisterDao, BranchOfficeDao branchOfficeDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.productBranchDao = productBranchDao;
        this.mediaDao = mediaDao;
        this.stockDao = stockDao;
        this.offerRegisterDao = offerRegisterDao;
        this.branchOfficeDao = branchOfficeDao;
    }

    public List<ProductResponse> productList(Integer idManager) {
        BranchOffice branchOffice = branchOfficeDao.getBranchOfficerByManagerId(idManager);
        List<Product> productResponse = productDao.listProductsByBranch(branchOffice.getBranchOfficeId());
        List<ProductResponse> productResult = new ArrayList<>();
        for (Product response : productResponse) {
            Category category = categoryDao.getCategoryById(response.getProductCategoryId());
            ProductResponse resp = new ProductResponse();
            resp.setProductId(response.getProductId());
            resp.setName(response.getName());
            resp.setPrice(response.getPrice());

            try {
                OfferRegister offerRegister = offerRegisterDao.getActualOffer(response.getProductId());
                resp.setPercentage(offerRegister.getPercentage());
            } catch (Exception e) {
                e.printStackTrace();
//                LOGGER.warn();
                resp.setPercentage(0);
            }
            resp.setDescription(response.getDescription());
            resp.setCategory(category.getName());
            List<MediaRequest> media = mediaDao.listmedia(response.getProductId());
            resp.setFirstImage(media.size() > 0 ? media.get(0).getPhoto() : null);
            productResult.add(resp);

        }
        LOGGER.error(productResult.toString());
        return productResult;
    }

    public List<ProductResponse> productListbyCategory(Integer id, Integer idbranch, Integer idcategory) {
        return productDao.listproductsbycategory(id, idbranch, idcategory);
    }

    public List<ProductResponse> productListbyBranchId(Integer id, Integer idbranch) {
        return productDao.listProductsByBranchId(idbranch);
    }

    public Product addProduct(ProductRequest productRequest, Integer idbranch, Transaction transaction) {
        Product product = new Product();
        Category category = new Category();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
//        product.setWeight(productRequest.getWeight());
        product.setStatus(1);
        product.setTransaction(transaction);
        category.setName(productRequest.getCategory());
        category.setStatus(1);
        category.setTransaction(transaction);
        categoryDao.addcategory(category);
        Integer lastIdCategory = categoryDao.getLastInsertId();
        product.setProductCategoryId(lastIdCategory);
        productDao.addproduct(product);
        Integer lastProductId = productDao.getLastInsertId();

        if (productRequest.getOffer() != null) {
            addOffer(productRequest.getOffer(),transaction,lastProductId);
        }
        if (productRequest.getImagesUrl().size() > 0) {

            addMedia(productRequest.getImagesUrl(), lastProductId, transaction);
        }
        addProductBranch(lastProductId, idbranch);

        return product;
    }

    public void addProductBranch(Integer lastProductId, Integer idbranch) {
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductId(lastProductId);
        productBranch.setBranchOfficeId(idbranch);
        productBranchDao.addProductBranch(productBranch);
    }

    public void addOffer(OfferRequest offerRequest,Transaction transaction,Integer productId) {
        OfferRegister offerRegister= new OfferRegister();
        offerRegister.setEndDate(offerRequest.getEndDate());
        offerRegister.setStartDate(offerRequest.getStartDate());
        offerRegister.setPercentage(offerRequest.getPercentage());
        offerRegister.setProductId(productId);
        Date date= new Date();
        LOGGER.info(String.valueOf(date));
        offerRegister.setStatus(1);
        offerRegister.setTransaction(transaction);
        offerRegisterDao.addOfferRegister(offerRegister);
    }

    public void addMedia(List<String> listMedia, Integer productId, Transaction transaction) {
        listMedia.forEach(mediaRequest -> {
            Media media = new Media();
            media.setPhoto(mediaRequest);
            media.setProductId(productId);
            media.setStatus(1);
            media.setTransaction(transaction);
            mediaDao.addMedia(media);
        });
    }

    public ProductSpecificResponse productInfo(Integer productid) {
        ProductSpecificResponse product= productDao.productsDetails(productid);
        Category category = categoryDao.getCategoryById(productid);
        List<MediaRequest> media = mediaDao.listmedia(productid);
        Stock stock = stockDao.getStockById(product.getProductId());

        product.setCategory(category);
        product.setImagesUrl(media);
        product.setUnit(stock.getInStock());

        return product;
    }

    public void productDelete(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
