package com.bo.xMarket.dao;

import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.model.OfferRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfferRegisterDao {
    // Not ready
    public List<OfferRegister> getOffersByProductId(Integer productId);

    public OfferRegister getActualOffer(Integer productId);

}