package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by xl on 2018/7/4 0004.
 */
public interface ManagerService {

    public Integer addManager(Manager manager);

    public Manager queryManagerByName(String name);

    public List<Role> queryRoleByName(String name);

    public List<Permission> queryPermissionByName(String name);


}
