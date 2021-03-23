package com.bo.xMarket.dao;

import com.bo.xMarket.model.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDao {
    public void addManager(Manager manager);
}
