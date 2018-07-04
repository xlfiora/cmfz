package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xl on 2018/7/4 0004.
 */
public interface ManagerService {

    public Integer addManager(Manager manager);

    public Manager loginManager(String name,String pwd);

}
