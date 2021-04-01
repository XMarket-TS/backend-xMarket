package com.bo.xMarket.api;

import com.bo.xMarket.bl.CategoryBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.CategoryRequest;
import com.bo.xMarket.dto.MediaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryApi {
    private CategoryBl categoryBl;
    private TransactionBl transactionBl;

    @Autowired
    public CategoryApi(CategoryBl categoryBl, TransactionBl transactionBl) {
        this.categoryBl = categoryBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryRequest> categorylist() {
        return categoryBl.categoryList();
    }
}
