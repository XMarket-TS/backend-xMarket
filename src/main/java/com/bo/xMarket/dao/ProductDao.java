package com.bo.xMarket.dao;

import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.dto.ProductSpecificResponse;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Stock;
import com.github.pagehelper.Page;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    //
    public List<ProductResponse> listProductsByCategory(Integer id, Integer idbranch, Integer idcategory);

    //
    public List<Product> listProductsByBranch(Integer idbranch); //(Frontend web)

    //
    public List<ProductResponse> listProductsByBranchId(Integer idbranch);//(Frontend movil)

    //
    public void addproduct(Product product);

    //
    public ProductSpecificResponse productsDetails(Integer productId);

    //
    public Integer getLastInsertId();

    //Delete the product logically
    public void deleteProduct(Integer productId);

    //  Get First Image
    public String getFirstImageByProductId(Integer productId);

    // Get Stock by ProductId
    public Stock getStock(Integer productId);

    //
    public Page<ProductResponse> productsearch(String search, Integer branchId);

    //
    public List<ProductResponse> listpaginate(Integer idbranch);

    //
    public void updateProduct(Product product);

    // Search product by name (Movil)
    public List<ProductResponse> movilSearch(String product, Integer categoryId, Integer branchId);

    // Get product details by hash
    ProductResponse getProductByHash(String hash);
}
