package com.bo.xMarket.dto;

public class MonthlySaleBranchResponse {
    private String branchName;
    private String date;
    private Double sale;

    public MonthlySaleBranchResponse(String branchName, String date, Double sale) {
        this.branchName = branchName;
        this.date = date;
        this.sale = sale;
    }

    public MonthlySaleBranchResponse() {
    }

    @Override
    public String toString() {
        return "MonthlySaleBranchResponse{" +
                "branchId=" + branchName +
                ", date='" + date + '\'' +
                ", sale=" + sale +
                '}';
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }
}
