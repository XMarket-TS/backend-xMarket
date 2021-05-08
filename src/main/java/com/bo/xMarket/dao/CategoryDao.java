package com.bo.xMarket.dao;

import com.bo.xMarket.dto.CategoryRequest;
import com.bo.xMarket.model.Category;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    //
    void addcategory(Category category);

    //
    Integer getLastInsertId();

    //
    List<CategoryRequest> listcategory();

    //
    Category getCategoryById(Integer categoryId);

    //
    CategoryRequest getCategoryByProductId(Integer productId);

    // Find id category by name
    Integer getCategoryIdByName(String category);
}
