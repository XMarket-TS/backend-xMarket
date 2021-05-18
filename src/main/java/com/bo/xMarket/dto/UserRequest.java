package com.bo.xMarket.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Name is mandatory")
    private String surname;
    @NotBlank(message = "Name is mandatory")
    private String username;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    @NotBlank(message = "Gender is mandatory")
    private String gender;
    private String userPhoto;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 20, message
            = "About Me must be between 8 and 20 characters")
    private String password;
    @NotBlank(message = "Cellphone is mandatory")
    private String cellphone;

    public UserRequest() {
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
