package com.bo.xMarket.api;

import com.bo.xMarket.bl.CategoryBl;
import com.bo.xMarket.dto.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryApi {
    private final CategoryBl categoryBl;

    @Autowired
    public CategoryApi(CategoryBl categoryBl) {
        this.categoryBl = categoryBl;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryRequest> categorylist() {
        return categoryBl.categoryList();
    }
}
