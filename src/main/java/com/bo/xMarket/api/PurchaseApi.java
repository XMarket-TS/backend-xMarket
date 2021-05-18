package com.bo.xMarket.api;


import com.bo.xMarket.bl.PurchaseBl;
import com.bo.xMarket.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class PurchaseApi {
    private final PurchaseBl purchaseBl;

    @Autowired
    public PurchaseApi(PurchaseBl purchaseBl) {
        this.purchaseBl = purchaseBl;
    }

    @RequestMapping(value = "/total/branch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthlySaleBranchResponse> totalSaleBranchList() {
        return purchaseBl.totalSalesBranch();
    }

    @RequestMapping(value = "/total/branch/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthlySaleBranchResponse> totalProductsBranchList() {
        return purchaseBl.productsSold();
    }

    @RequestMapping(value = "/daily/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SalesResponse> dailySales() {
        return purchaseBl.dailySales();
    }

    @RequestMapping(value = "/total/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BranchSalesResponse> dailySalesAllBranchs() {
        return purchaseBl.dailySalesAllBranchs();
    }

    @RequestMapping(value = "/most/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> mostSelledProducts() {
        return purchaseBl.mostSelledProducts();
    }

    @RequestMapping(value = "/less/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> lessSoldProducts() {
        return purchaseBl.lessSoldProducts();
    }

//    @RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public UserResponse listOfUsers(@PathVariable("userid") Integer userId) {
//        return userBl.getuserbyid(userId);
//    }


}
