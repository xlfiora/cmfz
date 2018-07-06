package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xl on 2018/7/6 0006.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService{

    @Autowired
    private GuruDao guruDao;

    @Override
    public Integer addGuru(Guru guru) {
        return guruDao.insertGuru(guru);
    }

    @Override
    public Integer removeGuru(String guruId) {
        return guruDao.deleteGuru(guruId);
    }

    @Override
    public Integer modifyGuru(Guru guru) {
        return guruDao.updateGuru(guru);
    }

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> queryGuruByPage(Page page) {
        // 总记录数
        Integer count = guruDao.countTotalRows();
        page.setTotalRows(count);

        // 当前页需要的数据集合
        List<Guru> gurus = guruDao.selectGuruByPage(page);

        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", gurus);

        return map;
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> queryGuruByKey(Page page, String key, String value) {
        // 总记录数
        Integer count = guruDao.countTotalRowsByKey(key,"%"+value+"%");
        page.setTotalRows(count);

        // 当前页需要的数据集合
        List<Guru> gurus = guruDao.selectGuruByKey(page,key,"%"+value+"%");

        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", gurus);

        return map;
    }
}
