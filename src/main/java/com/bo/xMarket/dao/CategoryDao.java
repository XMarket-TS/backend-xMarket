package com.bo.xMarket.dao;

import com.bo.xMarket.dto.CategoryRequest;
import com.bo.xMarket.model.Category;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    //
    public void addcategory(Category category);

    //
    public Integer getLastInsertId();

    //
    public List<CategoryRequest> listcategory();

    //
    public Category getCategoryById(Integer categoryId);

    //
    CategoryRequest getCategoryByProductId(Integer productId);
}
