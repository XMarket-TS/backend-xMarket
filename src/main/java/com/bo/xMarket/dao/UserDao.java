package com.bo.xMarket.dao;

import com.bo.xMarket.dto.UserResponse;
import com.bo.xMarket.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    //
    public void addUser(User user);

    //
    User findUserByNP(User user1);

    // Get list of all users
    List<UserResponse> getUsers();

    //Get a specific user by user id
    UserResponse getUserById(Integer userId);
}
