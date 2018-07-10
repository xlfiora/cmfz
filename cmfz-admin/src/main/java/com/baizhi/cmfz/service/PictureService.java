package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by xl on 2018/7/5 0005.
 */
public interface PictureService {

    public Integer addPicture(Picture picture);

    public Integer removePicture(String pictureId);

    public Integer modifyPicture(Picture picture);

    public Picture queryPictureById(String pictureId);

    public Map<String,Object> queryPictureByPage(Page page);

}
