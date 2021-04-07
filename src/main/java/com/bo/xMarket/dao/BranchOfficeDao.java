package com.bo.xMarket.dao;

import com.bo.xMarket.model.BranchOffice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BranchOfficeDao {
    public void addBranchOffice(BranchOffice branchOffice);

    public List<BranchOffice> listBranchOffice();

    public BranchOffice getBranchOfficerByManagerId(Integer managerId);
}
