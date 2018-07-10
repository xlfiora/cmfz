package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Page;

import java.util.Map;

/**
 * Created by xl on 2018/7/8 0008.
 */
public interface ArticleService {

    public Integer addArticle(Article article);

    public Map<String,Object> queryArticleByPage(Page page);

}
