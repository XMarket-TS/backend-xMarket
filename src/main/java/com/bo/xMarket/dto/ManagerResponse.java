package com.bo.xMarket.dto;

public class ManagerResponse {
    private Integer managerId;
    private String name;
    private String userPhoto;
    private Integer isAvailable;

    public ManagerResponse() {
    }

    @Override
    public String toString() {
        return "ManagerResponse{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }
}
