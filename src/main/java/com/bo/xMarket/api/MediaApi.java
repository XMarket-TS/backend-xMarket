package com.bo.xMarket.api;

import com.bo.xMarket.bl.MediaBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.MediaRequest;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/media")
public class MediaApi {
    private MediaBl mediaBl;
    private TransactionBl transactionBl;

    @Autowired
    public MediaApi(MediaBl mediaBl, TransactionBl transactionBl) {
        this.mediaBl = mediaBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/product/{productid}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MediaRequest> medialist(@PathVariable("productid") Integer idproduct) {
        return mediaBl.mediaList(idproduct);
    }

}
