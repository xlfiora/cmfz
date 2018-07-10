package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
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
 * Created by xl on 2018/7/5 0005.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/addPicture")
    public @ResponseBody
    void addPicture(MultipartFile newPicture, String pictureMessage, String pictureStatus, HttpServletRequest request) throws IOException {

        String pictureName = newPicture.getOriginalFilename();
        String[] s = pictureName.split("\\.");
        String newName = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        pictureName = newName + "." + s[1];

        //C:\Program Files\Apache Software Foundation\apache-tomcat-7.0.81\webapps\cmfz-admin\
        String realPath = request.getRealPath("/");

        String uploadPath = realPath.replace("cmfz-admin\\", "upload\\picture\\") + pictureName;
        newPicture.transferTo(new File(uploadPath));

        Picture picture = new Picture();
        picture.setPictureName(pictureName);
        picture.setPictureMessage(pictureMessage);
        picture.setPictureStatus(pictureStatus);
        picture.setPictureDate(new Date());

        pictureService.addPicture(picture);
    }

    @RequestMapping("/removePicture")
    public @ResponseBody
    void removePicture(String pictureId) {
        pictureService.removePicture(pictureId);
    }

    @RequestMapping("/modifyPicture")
    public @ResponseBody
    void modifyPicture(String pictureId, String pictureMessage, String pictureStatus) {
        Picture picture = new Picture();
        picture.setPictureId(pictureId);
        picture.setPictureMessage(pictureMessage);
        picture.setPictureStatus(pictureStatus);

        pictureService.modifyPicture(picture);

    }

    @RequestMapping("/queryPictureById")
    public @ResponseBody
    Picture queryPictureById(String pictureId) {
        return pictureService.queryPictureById(pictureId);
    }

    @RequestMapping("/queryPictureByPage")
    public @ResponseBody
    Map<String, Object> queryPictureByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize) {
        Page page = new Page();
        page.setPageIndex(nowPage);
        page.setSingleRows(pageSize);
        return pictureService.queryPictureByPage(page);

    }

}
