package com.baizhi.cmfz.entity;

import java.util.UUID;

/**
 * Created by xl on 2018/7/6 0006.
 */
public class Guru {

    private String guruId;
    private String guruName;
    private String guruPhoto;
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
