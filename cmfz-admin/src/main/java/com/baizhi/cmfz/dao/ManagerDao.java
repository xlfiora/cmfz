package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by xl on 2018/7/4 0004.
 */
public interface ManagerDao {

    public Integer insertManager(Manager manager);

    public Manager selectManager(String name);

}
