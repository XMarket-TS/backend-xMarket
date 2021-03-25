package com.bo.xMarket.dto;

import java.util.List;

public class ProductRequest {
    private Integer productId;
    private String name;
    private Double price;
    private String description;
    private List<String> imagesUrl;
    private Integer unit;
    //private Integer branchId; *
    private String category;
    //    FRONTEND WEB
    private Double discount;


    public ProductRequest() {}

    public ProductRequest(Integer productId, String name, Double price, String description, List<String> imagesUrl, Integer unit, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagesUrl = imagesUrl;
        this.unit = unit;
        this.category = category;

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imagesUrl=" + imagesUrl +
                ", unit=" + unit +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                '}';
    }
}
