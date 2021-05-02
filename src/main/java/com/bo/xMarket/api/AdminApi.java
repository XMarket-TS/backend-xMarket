package com.bo.xMarket.api;

import com.bo.xMarket.bl.AdminBl;
import com.bo.xMarket.dto.AdminRequest;
import com.bo.xMarket.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminApi {
    private final AdminBl adminBl;

    @Autowired
    public AdminApi(AdminBl adminBl) {
        this.adminBl = adminBl;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AdminRequest userSignUp(@RequestBody LoginRequest LoginRequest) {
        return adminBl.adminLogin(LoginRequest);
    }

    @RequestMapping(value = "/login/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminRequest getInfoManager(@PathVariable("personId") Integer id) {
        return adminBl.infoManager(id);
    }
}
