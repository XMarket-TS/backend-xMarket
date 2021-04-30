package com.bo.xMarket.api;

import com.bo.xMarket.bl.OfferBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "offer")
public class OfferApi {
    private OfferBl offerBl;
    private TransactionBl transactionBl;

    @Autowired
    public OfferApi(OfferBl offerBl, TransactionBl transactionBl) {
        this.offerBl = offerBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OfferRequest updateoffer(@RequestBody OfferRequest offerRequest){
        return offerBl.update(offerRequest);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OfferRequest create(@RequestBody OfferRequest offerRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return offerBl.create(offerRequest,transaction);
    }

}
