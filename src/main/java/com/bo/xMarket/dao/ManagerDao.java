package com.bo.xMarket.dao;

import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.ManagerResponse;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerDao {
    //
    public void addManager(Manager manager);

    // Login Manager
    public Person findManagerByLogin(LoginRequest loginRequest);

    // List all manager with status 1
    List<ManagerResponse> getListOfManagers();

    // Get manager's info for public spaces
    ManagerResponse getInfoManager(Integer managerId);
}
