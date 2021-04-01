package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CategoryDao;
import com.bo.xMarket.dto.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryBl {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryBl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryRequest> categoryList(){
       return categoryDao.listcategory();
    }
}
