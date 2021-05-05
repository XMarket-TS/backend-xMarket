package com.bo.xMarket.dao;

import com.bo.xMarket.model.ProductBranch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductBranchDao {
    //
    public void addProductBranch(ProductBranch productBranch);
}
