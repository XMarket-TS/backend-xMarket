package com.bo.xMarket.dao;

import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public List<ProductResponse> listproductsbycategory(Integer id, Integer idbranch,Integer idcategory);
    public List<Product> listProductsByBranch(Integer idbranch);

    public void addproduct(Product product);

    public Product productsDetails(Integer productid);

    public Integer getLastInsertId();

    //Delete the product logically
    public void deleteProduct(Integer productId);

    //  Get First Image
    public String getFirstImageByProductId(Integer productId);
}
