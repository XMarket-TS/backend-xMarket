package com.bo.xMarket.bl;

import com.bo.xMarket.dao.AdminDao;
import com.bo.xMarket.dao.PersonDao;
import com.bo.xMarket.dto.AdminRequest;
import com.bo.xMarket.dto.LoginRequest;
import com.bo.xMarket.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminBl {
    private final AdminDao adminDao;
    private final PersonDao personDao;

    @Autowired
    public AdminBl(AdminDao adminDao, PersonDao personDao) {
        this.adminDao = adminDao;
        this.personDao = personDao;
    }

    public AdminRequest adminLogin(LoginRequest loginRequest) {
        if (loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find user");
        }
        Person person = adminDao.findAdminByLogin(loginRequest);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not available");
        }
        AdminRequest adminRequest = new AdminRequest();
        adminRequest.setPersonId(person.getPersonId());
        adminRequest.setName(person.getName());
        adminRequest.setSurname(person.getSurname());
        adminRequest.setEmail(person.getEmail());
        adminRequest.setUserPhoto(person.getPhoto());
        adminRequest.setDescription(person.getDescription());
        adminRequest.setCellphone(person.getCellphone());
        adminRequest.setGender(person.getGender());
        adminRequest.setUsername(loginRequest.getUsername());
        adminRequest.setPassword("");
        return adminRequest;
    }

    public AdminRequest infoManager(Integer id) {
        AdminRequest adminRequest = new AdminRequest();
        Person person = personDao.getPersonById(id);
        adminRequest.setPersonId(id);
        adminRequest.setPersonId(person.getPersonId());
        adminRequest.setName(person.getName());
        adminRequest.setSurname(person.getSurname());
        adminRequest.setEmail(person.getEmail());
        adminRequest.setUserPhoto(person.getPhoto());
        adminRequest.setDescription(person.getDescription());
        adminRequest.setCellphone(person.getCellphone());
        adminRequest.setGender(person.getGender());
        adminRequest.setUsername("Username");
        return adminRequest;
    }

}
