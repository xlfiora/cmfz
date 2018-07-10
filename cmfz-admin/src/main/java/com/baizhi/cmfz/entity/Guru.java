package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.UUID;

/**
 * Created by xl on 2018/7/6 0006.
 */
public class Guru {

    @Excel(name = "上师编号")
    private String guruId;

    @Excel(name = "上师名")
    private String guruName;

    @Excel(name = "上师照片")
    private String guruPhoto;

    @Excel(name = "上师简介")
    private String guruIntroduction;

    public Guru() {
        this.guruId= UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruIntroduction='" + guruIntroduction + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                '}';
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruIntroduction() {
        return guruIntroduction;
    }

    public void setGuruIntroduction(String guruIntroduction) {
        this.guruIntroduction = guruIntroduction;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }
}
