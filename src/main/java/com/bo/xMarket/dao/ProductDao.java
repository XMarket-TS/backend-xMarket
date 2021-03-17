package com.bo.xMarket.dao;

import com.bo.xMarket.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public List<Product> listproducts(Integer id);
}
