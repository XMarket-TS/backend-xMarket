package com.bo.xMarket.dao;

import com.bo.xMarket.model.BranchOffice;
import com.bo.xMarket.model.Product;
import org.apache.ibatis.annotations.Mapper;
import java.awt.*;
import java.util.List;

@Mapper
public interface BranchOfficeDao {
    public void addBranchOffice(BranchOffice branchOffice);
    public List<BranchOffice> listBranchOffice();
}
