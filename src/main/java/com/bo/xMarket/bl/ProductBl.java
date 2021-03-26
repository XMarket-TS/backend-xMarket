package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CategoryDao;
import com.bo.xMarket.dao.MediaDao;
import com.bo.xMarket.dao.ProductBranchDao;
import com.bo.xMarket.dao.ProductDao;
import com.bo.xMarket.dto.MediaRequest;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private ProductBranchDao productBranchDao;
    private MediaDao mediaDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBl.class);

    @Autowired
    public ProductBl(ProductDao productDao, CategoryDao categoryDao, ProductBranchDao productBranchDao,MediaDao mediaDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.productBranchDao = productBranchDao;
        this.mediaDao = mediaDao;
    }

    public List<ProductResponse> productList(Integer id, Integer idbranch){
        return productDao.listproducts(id,idbranch);
    }

    public Product addProduct(ProductRequest productRequest,Integer idbranch, Transaction transaction){
        Product product= new Product();
        Category category=new Category();

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
        Integer lastProductId =productDao.getLastInsertId();

        if(productRequest.getOffer()!=null){
            addOffer(productRequest.getOffer());
        }
        if(productRequest.getImagesUrl().size()>0){

            addMedia(productRequest.getImagesUrl(),lastProductId,transaction);
        }
        addProductBranch(lastProductId,idbranch);

        return product;
    }
    public void addProductBranch(Integer lastProductId,Integer idbranch){
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductId(lastProductId);
        productBranch.setBranchOfficeId(idbranch);
        productBranchDao.addProductBranch(productBranch);
    }
    public void addOffer(OfferRequest offerRequest){

    }
    public void addMedia(List<MediaRequest> listMedia,Integer productId,Transaction transaction){
        listMedia.forEach(mediaRequest -> {
            Media media= new Media();
            media.setPhoto(mediaRequest.getPhoto());
            media.setProductId(productId);
            media.setStatus(0);
            media.setTransaction(transaction);
            mediaDao.addMedia(media);
        });
    }

    public Product productInfo(Integer productid){
        return productDao.productsdetails(productid);
    }

    public void productDelete(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
