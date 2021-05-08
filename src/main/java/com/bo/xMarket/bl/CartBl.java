package com.bo.xMarket.bl;

import com.bo.xMarket.dao.CartDao;
import com.bo.xMarket.dto.CartRequest;
import com.bo.xMarket.dto.CartResponse;
import com.bo.xMarket.model.Card;
import com.bo.xMarket.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartBl {
    private final CartDao cartDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CartBl.class);

    @Autowired
    public CartBl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public List<CartRequest> listCardsByUser(Integer userId) {
        List<CartRequest> cardCollection = cartDao.listCardsByUser(userId);
        LOGGER.error(String.valueOf(cardCollection.size()));
        return cardCollection;
    }

    public Card addCard(CartResponse card, Transaction transaction) {
        Card card2 = new Card();
        card2.setUserId(card.getUserId());
        card2.setCardName(card.getCardName());
        card2.setCardNumber(card.getCardNumber());
        card2.setExpirationYear(card.getExpirationYear());
        card2.setExpirationMonth(card.getExpirationMonth());
        card2.setCvc(card.getCvc());
        card2.setCreationDate(card.getCreationDate());
        card2.setStatus(card.getStatus());
//        LOGGER.info(transaction.toString());
//        card2.setTxHost(transaction.getTxHost());
//        card2.setUserId(transaction.getTxUserId());
//        card2.setTxDate(transaction.getTxDate());
        card2.setTransaction(transaction);
//        LOGGER.info(card2.getTxHost());
        cartDao.addCard(card2);
        return card2;
    }

    public CartResponse cardDetails(Integer cardid) {
        return cartDao.cardDetails(cardid);
    }

    public void updateCard(CartResponse cartResponse, Transaction transaction) {

        Card card = new Card();

        card.setCardId(cartResponse.getCardId());
        card.setUserId(cartResponse.getUserId());
        card.setCardName(cartResponse.getCardName());
        card.setCardNumber(cartResponse.getCardNumber());
        card.setExpirationYear(cartResponse.getExpirationYear());
        card.setExpirationMonth(cartResponse.getExpirationMonth());
        card.setCvc(cartResponse.getCvc());
        card.setCreationDate(cartResponse.getCreationDate());
        card.setStatus(cartResponse.getStatus());
        card.setTransaction(transaction);
        cartDao.updateCard(card);

    }

    public void cardDelete(Integer cardId) {

        cartDao.deleteCard(cardId);
    }
}
