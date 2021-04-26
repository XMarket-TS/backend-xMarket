package com.bo.xMarket.dao;

import com.bo.xMarket.dto.CardRequest;
import com.bo.xMarket.dto.CardResponse;
import com.bo.xMarket.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardDao {
    //    public List<ProductResponse> listProductsByCategory(Integer id, Integer idbranch,Integer idcategory);
    public Integer addCard(Card card);

    public Integer getLastInsertId();

    public List<CardRequest> listCardsByUser(Integer iduser);

    public CardResponse cardDetails(Integer idcard);

    //Delete the product logically
    public void deleteCard(Integer idcard);
}
