package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Page;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping("/addGuruByExcel")
    public @ResponseBody void addGuruByExcel(MultipartFile guruExcel) {

        List<Guru> gurus = null;
        try {
            gurus = ExcelImportUtil.importExcel(guruExcel.getInputStream(), Guru.class, new ImportParams());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Guru guru : gurus) {
            guru.setGuruId(UUID.randomUUID().toString().replace("-",""));
        }
        guruService.addGurus(gurus);
    }

    @RequestMapping("/exportGuruExcel")
    public void exportGuruExcel(HttpServletResponse response) throws IOException {
        List<Guru> gurus=guruService.queryAllGuru();

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("xl", "上市信息表"), Guru.class, gurus);

        ServletOutputStream out =response.getOutputStream();

        String fileName = new String("上师信息表.xls".getBytes(),"iso-8859-1");
        //文件下载 设置响应头
        response.setContentType("application/vnd.ms-excel");//响应类型
        response.setHeader("content-disposition","attachment;fileName="+fileName);

        //导出 文件下载方式
        workbook.write(out);
        out.close();
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

    @RequestMapping("/queryGuru")
    public @ResponseBody List<Guru> queryGuru(){
        return guruService.queryAllGuru();
    }

}
