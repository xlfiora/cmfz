package com.baizhi.cmfz.entity;

import java.util.UUID;

/**
 * Created by xl on 2018/7/4 0004.
 */
public class Manager {
    private String id;
    private String name;
    private String pwd;
    private String salt;

    public Manager() {
        this.id= UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
