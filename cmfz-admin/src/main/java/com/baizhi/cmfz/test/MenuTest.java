package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.FirstMenu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by xl on 2018/7/5 0005.
 */
public class MenuTest {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        MenuService menuServiceImpl = (MenuService) ctx.getBean("menuServiceImpl");

        List<FirstMenu> firstMenus = menuServiceImpl.queryAllFirstMenu();

        for (FirstMenu firstMenu : firstMenus) {
            System.out.println(firstMenu);
        }

    }

}
