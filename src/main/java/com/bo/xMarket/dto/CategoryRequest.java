package com.bo.xMarket.dto;

public class CategoryRequest {
    private Integer categoryId;
    private String category;
    private String imageUrl;
    // PARA PRUEBAS
    private Integer sucursalId;

    public CategoryRequest(Integer categoryId, String category, String imageUrl) {
        this.categoryId = categoryId;
        this.category = category;
        this.imageUrl = imageUrl;
        setSucursalId(-1);
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", sucursalId=" + sucursalId +
                '}';
    }
}
