package com.bo.xMarket.dao;

import com.bo.xMarket.model.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockDao {
    //
    public Stock getStockById(Integer productId);

    //
    public void addStock(Stock stock);
}
