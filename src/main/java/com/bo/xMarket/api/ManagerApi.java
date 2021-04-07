package com.bo.xMarket.api;

import com.bo.xMarket.bl.ManagerBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Manager addManager(@RequestBody ManagerRequest managerRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Manager managerResponse = managerBl.addManager(managerRequest, transaction);
        return managerResponse;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerRequest userSignUp(@RequestBody LoginRequest LoginRequest) {
        return managerBl.managerLogin(LoginRequest);
    }

    @RequestMapping(value = "/login/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManagerRequest getInfoManager(@PathVariable("personId") Integer id) {
        return managerBl.infoManager(id);
    }
}
