package com.bo.xMarket.model;

import java.util.Date;

public class OfferRegister extends Transaction {
    private Integer offerId;
    private Integer productId;
    private Date startDate;
    private Date endDate;
    private Integer percentage;
    private Integer status;


    public OfferRegister(Integer txId, String txHost, Integer txUserId, Date txDate) {
        super(txId, txHost, txUserId, txDate);
    }

    public OfferRegister() {
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerId=" + offerId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", percentage=" + percentage +
                ", status=" + status +
                '}';
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
