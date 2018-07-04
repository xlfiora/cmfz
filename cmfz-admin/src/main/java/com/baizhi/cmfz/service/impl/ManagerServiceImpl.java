package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import com.baizhi.cmfz.util.RandomSaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xl on 2018/7/4 0004.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    //@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ManagerDao managerDao;

    @Override
    public Integer addManager(Manager manager) {
        manager.setSalt(RandomSaltUtil.generetRandomSaltCode());
        manager.setPwd(EncryptionUtils.encryptionCode(manager.getPwd()+manager.getSalt()));
        return managerDao.insertManager(manager);
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Manager loginManager(String name, String pwd) {
        Manager manager=managerDao.selectManager(name);
        if (manager!=null){
            if(EncryptionUtils.encryptionCode(pwd+manager.getSalt()).equals(manager.getPwd())){
                return manager;
            }
        }
        return null;
    }
}
