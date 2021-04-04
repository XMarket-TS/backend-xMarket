package com.bo.xMarket.model;

public class User extends Transaction {
    private Integer userId;
    private Integer personId;
    private String username;
    private String password;
    private Integer status;
    private String userPhoto;

    public User(Integer userId, Integer personId, String username, String password, Integer status, String userPhoto) {
        this.userId = userId;
        this.personId = personId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.userPhoto = userPhoto;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", personId=" + personId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
