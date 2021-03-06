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
    List<UserResponse> getUsers(String search);

    //Get last user id added
    public Integer getLastUserId();

    //Get a specific user by user id
    UserResponse getUserById(Integer userId);

    // Change status user by user id
    void changeStatusUser(Integer status, Integer userId);
}
