package com.bo.xMarket.dao;

import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDao {
    public void addManager(Manager manager);

    // Login Manager
    public Person findManagerByLogin(LoginRequest loginRequest);
}
