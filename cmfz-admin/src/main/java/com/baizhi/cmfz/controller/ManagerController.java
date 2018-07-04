package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xl on 2018/7/4 0004.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;



    /**
     * 管理员注册
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/addManager")
    public String addManager(String name,String pwd){

        Manager manager = new Manager();
        manager.setName(name);
        manager.setPwd(pwd);

        return "login";
    }

    /**
     * 管理员登录
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/loginManager")
    public String loginManager(String name, String pwd, String flag, HttpSession session, HttpServletResponse response, HttpServletRequest request){
        System.out.println(flag);

        Manager manager = managerService.loginManager(name, pwd);
        if(manager!=null){
            session.setAttribute("manager",manager);

            if(flag!=null){
                Cookie c1=new Cookie("name",name);

                c1.setPath(request.getContextPath());
                c1.setMaxAge(7*24*60*60);
                response.addCookie(c1);
            }
            return "main";
        }
       return "login";
    }

    /**
     *
     */
    @RequestMapping("/createVaildateCode")
    public void createVaildateCode(HttpServletResponse response,HttpSession session) throws IOException {
        CreateValidateCodeUtil utils=new CreateValidateCodeUtil(80, 25, 4);
        String code=utils.getCode();
        System.out.println(code);
        session.setAttribute("code",code);
        utils.write(response.getOutputStream());
    }

    /**
     *
     * @return
     */
    @RequestMapping("/verifyCode")
    public @ResponseBody boolean verifyCode(String enCode, HttpSession session){
        if(enCode.equals(session.getAttribute("code"))){
            return true;
        }
        return false;
    }
}
