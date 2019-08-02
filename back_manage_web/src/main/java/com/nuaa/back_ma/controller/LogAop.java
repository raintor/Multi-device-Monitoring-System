package com.nuaa.back_ma.controller;

import com.nuaa.back_ma.domain.SysLog;
import com.nuaa.back_ma.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @author: raintor
 * @Date: 2019/6/1 19:00
 * @Description:
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ILogService logService;

    private Date visiteTime;

    private Class clazz;

    private Method method;


    @Before("execution(* com.nuaa.back_ma.controller.*.*(..))")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException {
        //已访问就记录下访问时间
        visiteTime = new Date();
        //获得具体访问的类，getTarget方法获得的是代理d对象
        clazz = joinPoint.getTarget().getClass();
        //获取目标方法名，getSignature方法获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
        String methodName = joinPoint.getSignature().getName();
        //根据反射及方法名，获得具体的方法对象
        ///获取参数
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            //如果没有参数，直接根据方法名获得无参的方法
            method = clazz.getMethod(methodName);
        } else {
            //如果有参数，则利用getMethod的另一个重载的方法，第二个参数是参数类型的字节码类型
            Class[] argClass = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argClass[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, argClass);
        }
        System.out.println("=====");
    }

    @After("execution(* com.nuaa.back_ma.controller.*.*(..))")
    public void after() {
        //封装到对象中
        SysLog sysLog = new SysLog();
        boolean issave = true;
        //获取访问时长
        long time = (new Date()).getTime() - visiteTime.getTime();
        //获取访问的url
        String url;
        if (clazz != null && method != null && clazz != LogAop.class) {
            RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (requestMapping != null) {
                String usr1 = requestMapping.value()[0];
                RequestMapping methodRes = method.getAnnotation(RequestMapping.class);
                if (methodRes != null) {
                    String url2 = methodRes.value()[0];
                    url = usr1 + url2;
                    sysLog.setUrl(url);
                    if ("/sysLog/findAll.do".equals(url))
                        issave = false;

                }
            }
            sysLog.setMethod("[类名]：" + clazz.getName() + "  [方法名： ] " + method.getName());


        }
        //获取访问的IP
        String ip = request.getRemoteAddr();

        //获取访问者
        SecurityContext context = SecurityContextHolder.getContext();
        User principal = (User) context.getAuthentication().getPrincipal();
        String username = principal.getUsername();


        sysLog.setExecutionTime(time);
        sysLog.setId(UUID.randomUUID().toString().replace("-", ""));
        sysLog.setIp(ip);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visiteTime);

        System.out.println(sysLog);

        if (issave)
            logService.save(sysLog);

    }

}
