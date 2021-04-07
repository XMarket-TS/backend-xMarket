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
public class ManagerBl {
    private ManagerDao managerDao;
    private PersonDao personDao;

    @Autowired
    public ManagerBl(ManagerDao managerDao, PersonDao personDao) {
        this.managerDao = managerDao;
        this.personDao = personDao;
    }

    public Manager addManager(ManagerRequest managerRequest, Transaction transaction) {
        Person person = new Person();
        person.setName(managerRequest.getName());
        person.setSurname(managerRequest.getSurname());
        person.setEmail(managerRequest.getEmail());
        person.setStatus(1);
        person.setTransaction(transaction);
        personDao.addPerson(person);
        Integer lastPersonId = personDao.getLastPersonId();
        Manager manager = new Manager();
        manager.setUsername(managerRequest.getUsername());
        manager.setPassword(managerRequest.getPassword());
        manager.setPersonId(lastPersonId);
        manager.setStatus(1);
        manager.setTransaction(transaction);
        managerDao.addManager(manager);
        return manager;
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
        setPerson(managerRequest, person);
        managerRequest.setUsername(loginRequest.getUsername());
        managerRequest.setPassword("");
        return managerRequest;
    }

    public ManagerRequest infoManager(Integer id) {
        ManagerRequest managerRequest = new ManagerRequest();
        Person person = personDao.getPersonById(id);
        managerRequest.setPersonId(id);
        setPerson(managerRequest, person);
        managerRequest.setUsername("Username");
        return managerRequest;
    }

    private void setPerson(ManagerRequest managerRequest, Person person) {
        managerRequest.setPersonId(person.getPersonId());
        managerRequest.setName(person.getName());
        managerRequest.setSurname(person.getSurname());
        managerRequest.setEmail(person.getEmail());
        managerRequest.setUserPhoto(person.getPhoto());
        managerRequest.setDescription(person.getDescription());
        managerRequest.setCellphone(person.getCellphone());
        managerRequest.setGender(person.getGender());
    }
}
