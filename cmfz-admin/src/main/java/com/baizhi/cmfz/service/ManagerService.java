package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by xl on 2018/7/4 0004.
 */
public interface ManagerService {

    public Integer addManager(Manager manager);

    public Manager loginManager(String name,String pwd);

}
