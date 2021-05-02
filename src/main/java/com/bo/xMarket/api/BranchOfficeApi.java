package com.bo.xMarket.api;

import com.bo.xMarket.bl.BranchOfficeBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.BranchOfficeRequest;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/branchOffice")
public class BranchOfficeApi {
    private final BranchOfficeBl branchOfficeBl;
    private final TransactionBl transactionBl;

    @Autowired
    public BranchOfficeApi(BranchOfficeBl branchOfficeBl, TransactionBl transactionBl) {
        this.branchOfficeBl = branchOfficeBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BranchOfficeRequest addbranchoffice(@RequestBody BranchOfficeRequest branchOfficeRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return branchOfficeBl.addBranchOffice(branchOfficeRequest, transaction);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BranchOfficeRequest> branchOfficeList() {
        return branchOfficeBl.branchOfficeList();
    }

    @RequestMapping(value = "/zones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> zonesWithBranchOffice() {
        return branchOfficeBl.zonesList();
    }

    @RequestMapping(value = "/list/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BranchOfficeRequest> branchOfficeListAll() {
        return branchOfficeBl.branchOfficeListAll();
    }

    @RequestMapping(value = "branch/{branchId}/{status}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeStatus(@PathVariable("branchId") Integer branchId, @PathVariable("status") Integer status) {
        branchOfficeBl.changeBranchStatus(branchId, status);
    }
}
