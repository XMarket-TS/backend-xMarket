package com.bo.xMarket.dto;

import java.util.List;

public class BranchSalesResponse {
    private String name;
    private List<Point> points;

    public BranchSalesResponse() {
    }

    public BranchSalesResponse(String name, List<Point> points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public String toString() {
        return "BranchSalesResponse{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
