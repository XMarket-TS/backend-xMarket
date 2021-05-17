package com.bo.xMarket.api;

import com.bo.xMarket.bl.OfferBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "offer")
public class OfferApi {
    private final OfferBl offerBl;
    private final TransactionBl transactionBl;

    @Autowired
    public OfferApi(OfferBl offerBl, TransactionBl transactionBl) {
        this.offerBl = offerBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfferRequest> productOffers(@PathVariable("productid") Integer id) {
        return offerBl.productOffers(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OfferRequest createOffer(@RequestBody OfferRequest offerRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return offerBl.create(offerRequest, transaction);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public OfferRequest updateOffer(@RequestBody OfferRequest offerRequest) {
         return offerBl.updateOffer(offerRequest);
    }

    @RequestMapping(value = "/delete/{offerId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOffer(@PathVariable("offerId") Integer offerId) {
        offerBl.deleteOffer(offerId);
    }


}
