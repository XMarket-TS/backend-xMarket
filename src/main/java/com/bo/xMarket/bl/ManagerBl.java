package com.bo.xMarket.bl;

import com.bo.xMarket.dao.ManagerDao;
import com.bo.xMarket.dao.PersonDao;
import com.bo.xMarket.dao.UserDao;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.UserRequest;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Person;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerBl {
    private ManagerDao managerDao;
    private PersonDao personDao;

    @Autowired
    public ManagerBl(ManagerDao managerDao, PersonDao personDao) {
        this.managerDao = managerDao;
        this.personDao = personDao;
    }

    public Manager addManager(ManagerRequest managerRequest, Transaction transaction){
        Person person = new Person();
        person.setName(managerRequest.getName());
        person.setSurname(managerRequest.getSurname());
        person.setEmail(managerRequest.getEmail());
        person.setStatus(1);
        person.setTransaction(transaction);
        personDao.addPerson(person);
        Integer lastPersonId= personDao.getLastPersonId();
        Manager manager = new Manager();
        manager.setUsername(managerRequest.getUsername());
        manager.setPassword(managerRequest.getPassword());
        manager.setPersonId(lastPersonId);
        manager.setStatus(1);
        manager.setTransaction(transaction);
        managerDao.addManager(manager);
        return manager;
    }
}
