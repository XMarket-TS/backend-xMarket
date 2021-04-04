package com.bo.xMarket.model;

public class BranchOffice extends Transaction {
    private Integer branchOfficeId;
    private Integer managerId;
    private String name;
    private Integer phone;
    private String zone;
    private String address;
    private Integer status;

    public BranchOffice(Integer branchOfficeId, Integer managerId, String name, Integer phone, String zone, String address, Integer status) {
        this.branchOfficeId = branchOfficeId;
        this.managerId = managerId;
        this.name = name;
        this.phone = phone;
        this.zone = zone;
        this.address = address;
        this.status = status;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
