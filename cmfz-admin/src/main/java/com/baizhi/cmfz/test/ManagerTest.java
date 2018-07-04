package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xl on 2018/7/4 0004.
 */
public class ManagerTest {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService managerService = (ManagerService) ctx.getBean("managerServiceImpl");

        Manager manager=new Manager();
        manager.setName("xl");
        manager.setPwd("123");

        Integer r= managerService.addManager(manager);

        System.out.println(manager);

        System.out.println(r);
    }
}
