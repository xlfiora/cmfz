package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xl on 2018/7/8 0008.
 */
public class Article {

    private String articleId;
    private String articleName;
    private String articleStatus;
    private String guruId;
    private String articleContent;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date articleDate;

    public Article() {
        this.articleId= UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", guruId='" + guruId + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

}
