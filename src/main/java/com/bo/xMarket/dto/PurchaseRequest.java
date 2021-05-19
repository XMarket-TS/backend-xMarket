package com.bo.xMarket.dto;
import java.util.List;
public class PurchaseRequest {
    private List<ProductPurchase> productPurchases;
    private String billingAddress;
    private String city;
    private Integer cardId;

    public PurchaseRequest() {
    }

    public List<ProductPurchase> getProductPurchases() {
        return productPurchases;
    }

    public void setProductPurchases(List<ProductPurchase> productPurchases) {
        this.productPurchases = productPurchases;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
}
