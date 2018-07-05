package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.FirstMenu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xl on 2018/7/5 0005.
 */

@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;

    @Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
    @Override
    public List<FirstMenu> queryAllFirstMenu() {
        return menuDao.selectAllFirstMenu();
    }
}
