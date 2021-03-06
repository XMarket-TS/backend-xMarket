package com.bo.xMarket.dto;

import java.util.List;

public class ProductSpecificResponse {
    private Integer productId;
    private String name;
    private Double price;
    private Integer percentage;
    private String description;
    private Integer unit;
    private List<String> imagesUrl;
    private CategoryRequest category;
    private Integer branchId;
    private String qrHash;

    public ProductSpecificResponse() {
    }

    @Override
    public String toString() {
        return "ProductSpecificResponse{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", percentage=" + percentage +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", imagesUrl=" + imagesUrl +
                ", category=" + category +
                ", branchId=" + branchId +
                ", qrHash='" + qrHash + '\'' +
                '}';
    }

    public String getQrHash() {
        return qrHash;
    }

    public void setQrHash(String qrHash) {
        this.qrHash = qrHash;
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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public CategoryRequest getCategory() {
        return category;
    }

    public void setCategory(CategoryRequest category) {
        this.category = category;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
