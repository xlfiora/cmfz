package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by xl on 2018/7/6 0006.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping("/addGuru")
    public @ResponseBody void addGuru(String guruName, String guruIntroduction, MultipartFile guruPhoto, HttpServletRequest request) throws IOException {

        String pictureName = guruPhoto.getOriginalFilename();
        String[] s=pictureName.split("\\.");
        String newName=(new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        pictureName=newName+"."+s[1];

        //C:\Program Files\Apache Software Foundation\apache-tomcat-7.0.81\webapps\cmfz-admin\
        String realPath=request.getRealPath("/");

        String uploadPath = realPath.replace("cmfz-admin\\","upload\\guru\\")+pictureName;
        guruPhoto.transferTo(new File(uploadPath));

        Guru guru = new Guru();
        guru.setGuruName(guruName);
        guru.setGuruIntroduction(guruIntroduction);
        guru.setGuruPhoto(pictureName);

        guruService.addGuru(guru);
    }

    @RequestMapping("/removeGuru")
    public @ResponseBody void removeGuru(String guruId){
        guruService.removeGuru(guruId);
    }

    @RequestMapping("modifyGuru")
    public @ResponseBody void modifyGuru(String guruId,String guruName,String guruIntroduction){

        Guru guru = new Guru();
        guru.setGuruId(guruId);
        guru.setGuruName(guruName);
        guru.setGuruIntroduction(guruIntroduction);

        guruService.modifyGuru(guru);
    }

    @RequestMapping("/queryAllGuru")
    public @ResponseBody Map<String, Object> queryAllGuru(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize, String name, String value){

        if(name==null){
            Page page =new Page();
            page.setPageIndex(nowPage);
            page.setSingleRows(pageSize);
            Map<String, Object> map=guruService.queryGuruByPage(page);
            return map;
        }else {
            Page page =new Page();
            page.setPageIndex(nowPage);
            page.setSingleRows(pageSize);
            Map<String, Object> map=guruService.queryGuruByKey(page,name,value);
            return map;
        }

    }
}
