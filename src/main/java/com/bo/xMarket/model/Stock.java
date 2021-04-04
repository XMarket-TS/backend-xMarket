package com.bo.xMarket.model;

import java.util.Date;

public class Stock {
    private Integer stockId;
    private Integer productId;
    private Integer inStock;
    private Date lastUpdate;

    public Stock(Integer stockId, Integer productId, Integer inStock, Date lastUpdate) {
        this.stockId = stockId;
        this.productId = productId;
        this.inStock = inStock;
        this.lastUpdate = lastUpdate;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", productId=" + productId +
                ", inStock=" + inStock +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
