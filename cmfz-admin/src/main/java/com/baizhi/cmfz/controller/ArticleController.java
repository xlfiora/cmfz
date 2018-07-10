package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by xl on 2018/7/8 0008.
 */
@Service
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArticle")
    public @ResponseBody void addArticle(String articleTitle,String articleStatus,String articleAuthor,String articleContent){

        Article article = new Article();
        article.setArticleName(articleTitle);
        article.setArticleStatus(articleStatus);
        article.setGuruId(articleAuthor);
        article.setArticleContent(articleContent);
        article.setArticleDate(new Date());
        articleService.addArticle(article);

    }

    @RequestMapping("/uploadFiles")
    public @ResponseBody RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {

        RichTextResult result = new RichTextResult();
        ArrayList<String> data= new ArrayList<String>();

        try {
            if(files!=null && files.length!=0 ){
                for (MultipartFile file : files) {
                    String fileName = file.getOriginalFilename();
                    String[] s = fileName.split("\\.");
                    String newName = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
                    fileName = newName + "." + s[1];

                    //C:\Program Files\Apache Software Foundation\apache-tomcat-7.0.81\webapps\cmfz-admin\
                    String realPath = request.getRealPath("/");

                    String uploadPath = realPath.replace("cmfz-admin\\", "upload\\article\\") + fileName;
                    file.transferTo(new File(uploadPath));

                    data.add(request.getContextPath()+"/upload/article/"+fileName);

                }
            }
            //处理响应
            result.setErrno(0);
            result.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/queryArticleByPage")
    public @ResponseBody
    Map<String,Object> queryArticleByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        Page page = new Page();
        page.setPageIndex(nowPage);
        page.setSingleRows(pageSize);
        return articleService.queryArticleByPage(page);
    }

}
