package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xl on 2018/7/5 0005.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureDao pictureDao;

    @Override
    public Integer addPicture(Picture picture) {
        return pictureDao.insertPicture(picture);
    }

    @Override
    public Integer removePicture(String pictureId) {
        return pictureDao.deletePicture(pictureId);
    }

    @Override
    public Integer modfiyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public Picture queryPictureById(String pictureId) {
        return pictureDao.selectPictureById(pictureId);
    }

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> queryPictureByPage(Page page) {

        // 总记录数
        Integer count = pictureDao.countTotalRows();
        page.setTotalRows(count);

        // 当前页需要的数据集合
        List<Picture> pictures = pictureDao.selectPictureByPage(page);

        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", pictures);

        return map;
    }
}
