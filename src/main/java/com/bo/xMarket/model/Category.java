package com.bo.xMarket.model;

import java.util.Date;

public class Category extends Transaction{
    private Integer idCategory;
    private String name;
    private Integer status;

    public Category(Integer txId, String txHost, Integer txUserId, Date txDate) {
        super(txId, txHost, txUserId, txDate);
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
