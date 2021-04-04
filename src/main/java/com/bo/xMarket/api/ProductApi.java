package com.bo.xMarket.api;

import com.bo.xMarket.bl.ProductBl;
import com.bo.xMarket.bl.TransactionBl;

import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.Product;

import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "")
public class ProductApi {
    private ProductBl productBl;
    private TransactionBl transactionBl;

    @Autowired
    public ProductApi(ProductBl productBl, TransactionBl transactionBl) {
        this.productBl = productBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/user/{userid}/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> ListProducts(@PathVariable("userid") Integer id) {
        return productBl.productList(id);
    }

    @RequestMapping(value = "/admin/{userid}/branchOffice/{branchoffice}/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addproduct(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch, @RequestBody ProductRequest productRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Product productResponse = productBl.addProduct(productRequest, idbranch, transaction);
        return productResponse;
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductRequest productInfo(@PathVariable("productid") Integer id) {
        return productBl.productInfo(id);
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void productDelete(@PathVariable("productid") Integer productid, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        productBl.productDelete(productid);
    }

}
