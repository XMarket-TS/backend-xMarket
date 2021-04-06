package com.bo.xMarket.dto;

public class ManagerRequest {
    private Integer personId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String userPhoto;
    private String description;
    private String cellphone;
    private String gender;
    private String password;

    public ManagerRequest(Integer personId, String name, String surname, String username, String email, String userPhoto, String description, String cellphone, String gender, String password) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.userPhoto = userPhoto;
        this.description = description;
        this.cellphone = cellphone;
        this.gender = gender;
        this.password = password;
    }

    public ManagerRequest() {
    }

    @Override
    public String toString() {
        return "ManagerRequest{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", description='" + description + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
