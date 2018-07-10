package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xl on 2018/7/8 0008.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Integer addArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public Map<String, Object> queryArticleByPage(Page page) {

        Integer count =articleDao.countTotalRows();
        page.setTotalRows(count);

        List<Article> articles = articleDao.selectArticleByPage(page);

        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",articles);

        return map;
    }
}
