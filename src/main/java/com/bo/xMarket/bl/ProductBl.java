package com.bo.xMarket.bl;

import com.bo.xMarket.dao.*;
import com.bo.xMarket.dto.*;
import com.bo.xMarket.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/* import io.swagger.models.auth.In;
 import jdk.nashorn.internal.runtime.options.LoggingOption;*/

@Service
public class ProductBl {
    private final ProductDao productDao;
    private final CategoryDao categoryDao;
    private final ProductBranchDao productBranchDao;
    private final MediaDao mediaDao;
    private final StockDao stockDao;
    private final OfferRegisterDao offerRegisterDao;
    private final BranchOfficeDao branchOfficeDao;
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

    public PageInfo<ProductResponse> productList(Integer idPerson, Integer page, Integer size) {

        BranchOffice branchOffice = branchOfficeDao.getBranchByPersonManagerId(idPerson);
        if (branchOffice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find branch");
        }
        PageHelper.startPage(page, size); //line 1
        List<Product> productResponse = productDao.listProductsByBranch(branchOffice.getBranchOfficeId());
        PageInfo prelim = new PageInfo(productResponse);
        List<ProductResponse> productResult = new ArrayList<>();
        for (Product response : productResponse) {
            Category category = categoryDao.getCategoryById(response.getProductCategoryId());
            ProductResponse resp = new ProductResponse();
            Stock stock = productDao.getStock(response.getProductId());
            resp.setProductId(response.getProductId());
            resp.setName(response.getName());
            resp.setPrice(response.getPrice());
            resp.setUnit(stock.getInStock());
            try {
                OfferRegister offerRegister = offerRegisterDao.getActualOffer(response.getProductId());
                resp.setPercentage(offerRegister.getPercentage());
            } catch (Exception e) {
//                e.printStackTrace();
//                LOGGER.warn();
                resp.setPercentage(0);
            }
            resp.setDescription(response.getDescription());
            resp.setCategory(category.getName());
            List<MediaRequest> media = mediaDao.listmedia(response.getProductId());
            resp.setFirstImage(media.size() > 0 ? media.get(0).getPhoto() : null);
            productResult.add(resp);
        }

//        LOGGER.error(productResult.toString());
        prelim.setList(productResult);
        return prelim;
    }

    public List<ProductResponse> productListbyCategory(Integer id, Integer idbranch, Integer idcategory) {
        List<ProductResponse> productList = productDao.listProductsByCategory(id, idbranch, idcategory);
        List<ProductResponse> productResult = new ArrayList<>();
        Category category = categoryDao.getCategoryById(idcategory);
        for (ProductResponse response : productList) {
            ProductResponse result = new ProductResponse();
            Stock stock = productDao.getStock(response.getProductId());

            result.setProductId(response.getProductId());
            result.setName(response.getName());
            result.setPrice(response.getPrice());
            result.setDescription(response.getDescription());
            result.setCategory(category.getName());
            result.setFirstImage(response.getFirstImage());
            result.setUnit(stock.getInStock());

            OfferRegister offerRegister = offerRegisterDao.getActualOffer(response.getProductId());
            result.setPercentage(offerRegister != null ? offerRegister.getPercentage() : 0);

            productResult.add(result);
        }
        return productResult;
    }

    public List<ProductResponse> productListbyBranchId(Integer id, Integer idbranch) {
        List<Product> productList = productDao.listProductsByBranch(idbranch);
        List<ProductResponse> productResult = new ArrayList<>();

        for (Product response : productList) {
            Category category = categoryDao.getCategoryById(response.getProductCategoryId());
            ProductResponse result = new ProductResponse();
            Stock stock = productDao.getStock(response.getProductId());
            result.setProductId(response.getProductId());
            result.setName(response.getName());
            result.setPrice(response.getPrice());
            result.setUnit(stock.getInStock());
            OfferRegister offerRegister = offerRegisterDao.getActualOffer(response.getProductId());
            result.setPercentage(offerRegister != null ? offerRegister.getPercentage() : 0);
            result.setDescription(response.getDescription());
            result.setCategory(category.getName());
            List<MediaRequest> media = mediaDao.listmedia(response.getProductId());
            result.setFirstImage(media.size() > 0 ? media.get(0).getPhoto() : null);
            productResult.add(result);
        }

        return productResult;
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
        Stock stock = new Stock();
        stock.setInStock(productRequest.getUnit());
        stock.setProductId(lastProductId);
        stock.setLastUpdate(new Date());
        stockDao.addStock(stock);
        if (productRequest.getOffer() != null) {
            addOffer(productRequest.getOffer(), transaction, lastProductId);
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

    public void addOffer(OfferRequest offerRequest, Transaction transaction, Integer productId) {
        OfferRegister offerRegister = new OfferRegister();
        offerRegister.setEndDate(offerRequest.getEndDate());
        offerRegister.setStartDate(offerRequest.getStartDate());
        offerRegister.setPercentage(offerRequest.getPercentage());
        offerRegister.setProductId(productId);
        Date date = new Date();
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

    public ProductSpecificResponse productInfo(Integer productId) {
        ProductSpecificResponse product = productDao.productsDetails(productId);
        LOGGER.warn(product.toString());
        CategoryRequest category = categoryDao.getCategoryByProductId(productId);
        List<MediaRequest> media = mediaDao.listmedia(productId);
        LOGGER.warn(media.toString());
        Stock stock = stockDao.getStockById(productId);
        LOGGER.warn(stock.toString());
        product.setCategory(category);
        List<String> mediaResult = new ArrayList<>();
        media.forEach(mediaRequest -> {
            mediaResult.add(mediaRequest.getPhoto());
        });
        product.setImagesUrl(mediaResult);
        if (product.getPercentage() == null) {
            product.setPercentage(0);
        }
        product.setUnit(stock.getInStock());

        return product;
    }

    public void productDelete(Integer productId) {
        productDao.deleteProduct(productId);
    }

    public List<OfferRequest> productOffers(Integer id) {
        return offerRegisterDao.getOffersByProduct(id);
    }

    public PageInfo<ProductResponse> listproductsearch(String buscar, Integer idPerson, Integer page, Integer size) {
        BranchOffice branchOffice = branchOfficeDao.getBranchByPersonManagerId(idPerson);
        if (branchOffice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find branch");
        }
        PageHelper.startPage(page, size); //line 1
        List<ProductResponse> productsearch = productDao.productsearch(buscar, branchOffice.getBranchOfficeId());
        return new PageInfo(productsearch);
    }

    public PageInfo<ProductResponse> findPaginated(Integer page, Integer size) {
        PageHelper.startPage(page, size); //line 1
//        Page<ProductResponse> productResponses= productDao.listpaginate(1);
        List<ProductResponse> page1 = productDao.listpaginate(1);
        return new PageInfo(page1);
    }

    public ProductRequest update(ProductRequest productRequest, Integer person, Integer productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription().trim());
        product.setName(productRequest.getName().trim());

        if (product.getName().trim().length() == 0 || product.getDescription().trim().length() == 0) {
            return null;
        } else {
            productDao.updateProduct(product);
            return productRequest;
        }
    }

}
