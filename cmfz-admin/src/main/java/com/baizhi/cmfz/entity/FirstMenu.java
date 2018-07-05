package com.baizhi.cmfz.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by xl on 2018/7/5 0005.
 */
public class FirstMenu {

    private String fmenuId;
    private String fmenuName;
    private String fmenuCode;
    private String fmenuIcon;
    private String fmenuUrl;
    private String fmenuLevel;
    private List<SecondMenu> secondMenus = new ArrayList<SecondMenu>();

    public FirstMenu() {
        //this.fmenuId= UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String toString() {
        return "FirstMenu{" +
                "fmenuId='" + fmenuId + '\'' +
                ", fmenuName='" + fmenuName + '\'' +
                ", fmenuCode='" + fmenuCode + '\'' +
                ", fmenuIcon='" + fmenuIcon + '\'' +
                ", fmenuUrl='" + fmenuUrl + '\'' +
                ", fmenuLevel='" + fmenuLevel + '\'' +
                ", secondMenus=" + secondMenus +
                '}';
    }

    public String getFmenuId() {
        return fmenuId;
    }

    public void setFmenuId(String fmenuId) {
        this.fmenuId = fmenuId;
    }

    public String getFmenuName() {
        return fmenuName;
    }

    public void setFmenuName(String fmenuName) {
        this.fmenuName = fmenuName;
    }

    public String getFmenuCode() {
        return fmenuCode;
    }

    public void setFmenuCode(String fmenuCode) {
        this.fmenuCode = fmenuCode;
    }

    public String getFmenuIcon() {
        return fmenuIcon;
    }

    public void setFmenuIcon(String fmenuIcon) {
        this.fmenuIcon = fmenuIcon;
    }

    public String getFmenuUrl() {
        return fmenuUrl;
    }

    public void setFmenuUrl(String fmenuUrl) {
        this.fmenuUrl = fmenuUrl;
    }

    public String getFmenuLevel() {
        return fmenuLevel;
    }

    public void setFmenuLevel(String fmenuLevel) {
        this.fmenuLevel = fmenuLevel;
    }

    public List<SecondMenu> getSecondMenus() {
        return secondMenus;
    }

    public void setSecondMenus(List<SecondMenu> secondMenus) {
        this.secondMenus = secondMenus;
    }
}
