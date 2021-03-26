package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CategoryDao;
import com.bo.xMarket.dao.ProductBranchDao;
import com.bo.xMarket.dao.ProductDao;
import com.bo.xMarket.dto.MediaRequest;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Category;
import com.bo.xMarket.model.ProductBranch;
import com.bo.xMarket.model.Transaction;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private ProductBranchDao productBranchDao;


    @Autowired
    public ProductBl(ProductDao productDao, CategoryDao categoryDao, ProductBranchDao productBranchDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.productBranchDao = productBranchDao;
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
//        if(productRequest.getImagesUrl().size()>0){
//            addMedia(productRequest.getImagesUrl());
//        }
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
    public void addMedia(List<MediaRequest> listMedia){

    }

    public Product productInfo(Integer productid){
        return productDao.productsdetails(productid);
    }

    public void productDelete(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
