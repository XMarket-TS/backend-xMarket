package com.bo.xMarket.dto;

public class MediaRequest {
    private Integer productId;
    private String photo;

    public MediaRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
