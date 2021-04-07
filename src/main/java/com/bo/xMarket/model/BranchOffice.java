package com.bo.xMarket.model;

public class BranchOffice extends Transaction {
    private Integer branchOfficeId;
    private Integer managerId;
    private String name;
    private Integer phone;
    private String zone;
    private String address;
    private String image;
    private Integer status;


    public BranchOffice() {
    }

    @Override
    public String toString() {
        return "BranchOffice{" +
                "branchOfficeId=" + branchOfficeId +
                ", managerId=" + managerId +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", zone='" + zone + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(Integer branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
