package com.bo.xMarket.api;

import com.bo.xMarket.bl.MediaBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.MediaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
