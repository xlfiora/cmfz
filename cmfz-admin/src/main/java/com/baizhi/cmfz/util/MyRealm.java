package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Created by xl on 2018/7/11 0011.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private ManagerService managerService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("------------授权------------");

        String  username = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<Role> roles = managerService.queryRoleByName(username);
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }

        List<Permission> permissions = managerService.queryPermissionByName(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("----------认证----------");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();

        Manager manager = managerService.queryManagerByName(username);

        if (manager.getName()!=null){

            return new SimpleAuthenticationInfo(
                    manager.getName(),
                    manager.getPwd(),
                    ByteSource.Util.bytes(manager.getSalt()),
                    UUID.randomUUID().toString());
        }

        return null;

    }
}
