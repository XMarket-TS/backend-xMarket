package com.bo.xMarket.dao;

import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.OfferResponse;
import com.bo.xMarket.model.OfferRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OfferRegisterDao {
    // Not ready
    public void addOfferRegister(OfferRegister offerRegister);

    //
    public List<OfferRegister> getOffersByProductId(Integer productId);


    //
    public OfferRegister getActualOffer(Integer productId);

    // Get offers by product ID
    public List<OfferRequest> getOffersByProduct(Integer productId);

    // Get offers by branch ID
    public List<OfferResponse> getOffersByBranchId(Integer branchId);

    //
    void updateOffer(OfferRegister offer);

    //
    void deleteOfferById(Integer offerId);

    //
    public void updateOffers(OfferRequest offerRequest);
}
