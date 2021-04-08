package com.bo.xMarket.model;

public class Manager extends Transaction {
    private Integer managerId;
    private Integer personId;
    private String username;
    private String password;
    private Integer status;

    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", personId=" + personId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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
}
