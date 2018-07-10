package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xl on 2018/7/9 0009.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String,Object> queryLogByPage(Page page) {

        // 总记录数
        Integer count = logDao.countTotalRows();
        page.setTotalRows(count);

        // 当前页需要的数据集合
        List<Log> logs = logDao.selectLogByPage(page);

        Map<String, Object> map = new HashMap<>();
        map.put("total", count);
        map.put("rows", logs);

        return map;
    }
}
