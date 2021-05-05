package com.bo.xMarket.dao;

import com.bo.xMarket.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao {
    //
    public Integer create(Transaction transaction);

    //
    public Integer getLastInsertId();
}
