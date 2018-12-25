package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.CreateValidateCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        managerService.addManager(manager);
        return "login";

    }

    /**
     * 管理员登录
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/loginManager")
    public String loginManager(String name, String pwd,boolean rememberMe,HttpSession session){

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(name,pwd,rememberMe));
            session.setAttribute("managerName",subject.getPrincipal());
            System.out.println(subject.hasRole("root")? "有root":"无root");
            return "main";
        } catch (UnknownAccountException uae) {
            uae.printStackTrace();
            return "login";
        }catch (IncorrectCredentialsException ice){
            ice.printStackTrace();
            return "login";
        }catch (AuthenticationException ae){
            ae.printStackTrace();
            return "login";
        }

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
