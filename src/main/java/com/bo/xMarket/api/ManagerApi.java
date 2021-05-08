package com.bo.xMarket.api;

import com.bo.xMarket.bl.ManagerBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.ManagerResponse;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/manager")
public class ManagerApi {
    private final ManagerBl managerBl;
    private final TransactionBl transactionBl;

    @Autowired
    public ManagerApi(ManagerBl managerBl, TransactionBl transactionBl) {
        this.managerBl = managerBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/register/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ManagerRequest addManager(@Valid @RequestBody ManagerRequest managerRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return managerBl.addManager(managerRequest, transaction);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerRequest loginManager(@RequestBody LoginRequest LoginRequest) {
        return managerBl.managerLogin(LoginRequest);
    }

    @RequestMapping(value = "/login/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManagerRequest getManager(@PathVariable("personId") Integer id) {
        return managerBl.infoManager(id);
    } // TODO: Change to OAuth with Auth0

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ManagerResponse> getManagers() {
        return managerBl.listOfManagers();
    }

    @RequestMapping(value = "/info/{managerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ManagerResponse getInfoManager(@PathVariable("managerId") Integer managerId) {
        return managerBl.getInfoManager(managerId);
    }

}
