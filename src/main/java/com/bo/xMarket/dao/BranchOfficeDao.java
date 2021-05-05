package com.bo.xMarket.dao;

import com.bo.xMarket.model.BranchOffice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BranchOfficeDao {
    //
    public void addBranchOffice(BranchOffice branchOffice);

    // List only branch office availables
    public List<BranchOffice> listBranchOffice();

    //
    public BranchOffice getBranchByPersonManagerId(Integer personId);

    // List of zones with Branch Offices
    public List<String> getListOfZones();

    // List all branch offices
    public List<BranchOffice> listBranchOfficeAll();

    // Enable or disable branch office
    public void changeStatus(Integer branchId, Integer status);
}
