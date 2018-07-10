package com.baizhi.cmfz.advice;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xl on 2018/7/9 0009.
 */
@Aspect
public class LogAdvice {

    @Autowired
    private LogDao logDao;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*Impl.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.modify*(..))")
    public void logPc(){}

    @Around("logPc()")
    public Object LogAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----创建日志开始----");

        Log log = new Log();

        Object[] args = pjp.getArgs();

        //用户名
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session =request.getSession();

        Manager manager = (Manager) session.getAttribute("manager");
        log.setUserName(manager.getName());

        //事务源
        String resource=args[0].getClass().toString();
        log.setLogResource(resource.substring(resource.lastIndexOf(".")+1));

        //事务名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.setLogAction(methodSignature.getMethod().getName());

        //事务详细信息
        String message="";
        for (Object arg : args) {
            message=message.concat(arg.toString());
        }
        log.setLogMessage(message);

        //事务结果
        Object obj=null;
        String result="";
        try {
            obj = pjp.proceed();
            result="success";
        } catch (Throwable throwable) {
            result="fail";
            throwable.printStackTrace();
        }
        log.setLogResult(result);

        logDao.insertLog(log);

        System.out.println("----创建日志结束----");

        return obj;

    }
}
