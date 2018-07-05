package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.FirstMenu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xl on 2018/7/5 0005.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryAllFirstMenu")
    public @ResponseBody List<FirstMenu> queryAllFirstMenu(){

        List<FirstMenu> firstMenus= menuService.queryAllFirstMenu();

        return firstMenus;
    }

}
