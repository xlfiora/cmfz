package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by xl on 2018/7/4 0004.
 */
public interface ManagerDao {

    public Integer insertManager(Manager manager);

    public Manager selectManagerByName(String name);

    public List<Role> selectRoleByName(String name);

    public List<Permission> selectPermissionByName(String name);

}
