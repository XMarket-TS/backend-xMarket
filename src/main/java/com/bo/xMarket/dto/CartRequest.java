package com.bo.xMarket.dto;

public class CartRequest {
    private Integer cardId;
    private Integer userId;
    private String cardName;
    private Integer cardNumber;
    private Integer cvc;
    private Integer status;

    //    FRONTEND WEB
    //    private Double discount;


    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "cardId='" + cardId + '\'' +
                ", userId=" + userId + '\'' +
                ", cardName=" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvc=" + cvc + '\'' +
                ", status=" + status +
                '}';
    }


}
