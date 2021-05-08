package com.bo.xMarket.dao;

import com.bo.xMarket.dto.CartRequest;
import com.bo.xMarket.dto.CartResponse;
import com.bo.xMarket.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {
    //
    public Integer addCard(Card card);

    //
    public Integer getLastInsertId();

    //
    public List<CartRequest> listCardsByUser(Integer iduser);

    //
    public void updateCard(Card card);

    //
    public CartResponse cardDetails(Integer idcard);

    //
    public void deleteCard(Integer idcard);
}
