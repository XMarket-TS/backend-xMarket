package com.bo.xMarket.model;

import java.util.Date;

public class Person extends Transaction {
    private Integer personId;
    private String name;
    private String surname;
    private String email;
    private String description;
    private String gender;
    private String photo;
    private String cellphone;
    private Integer status;

    public Person(Integer txId, String txHost, Integer txUserId, Date txDate, Integer personId, String name, String surname, String email, String description, String gender, String photo, String cellphone, Integer status) {
        super(txId, txHost, txUserId, txDate);
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.gender = gender;
        this.photo = photo;
        this.cellphone = cellphone;
        this.status = status;
    }

    public Person(Integer personId, String name, String surname, String email, String description, String gender, String photo, String cellphone, Integer status) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.gender = gender;
        this.photo = photo;
        this.cellphone = cellphone;
        this.status = status;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", cellphone=" + cellphone +
                ", status=" + status +
                '}';
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

