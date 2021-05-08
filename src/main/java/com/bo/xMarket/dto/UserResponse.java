package com.bo.xMarket.dto;

public class UserResponse {
    private Integer userId;
    private String name;
    private String surname;
    private Integer status;
    private String photo;
    private String email;

    public UserResponse(Integer userId, String name, String surname, Integer status, String photo, String email) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.photo = photo;
        this.email = email;
    }

    public UserResponse() {
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status=" + status +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
