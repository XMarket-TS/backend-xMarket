package com.bo.xMarket.dao;

import com.bo.xMarket.model.Items;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemsDao {

    // link product seel with user purchase
    void addItemToPurchase(Items item);
}
