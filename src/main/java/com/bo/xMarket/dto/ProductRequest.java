package com.bo.xMarket.dto;

import java.util.List;

public class ProductRequest {
    //private Integer productId;
    private String name;
    private Double price;
    private String description;
    private Integer unit;
    private String category;
    private OfferRequest offer;
    private List<String> imagesUrl;

    //    FRONTEND WEB
    //    private Double discount;


    public ProductRequest(String name, Double price, String description, Integer unit, String category, OfferRequest offer, List<String> imagesUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.unit = unit;
        this.category = category;
        this.offer = offer;
        this.imagesUrl = imagesUrl;
    }

    public ProductRequest() {

    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", category='" + category + '\'' +
                ", offer=" + offer +
                ", imagesUrl=" + imagesUrl +
                '}';
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


    public OfferRequest getOffer() {
        return offer;
    }

    public void setOffer(OfferRequest offer) {
        this.offer = offer;
    }

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }
}
