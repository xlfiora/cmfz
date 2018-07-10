package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Page;

import java.util.List;

/**
 * Created by xl on 2018/7/8 0008.
 */
public interface ArticleDao {

    public Integer insertArticle(Article article);

    public Integer countTotalRows();

    public List<Article> selectArticleByPage(Page page);


}
