package com.bo.xMarket.api;

import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.bl.UserBl;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserApi {
    private UserBl userBl;
    private TransactionBl transactionBl;

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public User adduser(@RequestBody UserRequest userRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        User userResponse=userBl.addUser(userRequest,transaction);
        return userResponse;
    }

    @RequestMapping(value = "/manager/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerRequest userSignUp(@RequestBody LoginRequest LoginRequest) {
        return userBl.managerLogin(LoginRequest);
    }
}
