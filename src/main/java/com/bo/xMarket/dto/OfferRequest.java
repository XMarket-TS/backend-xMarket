package com.bo.xMarket.dto;


import java.util.Date;

public class OfferRequest {
    private Integer percentage;//con el descuento
    private Date startDate;
    private Date endDate;
    private Integer status;
//    private String imageUrl;

    public OfferRequest() {
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
