package com.bo.xMarket.api;

import com.bo.xMarket.bl.CardBl;
import com.bo.xMarket.bl.TransactionBl;

import com.bo.xMarket.dto.CardRequest;
import com.bo.xMarket.dto.CardResponse;
import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.model.Card;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "")
public class CardApi {
    private CardBl cardBl;
    private TransactionBl transactionBl;

    @Autowired
    public CardApi(CardBl cardBl, TransactionBl transactionBl) {
        this.cardBl = cardBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(value = "/addcard",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Card createCard(@RequestBody CardResponse card, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        //LOGGER.error(transaction.getTxId().toString());
        Card createcard=cardBl.addCard(card,transaction);
        return createcard;
    }
    @RequestMapping(value = "/user/{userid}/listCards/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardRequest> listCardsByUser(@PathVariable("userid") Integer id) {
        return cardBl.listCardsByUser(id);
    }
    @RequestMapping(value = "/card/{cardId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void productDelete(@PathVariable("cardId") Integer cardId, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        cardBl.cardDelete(cardId);
//        productBl.productDelete(productid);
    }

}