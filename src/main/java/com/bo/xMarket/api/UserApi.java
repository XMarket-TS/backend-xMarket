package com.bo.xMarket.api;

import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.bl.UserBl;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.model.Person;
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
@RequestMapping(value = "/user")
public class UserApi {
    private final UserBl userBl;
    private final TransactionBl transactionBl;

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return userBl.addUser(userRequest, transaction);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person loginUser(@RequestBody LoginRequest user1, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return userBl.login(user1);
    }
}
