package com.bo.xMarket.dao;

import com.bo.xMarket.model.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockDao {
    // get stock by productId
    public Stock getStockById(Integer productId);

    // add stock to a product
    public void addStock(Stock stock);

    // upadte a product stock by purchase completed
    void updateStock(Integer unit, Integer productId);
}
