package com.bo.xMarket.dto;

public class BranchOfficeRequest {
    private Integer branchOfficeId;
    private Integer managerId; //nombre del manager no Id *
    private String name;
    private Integer phone;
    private String zone;
    private String address;
    private String image;

    public BranchOfficeRequest(Integer branchOfficeId, Integer managerId, String name, Integer phone, String zone, String address, String image) {
        this.branchOfficeId = branchOfficeId;
        this.managerId = managerId;
        this.name = name;
        this.phone = phone;
        this.zone = zone;
        this.address = address;
        this.image = image;
    }

    public BranchOfficeRequest() {
    }

    @Override
    public String toString() {
        return "BranchOfficeRequest{" +
                "branchOfficeId=" + branchOfficeId +
                ", managerId=" + managerId +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", zone='" + zone + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
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
}
