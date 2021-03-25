package com.bo.xMarket.dao;

import com.bo.xMarket.dto.MediaRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MediaDao {
    public List<MediaRequest> listmedia(Integer idproduct);
}
