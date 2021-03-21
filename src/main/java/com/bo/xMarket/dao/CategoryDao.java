package com.bo.xMarket.dao;

import com.bo.xMarket.model.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao {
    public void addcategory(Category category);
    public Integer getLastInsertId();
}
