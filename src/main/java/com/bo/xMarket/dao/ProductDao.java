package com.bo.xMarket.dao;

import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public List<ProductResponse> listproducts(Integer id, Integer idbranch);

    public void addproduct(Product product);

    public Product productsdetails(Integer productid);

    public Integer getLastInsertId();

    //Delete the product logically
    public void deleteProduct(Integer productId);
}
