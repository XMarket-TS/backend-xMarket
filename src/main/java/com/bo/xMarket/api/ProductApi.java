package com.bo.xMarket.api;

import com.bo.xMarket.bl.ProductBl;
import com.bo.xMarket.bl.TransactionBl;

import com.bo.xMarket.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/{userid}")
public class ProductApi {
    private ProductBl productBl;
    private TransactionBl transactionBl;
    
    @Autowired
    public ProductApi(ProductBl productBl, TransactionBl transactionBl) {
        this.productBl = productBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/product",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> products(@PathVariable("userid") Integer id) {
        return productBl.productList(id);
    }
}
