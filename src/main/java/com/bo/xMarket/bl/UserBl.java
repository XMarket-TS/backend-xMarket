package com.bo.xMarket.bl;

import com.bo.xMarket.dao.PersonDao;
import com.bo.xMarket.dao.UserDao;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.dto.UserResponse;
import com.bo.xMarket.model.Person;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {
    private final UserDao userDao;
    private final PersonDao personDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBl.class);
    @Autowired
    public UserBl(UserDao userDao, PersonDao personDao) {
        this.userDao = userDao;
        this.personDao = personDao;
    }

    public UserResponse addUser(UserRequest userRequest, Transaction transaction) {
        Person person = new Person();
        person.setName(userRequest.getName());
        person.setSurname(userRequest.getSurname());
        person.setEmail(userRequest.getEmail());
        person.setGender(userRequest.getGender());
        person.setPhoto(userRequest.getUserPhoto());
        person.setStatus(1);
        person.setTransaction(transaction);
        person.setCellphone(userRequest.getCellphone());
        personDao.addPerson(person);
        Integer lastPersonId = personDao.getLastPersonId();
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setPersonId(lastPersonId);
        user.setStatus(1);
        user.setTransaction(transaction);
        userDao.addUser(user);
        Integer lastUserId= userDao.getLastUserId();
        UserResponse userResponse= userDao.getUserById(lastUserId);
        return userResponse;
    }

    public UserResponse login(LoginRequest user) {
        User user1 = new User();
        UserResponse userInfo = new UserResponse();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        User x = userDao.findUserByNP(user1);
        if (x != null) {

            Person person = personDao.getPersonById(userDao.findUserByNP(user1).getPersonId());
            userInfo.setUserId(x.getUserId());
            userInfo.setPersonUserId(person.getPersonId());
            userInfo.setUsername(x.getUsername());
            userInfo.setCellphone(person.getCellphone());
            userInfo.setPhoto(person.getPhoto());
            userInfo.setEmail(person.getEmail());
            userInfo.setName(person.getName());
            userInfo.setSurname(person.getSurname());
            userInfo.setStatus(x.getStatus());
            return userInfo;

        } else {
            return null;
        }


    }


    public List<UserResponse> getListOfUsers() {
        return userDao.getUsers();
    }

    public UserResponse getuserbyid(Integer userId) {
        return userDao.getUserById(userId);
    }

    public UserResponse changeStatusUser(Integer userId) {
        UserResponse user = userDao.getUserById(userId);
        LOGGER.warn(user.toString());
        if (user.getStatus() == 1) {
            userDao.changeStatusUser(0, userId);
        } else {
            userDao.changeStatusUser(1, userId);
        }
        user = userDao.getUserById(userId);
        return user;
    }
}
