package com.bo.xMarket.bl;


import com.bo.xMarket.dao.BranchOfficeDao;
import com.bo.xMarket.dto.BranchOfficeRequest;
import com.bo.xMarket.model.BranchOffice;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchOfficeBl {
    private final BranchOfficeDao branchOfficeDao;

    @Autowired
    public BranchOfficeBl(BranchOfficeDao branchOfficeDao) {
        this.branchOfficeDao = branchOfficeDao;
    }

    public BranchOfficeRequest addBranchOffice(BranchOfficeRequest branchOfficeRequest, Transaction transaction) {
        BranchOffice branchOffice = new BranchOffice();
        branchOffice.setName(branchOfficeRequest.getName());
        branchOffice.setManagerId(branchOfficeRequest.getManagerId());
        branchOffice.setZone(branchOfficeRequest.getZone());
        branchOffice.setImage(branchOfficeRequest.getImage());
        branchOffice.setStatus(1);
        branchOffice.setAddress(branchOfficeRequest.getAddress());
        branchOffice.setPhone(branchOfficeRequest.getPhone());
        branchOffice.setTransaction(transaction);
        branchOfficeDao.addBranchOffice(branchOffice);
        return branchOfficeRequest;
    }

    public List<BranchOfficeRequest> branchOfficeList() {
        List<BranchOfficeRequest> branchOfficeRequests = new ArrayList<>();
        List<BranchOffice> branchOffices = branchOfficeDao.listBranchOffice();
        for (BranchOffice branchOffice : branchOffices) {
            BranchOfficeRequest result = new BranchOfficeRequest();
            result.setBranchOfficeId(branchOffice.getBranchOfficeId());
            result.setManagerId(branchOffice.getManagerId());
            result.setName(branchOffice.getName());
            result.setPhone(branchOffice.getPhone());
            result.setZone(branchOffice.getZone());
            result.setAddress(branchOffice.getAddress());
            result.setImage(branchOffice.getImage());
            branchOfficeRequests.add(result);
        }
        return branchOfficeRequests;

    }

    public List<String> zonesList() {
        return branchOfficeDao.getListOfZones();
    }

    public List<BranchOfficeRequest> branchOfficeListAll() {
        List<BranchOfficeRequest> branchOfficeRequests = new ArrayList<>();
        List<BranchOffice> branchOffices = branchOfficeDao.listBranchOfficeAll();
        for (BranchOffice branchOffice : branchOffices) {
            BranchOfficeRequest result = new BranchOfficeRequest();
            result.setBranchOfficeId(branchOffice.getBranchOfficeId());
            result.setManagerId(branchOffice.getManagerId());
            result.setName(branchOffice.getName());
            result.setPhone(branchOffice.getPhone());
            result.setZone(branchOffice.getZone());
            result.setAddress(branchOffice.getAddress());
            result.setImage(branchOffice.getImage());
            result.setStatus(branchOffice.getStatus());
            branchOfficeRequests.add(result);
        }
        return branchOfficeRequests;
    }

    public void changeBranchStatus(Integer branchId, Integer status) {
        branchOfficeDao.changeStatus(branchId, status);
    }
}
