package com.bo.xMarket.bl;

import com.bo.xMarket.dao.BranchOfficeDao;
import com.bo.xMarket.dto.BranchOfficeRequest;
import com.bo.xMarket.model.BranchOffice;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeBl {
    private BranchOfficeDao branchOfficeDao;

    @Autowired
    public BranchOfficeBl(BranchOfficeDao branchOfficeDao) {
        this.branchOfficeDao = branchOfficeDao;
    }

    public BranchOffice addBranchOffice(BranchOfficeRequest branchOfficeRequest, Transaction transaction){
        BranchOffice branchOffice = new BranchOffice();
        branchOffice.setName(branchOfficeRequest.getName());
        branchOffice.setManagerId(branchOfficeRequest.getManagerId());
        branchOffice.setZone(branchOfficeRequest.getZone());
        branchOffice.setStatus(1);
        branchOffice.setAddress(branchOfficeRequest.getAddress());
        branchOffice.setPhone(branchOfficeRequest.getPhone());
        branchOffice.setTransaction(transaction);
        branchOfficeDao.addBranchOffice(branchOffice);
        return branchOffice;
    }
    public List<BranchOffice> branchOfficeList(){
        return branchOfficeDao.listBranchOffice();
    }
}
