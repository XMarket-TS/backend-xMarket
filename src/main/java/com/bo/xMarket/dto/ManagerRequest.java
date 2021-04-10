package com.bo.xMarket.dto;

import javax.validation.constraints.*;

public class ManagerRequest {
    private Integer personId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    private String userPhoto;
    private String description;
    private String cellphone;
    @NotBlank(message = "Gender is mandatory")
    private String gender;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 20, message
            = "About Me must be between 8 and 20 characters")
    private String password;


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
