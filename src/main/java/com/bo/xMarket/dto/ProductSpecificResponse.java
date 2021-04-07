package com.bo.xMarket.dto;


import com.bo.xMarket.model.Category;

import java.util.List;

public class ProductSpecificResponse {
    private Integer productId;
    private String name;
    private Double price;
    private Integer percentage;
    private String description;
    private Integer unit;
    private List<MediaRequest> imagesUrl;
    private Category category;
    private Integer branchId;

    public ProductSpecificResponse() {
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

    public List<MediaRequest> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<MediaRequest> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
