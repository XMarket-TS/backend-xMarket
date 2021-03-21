package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CategoryDao;
import com.bo.xMarket.dao.ProductDao;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Category;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private CategoryDao categoryDao;


    @Autowired
    public ProductBl(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public List<Product> productList(Integer id){
        return productDao.listproducts(id);
    }

    public Product addProduct(ProductRequest productRequest, Transaction transaction){
        Product product= new Product();
        Category category=new Category();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setWeight(productRequest.getWeight());
        product.setStatus(1);
        product.setTransaction(transaction);
        category.setName(productRequest.getCategory());
        category.setStatus(1);
        category.setTransaction(transaction);
        categoryDao.addcategory(category);
        Integer lastIdCategory = categoryDao.getLastInsertId();
        product.setProductCategoryId(lastIdCategory);
        productDao.addproduct(product);
        return product;
    }

    public Product productInfo(Integer productid){
        return productDao.productsdetails(productid);
    }
}
