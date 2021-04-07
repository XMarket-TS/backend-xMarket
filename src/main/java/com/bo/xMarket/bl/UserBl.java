package com.bo.xMarket.bl;

import com.bo.xMarket.dao.ManagerDao;
import com.bo.xMarket.dao.PersonDao;
import com.bo.xMarket.dao.UserDao;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Person;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserBl {
    private UserDao userDao;
    private PersonDao personDao;
    private ManagerDao managerDao;

    @Autowired
    public UserBl(UserDao userDao, PersonDao personDao, ManagerDao managerDao) {
        this.userDao = userDao;
        this.personDao = personDao;
        this.managerDao = managerDao;
    }

    public User addUser(UserRequest userRequest, Transaction transaction) {
        Person person = new Person();
        person.setName(userRequest.getName());
        person.setSurname(userRequest.getSurname());
        person.setEmail(userRequest.getEmail());
        person.setStatus(1);
        person.setTxDate(transaction.getTxDate());
        personDao.addPerson(person);
        Integer lastPersonId = personDao.getLastPersonId();
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setPersonId(lastPersonId);
        user.setStatus(1);
        user.setTransaction(transaction);
        userDao.addUser(user);
        return user;
    }

    public ManagerRequest managerLogin(LoginRequest loginRequest) {
        if (loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find user");
        }
        Person person = managerDao.findManagerByLogin(loginRequest);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find user");
        }

        ManagerRequest managerRequest = new ManagerRequest();
        managerRequest.setPersonId(person.getPersonId());
        managerRequest.setName(person.getName());
        managerRequest.setSurname(person.getSurname());
        managerRequest.setEmail(person.getEmail());
        managerRequest.setUserPhoto(person.getPhoto());
        managerRequest.setDescription(person.getDescription());
        managerRequest.setCellphone(person.getCellphone());
        managerRequest.setGender(person.getGender());
        managerRequest.setUsername(loginRequest.getUsername());
        managerRequest.setPassword("");
        return managerRequest;
    }
}
