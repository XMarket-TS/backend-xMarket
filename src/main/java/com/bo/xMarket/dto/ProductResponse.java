package com.bo.xMarket.dto;

public class ProductResponse {
    private Integer productId;
    private String name;
    private Double price;
    private Integer percentage;
    private String description;
    private String category;
    private String firstImage;
    //private Integer branchId;


    public ProductResponse(Integer productId, String name, Double price, Integer percentage, String description, String category, String firstImage) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.percentage = percentage;
        this.description = description;
        this.category = category;
        this.firstImage = firstImage;
    }

    public ProductResponse() {
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", percentage=" + percentage +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", firstImage='" + firstImage + '\'' +
                '}';
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }
}
