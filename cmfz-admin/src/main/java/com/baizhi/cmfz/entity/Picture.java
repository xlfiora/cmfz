package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xl on 2018/7/5 0005.
 */

public class Picture {

    private String pictureId;
    private String pictureName;
    private String pictureMessage;
    private String pictureStatus;
    @JSONField(format = "yyyy-MM-dd")
    private Date pictureDate;

    public Picture() {
        this.pictureId = UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", pictureMessage='" + pictureMessage + '\'' +
                ", pictureStatus='" + pictureStatus + '\'' +
                ", pictureDate='" + pictureDate + '\'' +
                '}';
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureMessage() {
        return pictureMessage;
    }

    public void setPictureMessage(String pictureMessage) {
        this.pictureMessage = pictureMessage;
    }

    public String getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(String pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Date getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(Date pictureDate) {
        this.pictureDate = pictureDate;
    }
}
