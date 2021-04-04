package com.bo.xMarket.dto;

public class OfferRequest {
    private Integer percentage;//con el descuento
    private String startDate;
    private String endDate;
    private String imageUrl;

    public OfferRequest(Integer percentage, String startDate, String endDate, String imageUrl) {
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageUrl = imageUrl;
    }

    public OfferRequest(Integer percentage, String startDate, String endDate) {
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OfferRequest() {
    }

    @Override
    public String toString() {
        return "OfferRequest{" +
                "percentage=" + percentage +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
