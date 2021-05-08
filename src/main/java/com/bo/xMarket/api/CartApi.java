package com.bo.xMarket.api;

import com.bo.xMarket.bl.CartBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.CartRequest;
import com.bo.xMarket.dto.CartResponse;
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
@RequestMapping(value = "") // TODO: change mapping to "cart"
public class CartApi {
    private final CartBl cartBl;
    private final TransactionBl transactionBl;

    @Autowired
    public CartApi(CartBl cartBl, TransactionBl transactionBl) {
        this.cartBl = cartBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(value = "/addcard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Card createCard(@RequestBody CartResponse card, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return cartBl.addCard(card, transaction);
    }

    @RequestMapping(value = "/user/{userid}/listCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartRequest> listCardsByUser(@PathVariable("userid") Integer id) {
        return cartBl.listCardsByUser(id);
    }

    @RequestMapping(value = "/card/{cardId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void productDelete(@PathVariable("cardId") Integer cardId, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        cartBl.cardDelete(cardId);
    }

    @RequestMapping(value = "/card/{cardid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse cardDetails(@PathVariable("cardid") Integer id) {
        return cartBl.cardDetails(id);
    }

    @RequestMapping(value = "/updateCard", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse updateCard(@RequestBody CartResponse cartResponse, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        cartBl.updateCard(cartResponse, transaction);
        return cartResponse;
    }
}
