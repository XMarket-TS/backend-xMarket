package com.bo.xMarket.api;

import com.bo.xMarket.bl.PurchaseBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.dto.PurchaseRequest;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping(value = "/purchase")
public class PurchaseApi {
    private PurchaseBl purchaseBl;
    private TransactionBl transactionBl;

    @Autowired
    public PurchaseApi(PurchaseBl purchaseBl, TransactionBl transactionBl) {
        this.purchaseBl = purchaseBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PurchaseRequest buyProduct(@PathVariable("userId") Integer userId, @RequestBody PurchaseRequest purchaseRequestList, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return purchaseBl.buyProducts(userId, purchaseRequestList, transaction);
    }
}
