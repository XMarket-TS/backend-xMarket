package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CardDao;
import com.bo.xMarket.dto.CardRequest;
import com.bo.xMarket.dto.CardResponse;
import com.bo.xMarket.model.Card;
import com.bo.xMarket.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardBl {
//    private CategoryDao categoryDao;
    private CardDao cardDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CardBl.class);
//    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentApi.class);
    @Autowired
    public CardBl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public List<CardRequest> listCardsByUser(Integer userId){
        List<CardRequest> cardCollection=cardDao.listCardsByUser(userId);
//        LOGGER.error(String.valueOf(cardCollection.size()));
        return cardCollection;
    }

    public Card addCard(CardResponse card, Transaction transaction){
        Card card2=new Card();
        card2.setUserId(card.getUserId());
        card2.setCardName(card.getCardName());
        card2.setCardNumber(card.getCardNumber());
        card2.setExpirationYear(card.getExpirationYear());
        card2.setExpirationMonth(card.getExpirationMonth());
        card2.setCvc(card.getCvc());
        card2.setCreationDate(card.getCreationDate());
        card2.setStatus(card.getStatus());
        LOGGER.info(transaction.toString());
//        card2.setTxHost(transaction.getTxHost());
//        card2.setUserId(transaction.getTxUserId());
//        card2.setTxDate(transaction.getTxDate());
        card2.setTransaction(transaction);
//        LOGGER.info(card2.getTxHost());
        cardDao.addCard(card2);
        return card2;
    }
    public CardResponse cardDetails(Integer cardid) {
        CardResponse cardResponse=cardDao.cardDetails(cardid);
        return cardResponse;
    }
    public void cardDelete(Integer cardId) {
        cardDao.deleteCard(cardId);
    }
}
