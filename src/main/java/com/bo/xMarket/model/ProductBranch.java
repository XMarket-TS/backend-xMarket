package com.bo.xMarket.model;

public class ProductBranch {
    private Integer productBranchId;
    private Integer productId;
    private Integer branchOfficeId;

    public ProductBranch() {
    }

    public Integer getProductBranchId() {
        return productBranchId;
    }

    public void setProductBranchId(Integer productBranchId) {
        this.productBranchId = productBranchId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(Integer branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }
}
