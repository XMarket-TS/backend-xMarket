package com.bo.xMarket.api;

import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.bl.UserBl;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.dto.UserResponse;
import com.bo.xMarket.model.Person;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import com.bo.xMarket.util.TransactionUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserApi {
    private final UserBl userBl;
    private final TransactionBl transactionBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return userBl.addUser(userRequest, transaction);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse loginUser(@RequestBody LoginRequest user1, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return userBl.login(user1);
    }

    @RequestMapping(value = "/list", params = {"search", "page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<UserResponse> listOfUsers(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("search") String user) {
        String search = user + "%";
        return userBl.getListOfUsers(page, size, search);
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse listOfUsers(@PathVariable("userid") Integer userId) {
        return userBl.getuserbyid(userId);
    }

    @RequestMapping(value = "/status/{userid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse changeStatusUser(@PathVariable("userid") Integer userId) {
        return userBl.changeStatusUser(userId);
    }
}
