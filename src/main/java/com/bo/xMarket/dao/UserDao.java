package com.bo.xMarket.dao;

import com.bo.xMarket.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void addUser(User user);
}
