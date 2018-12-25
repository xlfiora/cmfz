package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import com.baizhi.cmfz.util.RandomSaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xl on 2018/7/4 0004.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Integer addManager(Manager manager) {
        manager.setSalt(RandomSaltUtil.generetRandomSaltCode());
        manager.setPwd(new Md5Hash(manager.getPwd(),manager.getSalt(),1024).toString());
        return managerDao.insertManager(manager);
    }

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Manager queryManagerByName(String name) {
        return managerDao.selectManagerByName(name);
    }

    @Override
    public List<Role> queryRoleByName(String name) {
        return managerDao.selectRoleByName(name);
    }

    @Override
    public List<Permission> queryPermissionByName(String name) {
        return managerDao.selectPermissionByName(name);
    }


}
