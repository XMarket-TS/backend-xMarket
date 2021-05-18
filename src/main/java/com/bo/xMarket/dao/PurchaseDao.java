package com.bo.xMarket.dao;

import com.bo.xMarket.dto.MonthlySaleBranchResponse;
import com.bo.xMarket.dto.Point;
import com.bo.xMarket.dto.SalesResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDao {
    // Get total sales by branch
    List<MonthlySaleBranchResponse> getTotalSaleByBranch();

    // Total de productos comprados por sucursal
    List<MonthlySaleBranchResponse> getTotalProductsSold();

    // Sales daily
    List<SalesResponse> salesDaily();

    //
    List<Point> salesDailyByBranchId(Integer branchId);
}
