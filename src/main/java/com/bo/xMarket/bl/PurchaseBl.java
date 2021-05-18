package com.bo.xMarket.bl;

import com.bo.xMarket.dao.BranchOfficeDao;
import com.bo.xMarket.dao.PurchaseDao;
import com.bo.xMarket.dto.BranchSalesResponse;
import com.bo.xMarket.dto.MonthlySaleBranchResponse;
import com.bo.xMarket.dto.SalesResponse;
import com.bo.xMarket.model.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseBl {
    private final PurchaseDao purchaseDao;
    private final BranchOfficeDao branchOfficeDao;

    @Autowired
    public PurchaseBl(PurchaseDao purchaseDao, BranchOfficeDao branchOfficeDao) {
        this.purchaseDao = purchaseDao;
        this.branchOfficeDao = branchOfficeDao;
    }

    public List<MonthlySaleBranchResponse> generalMonthly() {
        return purchaseDao.getTotalSaleByBranch();
    }

    public List<MonthlySaleBranchResponse> totalSalesBranch() {
        return purchaseDao.getTotalSaleByBranch();
    }

    public List<MonthlySaleBranchResponse> productsSold() {
        return purchaseDao.getTotalProductsSold();
    }

    public List<SalesResponse> dailySales() {
        return purchaseDao.salesDaily();
    }

    public List<BranchSalesResponse> dailySalesAllBranchs() {
        List<BranchOffice> branchOffices = branchOfficeDao.listBranchOfficeAll();
        List<BranchSalesResponse> branchSalesResponses = new ArrayList<>();

//        branchOffices.forEach(branchOffice -> {
        BranchSalesResponse salesResponse = new BranchSalesResponse();
        salesResponse.setName(branchOffices.get(0).getName());
        salesResponse.setPoints(purchaseDao.salesDailyByBranchId(branchOffices.get(0).getBranchOfficeId()));
        branchSalesResponses.add(salesResponse);
//        });

        BranchSalesResponse salesResponse1 = new BranchSalesResponse();
        salesResponse1.setName(branchOffices.get(3).getName());
        salesResponse1.setPoints(purchaseDao.salesDailyByBranchId(branchOffices.get(3).getBranchOfficeId()));
        branchSalesResponses.add(salesResponse1);

        BranchSalesResponse salesResponse2 = new BranchSalesResponse();
        salesResponse2.setName(branchOffices.get(5).getName());
        salesResponse2.setPoints(purchaseDao.salesDailyByBranchId(branchOffices.get(5).getBranchOfficeId()));
        branchSalesResponses.add(salesResponse2);
        return branchSalesResponses;
    }
}
