package com.bo.xMarket.dao;

import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    public Person findAdminByLogin(LoginRequest loginRequest);

}
