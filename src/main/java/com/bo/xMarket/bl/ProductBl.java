package com.bo.xMarket.bl;

import com.bo.xMarket.dao.*;
import com.bo.xMarket.dto.*;
import com.bo.xMarket.model.*;
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
            List<Media> media = mediaDao.getPhotosById(response.getProductId());
            resp.setFirstImage(media.size() > 0 ? media.get(0).getPhoto() : null);
            productResult.add(resp);

        }
        LOGGER.error(productResult.toString());
        return productResult;
    }

    public List<ProductResponse> productListbyCategory(Integer id, Integer idbranch, Integer idcategory) {
        return productDao.listproductsbycategory(id, idbranch, idcategory);
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

//        if (productRequest.getOffer() != null) {
//            addOffer(productRequest.getOffer());
//        }
//        if (productRequest.getImagesUrl().size() > 0) {
//
//            addMedia(productRequest.getImagesUrl(), lastProductId, transaction);
//        }
        addProductBranch(lastProductId, idbranch);

        return product;
    }

    public void addProductBranch(Integer lastProductId, Integer idbranch) {
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductId(lastProductId);
        productBranch.setBranchOfficeId(idbranch);
        productBranchDao.addProductBranch(productBranch);
    }

    public void addOffer(ProductOfferRequest offerRequest) {

    }

    public void addMedia(List<MediaRequest> listMedia, Integer productId, Transaction transaction) {
        listMedia.forEach(mediaRequest -> {
            Media media = new Media();
            media.setPhoto(mediaRequest.getPhoto());
            media.setProductId(productId);
            media.setStatus(0);
            media.setTransaction(transaction);
            mediaDao.addMedia(media);
        });
    }

    public ProductRequest productInfo(Integer productid) {
        Product product = productDao.productsDetails(productid);
        Category category = categoryDao.getCategoryById(productid);
        List<Media> media = mediaDao.getPhotosById(productid);
        List<String> photos = new ArrayList<>();
        media.forEach(media1 -> photos.add(media1.getPhoto()));
        Stock stock = stockDao.getStockById(product.getProductId());
        try {
            OfferRegister offerRegister = offerRegisterDao.getActualOffer(productid);
            OfferRequest offerRequest = new OfferRequest(offerRegister.getPercentage(), new SimpleDateFormat("dd-MM-yyyy").format(offerRegister.getStartDate()), new SimpleDateFormat("dd-MM-yyyy").format(offerRegister.getEndDate()));
            return new ProductRequest(product.getName(), product.getPrice(), product.getDescription(), stock.getInStock(), category.getName(), offerRequest, photos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ProductRequest(product.getName(), product.getPrice(), product.getDescription(), stock.getInStock(), category.getName(), null, photos);
        }
    }

    public void productDelete(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
