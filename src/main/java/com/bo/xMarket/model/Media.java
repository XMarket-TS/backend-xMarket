package com.bo.xMarket.model;

public class Media extends Transaction {
    private Integer mediaId;
    private Integer productId;
    private String photo;
    private Integer status;

    public Media(Integer mediaId, Integer productId, String photo, Integer status) {
        this.mediaId = mediaId;
        this.productId = productId;
        this.photo = photo;
        this.status = status;
    }

    public Media() {
    }

    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", productId=" + productId +
                ", photo='" + photo + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
