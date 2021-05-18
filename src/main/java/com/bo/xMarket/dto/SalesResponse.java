package com.bo.xMarket.dto;

public class SalesResponse {
    private Integer amount;
    private String buyDate;

    public SalesResponse() {
    }

    public SalesResponse(Integer amount, String buyDate) {
        this.amount = amount;
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "SalesResponse{" +
                "amount=" + amount +
                ", buyDate='" + buyDate + '\'' +
                '}';
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}
