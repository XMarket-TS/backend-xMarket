package com.bo.xMarket.bl;

import com.bo.xMarket.dao.OfferRegisterDao;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.model.OfferRegister;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferBl {
    private final OfferRegisterDao offerRegisterDao;

    @Autowired
    public OfferBl(OfferRegisterDao offerRegisterDao) {
        this.offerRegisterDao = offerRegisterDao;
    }

    public List<OfferRequest> productOffers(Integer id) {
        return offerRegisterDao.getOffersByProduct(id);
    }

    public OfferRequest update(OfferRequest offerRequest) {
        OfferRegister offer = new OfferRegister();
        offer.setOfferId(offerRequest.getOfferId());
        offer.setPercentage(offerRequest.getPercentage());
        offer.setProductId(offerRequest.getProductId());
        offer.setStartDate(offerRequest.getStartDate());
        offer.setEndDate(offerRequest.getEndDate());
        offer.setStatus(offerRequest.getStatus());
        offerRegisterDao.updateOffer(offer);
        return offerRequest;

    }

    public OfferRequest create(OfferRequest offerRequest, Transaction transaction) {
        OfferRegister offerRegister = new OfferRegister();
        offerRegister.setEndDate(offerRequest.getEndDate());
        offerRegister.setStartDate(offerRequest.getStartDate());
        offerRegister.setPercentage(offerRequest.getPercentage());
        offerRegister.setProductId(offerRequest.getProductId());
        offerRegister.setStatus(offerRequest.getStatus());
        offerRegister.setTransaction(transaction);
        offerRegisterDao.addOfferRegister(offerRegister);
        return offerRequest;
    }

    public void updateOffer(OfferRequest offerRequest) {
        offerRegisterDao.updateOffers(offerRequest);
    }

    public void deleteOffer(Integer offerId) {
        offerRegisterDao.deleteOfferById(offerId);
    }
}
