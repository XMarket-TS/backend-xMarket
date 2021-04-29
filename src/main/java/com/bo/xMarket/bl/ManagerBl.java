package com.bo.xMarket.bl;

import com.bo.xMarket.dao.ManagerDao;
import com.bo.xMarket.dao.PersonDao;
import com.bo.xMarket.dao.TransactionDao;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.dto.ManagerRequest;
import com.bo.xMarket.dto.ManagerResponse;
import com.bo.xMarket.model.Manager;
import com.bo.xMarket.model.Person;
import com.bo.xMarket.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ManagerBl {
    private ManagerDao managerDao;
    private PersonDao personDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBl.class);

    @Autowired
    public ManagerBl(ManagerDao managerDao, PersonDao personDao, TransactionDao transactionDao) {
        this.managerDao = managerDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
    }

    public ManagerRequest addManager(ManagerRequest managerRequest, Transaction transaction) {
        LOGGER.warn(managerRequest.toString());
        transaction.setTxId(transactionDao.getLastInsertId());
        Person person = new Person();
        person.setName(managerRequest.getName());
        person.setSurname(managerRequest.getSurname());
        person.setEmail(managerRequest.getEmail());
        person.setDescription(managerRequest.getDescription());
        person.setPhoto(managerRequest.getUserPhoto());
        person.setGender(managerRequest.getGender());
        person.setCellphone(managerRequest.getCellphone());
        person.setStatus(1);
        person.setTransaction(transaction);
        personDao.addPerson(person);
        Integer lastPersonId = personDao.getLastPersonId();
        managerRequest.setPersonId(lastPersonId);
        Manager manager = new Manager();
        manager.setUsername(managerRequest.getUsername());
        manager.setPassword(managerRequest.getPassword());
        manager.setPersonId(lastPersonId);
        manager.setStatus(1);
        manager.setTransaction(transaction);
        managerDao.addManager(manager);
        return managerRequest;
    }

    public ManagerRequest managerLogin(LoginRequest loginRequest) {
        if (loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find user");
        }
        Person person = managerDao.findManagerByLogin(loginRequest);

        if (person == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not available");
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

    public List<ManagerResponse> listOfManagers() {
        return managerDao.getListOfManagers();
    }

    public ManagerResponse getInfoManager(Integer managerId) {
        return managerDao.getInfoManager(managerId);
    }
}
