package com.bo.xMarket.api;

import com.bo.xMarket.bl.ManagerBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/manager")
public class ManagerApi {
    private ManagerBl managerBl;
    private TransactionBl transactionBl;

    @Autowired
    public ManagerApi(ManagerBl managerBl, TransactionBl transactionBl) {
        this.managerBl = managerBl;
        this.transactionBl = transactionBl;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manager addManager(@RequestBody ManagerRequest managerRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Manager managerResponse=managerBl.addManager(managerRequest,transaction);
        return managerResponse;
    }
}
