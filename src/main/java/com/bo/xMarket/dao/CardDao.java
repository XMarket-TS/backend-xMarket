package com.bo.xMarket.dao;

import com.bo.xMarket.dto.CardRequest;
import com.bo.xMarket.dto.CardResponse;
import com.bo.xMarket.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardDao {

    public Integer addCard(Card card);

    public Integer getLastInsertId();

    public List<CardRequest> listCardsByUser(Integer iduser);

    public void updateCard(Card card);

    public CardResponse cardDetails(Integer idcard);

    public void deleteCard(Integer idcard);
}
