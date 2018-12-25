package com.baizhi.cmfz.entity;

/**
 * Created by xl on 2018/7/12 0012.
 */
public class Role {

    private String role;
    private String roleName;
    private String roleTag;

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
