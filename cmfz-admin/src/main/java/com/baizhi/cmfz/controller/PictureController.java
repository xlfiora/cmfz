package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody void addPicture(String pictureName,String pictureMessage,String pictureStatus){

        Picture picture=new Picture();
        picture.setPictureName(pictureName);
        picture.setPictureMessage(pictureMessage);
        picture.setPictureStatus(pictureStatus);
        picture.setPictureDate(new Date());

        pictureService.addPicture(picture);
    }

    @RequestMapping("/removePicture")
    public @ResponseBody void removePicture(String pictureId){
        pictureService.removePicture(pictureId);
    }

    @RequestMapping("/modfiyPicture")
    public @ResponseBody void modfiyPicture(String pictureId,String pictureName,String pictureMessage,String pictureStatus,Date pictureDate){
        Picture picture=new Picture();
        picture.setPictureId(pictureId);
        picture.setPictureName(pictureName);
        picture.setPictureMessage(pictureMessage);
        picture.setPictureStatus(pictureStatus);
        picture.setPictureDate(pictureDate);

        pictureService.modfiyPicture(picture);

    }

    @RequestMapping("/queryPictureById")
    public @ResponseBody Picture queryPictureById(String pictureId){
        return pictureService.queryPictureById(pictureId);
    }

    @RequestMapping("/queryPictureByPage")
    public @ResponseBody Map<String,Object> queryPictureByPage(@RequestParam("page")Integer nowPage, @RequestParam("rows")Integer pageSize){
        Page page = new Page();
        page.setPageIndex(nowPage);
        page.setSingleRows(pageSize);
        return pictureService.queryPictureByPage(page);

    }


}
