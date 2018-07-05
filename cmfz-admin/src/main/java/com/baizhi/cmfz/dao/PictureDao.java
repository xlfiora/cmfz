package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;

import java.util.List;

/**
 * Created by xl on 2018/7/5 0005.
 */
public interface PictureDao {

    public Integer insertPicture(Picture picture);

    public Integer deletePicture(String pictureId);

    public Integer updatePicture(Picture picture);

    public Picture selectPictureById(String pictureId);

    public Integer countTotalRows();

    public List<Picture> selectPictureByPage(Page page);

}
