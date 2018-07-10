package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Distribution;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by xl on 2018/7/9 0009.
 */
@Service
@RequestMapping("/count")
public class CountController {


    @RequestMapping("/maleDistribution")
    public @ResponseBody List<Distribution> maleDistribution(){

        List<Distribution> male=new ArrayList<>();
        male.add(new Distribution("北京",new Random().nextInt(99999)));
        male.add(new Distribution("天津",new Random().nextInt(99999)));
        male.add(new Distribution("上海",new Random().nextInt(99999)));
        male.add(new Distribution("重庆",new Random().nextInt(99999)));
        male.add(new Distribution("河北",new Random().nextInt(99999)));
        male.add(new Distribution("河南",new Random().nextInt(99999)));
        male.add(new Distribution("云南",new Random().nextInt(99999)));
        male.add(new Distribution("辽宁",new Random().nextInt(99999)));
        male.add(new Distribution("黑龙江",new Random().nextInt(99999)));
        male.add(new Distribution("湖南",new Random().nextInt(99999)));
        male.add(new Distribution("安徽",new Random().nextInt(99999)));
        male.add(new Distribution("新疆",new Random().nextInt(99999)));
        male.add(new Distribution("江苏",new Random().nextInt(99999)));
        male.add(new Distribution("浙江",new Random().nextInt(99999)));
        male.add(new Distribution("江西",new Random().nextInt(99999)));
        male.add(new Distribution("湖北",new Random().nextInt(99999)));
        male.add(new Distribution("广西",new Random().nextInt(99999)));
        male.add(new Distribution("甘肃",new Random().nextInt(99999)));
        male.add(new Distribution("山西",new Random().nextInt(99999)));
        male.add(new Distribution("山东",new Random().nextInt(99999)));
        male.add(new Distribution("内蒙古",new Random().nextInt(99999)));
        male.add(new Distribution("陕西",new Random().nextInt(99999)));
        male.add(new Distribution("吉林",new Random().nextInt(99999)));
        male.add(new Distribution("福建",new Random().nextInt(99999)));
        male.add(new Distribution("贵州",new Random().nextInt(99999)));
        male.add(new Distribution("广东",new Random().nextInt(99999)));
        male.add(new Distribution("青海",new Random().nextInt(99999)));
        male.add(new Distribution("西藏",new Random().nextInt(99999)));
        male.add(new Distribution("四川",new Random().nextInt(99999)));
        male.add(new Distribution("宁夏",new Random().nextInt(99999)));
        male.add(new Distribution("海南",new Random().nextInt(99999)));
        male.add(new Distribution("台湾",new Random().nextInt(99999)));
        male.add(new Distribution("香港",new Random().nextInt(99999)));
        male.add(new Distribution("澳门",new Random().nextInt(99999)));

        return  male;
    }

    @RequestMapping("/femaleDistribution")
    public @ResponseBody List<Distribution> femaleDistribution(){

        List<Distribution> female=new ArrayList<>();
        female.add(new Distribution("北京",new Random().nextInt(99999)));
        female.add(new Distribution("天津",new Random().nextInt(99999)));
        female.add(new Distribution("上海",new Random().nextInt(99999)));
        female.add(new Distribution("重庆",new Random().nextInt(99999)));
        female.add(new Distribution("河北",new Random().nextInt(99999)));
        female.add(new Distribution("河南",new Random().nextInt(99999)));
        female.add(new Distribution("云南",new Random().nextInt(99999)));
        female.add(new Distribution("辽宁",new Random().nextInt(99999)));
        female.add(new Distribution("黑龙江",new Random().nextInt(99999)));
        female.add(new Distribution("湖南",new Random().nextInt(99999)));
        female.add(new Distribution("安徽",new Random().nextInt(99999)));
        female.add(new Distribution("新疆",new Random().nextInt(99999)));
        female.add(new Distribution("江苏",new Random().nextInt(99999)));
        female.add(new Distribution("浙江",new Random().nextInt(99999)));
        female.add(new Distribution("江西",new Random().nextInt(99999)));
        female.add(new Distribution("湖北",new Random().nextInt(99999)));
        female.add(new Distribution("广西",new Random().nextInt(99999)));
        female.add(new Distribution("甘肃",new Random().nextInt(99999)));
        female.add(new Distribution("山西",new Random().nextInt(99999)));
        female.add(new Distribution("山东",new Random().nextInt(99999)));
        female.add(new Distribution("内蒙古",new Random().nextInt(99999)));
        female.add(new Distribution("陕西",new Random().nextInt(99999)));
        female.add(new Distribution("吉林",new Random().nextInt(99999)));
        female.add(new Distribution("福建",new Random().nextInt(99999)));
        female.add(new Distribution("贵州",new Random().nextInt(99999)));
        female.add(new Distribution("广东",new Random().nextInt(99999)));
        female.add(new Distribution("青海",new Random().nextInt(99999)));
        female.add(new Distribution("西藏",new Random().nextInt(99999)));
        female.add(new Distribution("四川",new Random().nextInt(99999)));
        female.add(new Distribution("宁夏",new Random().nextInt(99999)));
        female.add(new Distribution("海南",new Random().nextInt(99999)));
        female.add(new Distribution("台湾",new Random().nextInt(99999)));
        female.add(new Distribution("香港",new Random().nextInt(99999)));
        female.add(new Distribution("澳门",new Random().nextInt(99999)));

        return  female;
    }

}
