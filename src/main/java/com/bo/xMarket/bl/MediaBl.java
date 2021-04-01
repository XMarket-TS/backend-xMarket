package com.bo.xMarket.bl;

import com.bo.xMarket.dao.MediaDao;
import com.bo.xMarket.dto.MediaRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MediaBl {
    private MediaDao mediaDao;

    @Autowired
    public MediaBl(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    public List<MediaRequest> mediaList(Integer idproduct){
        return mediaDao.listmedia(idproduct);
    }

}
