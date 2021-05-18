package com.bo.xMarket.bl;

import com.bo.xMarket.dao.*;
import com.bo.xMarket.dto.*;
import com.bo.xMarket.model.*;
import com.bo.xMarket.util.MD5Util;
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

    public List<ProductResponse> productListbyCategory(Integer id, Integer idbranch, Integer idcategory, Integer page, Integer size) {
        PageHelper.startPage(page, size); //line 1
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

    public Product addProduct(Integer personId, ProductRequest productRequest, Transaction transaction) {
        Product product = new Product();
        Integer categoryId = categoryDao.getCategoryIdByName(productRequest.getCategory());
        String qr = MD5Util.string2MD5(productRequest.toString());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setWeight(0.0);
        product.setStatus(1);
        product.setTransaction(transaction);
        product.setProductCategoryId(categoryId != null ? categoryId : 0);
        product.setQrHash(qr);
        productDao.addproduct(product);

        Integer lastProductId = productDao.getLastInsertId();

        Stock stock = new Stock();
        stock.setInStock(productRequest.getUnit());
        stock.setProductId(lastProductId);
        stock.setLastUpdate(new Date());
        stockDao.addStock(stock);
        if (productRequest.getImagesUrl().size() > 0) {
            addMedia(productRequest.getImagesUrl(), lastProductId, transaction);
        }

        BranchOffice branchOffice = branchOfficeDao.getBranchByPersonManagerId(personId);
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductId(lastProductId);
        productBranch.setBranchOfficeId(branchOffice.getBranchOfficeId());
        productBranchDao.addProductBranch(productBranch);

        return product;
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

    public ProductRequest update(ProductRequest productRequest, Integer personId, Integer productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription().trim());
        product.setName(productRequest.getName().trim());
        product.setTxUserId(personId);
        if (product.getName().trim().length() == 0 || product.getDescription().trim().length() == 0) {
            return null;
        } else {
            productDao.updateProduct(product);
            return productRequest;
        }
    }

    public List<ProductResponse> searchmovil(String product, Integer categoryId, Integer branchId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<ProductResponse> pagex = productDao.movilSearch(product, categoryId, branchId);
        return pagex;
    }

    public ProductResponse findProductByHash(String hash) {
        return productDao.getProductByHash(hash);
    }
}
