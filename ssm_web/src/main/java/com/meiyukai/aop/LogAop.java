package com.meiyukai.aop;

import com.meiyukai.controller.sysLogController;
import com.meiyukai.ssm.domain.SysLog;
import com.meiyukai.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
//当前是一个切面
public class LogAop {

    //注入 request
    @Autowired
    private HttpServletRequest request;
    //注入 SysLogService
    @Resource(name = "sysLogService")
    private ISysLogService sysLogService;

    //访问的开始时间
    private Date visitTime;
    //访问的类
    private Class clazz;
    //访问的方法
    private Method method;
    //访问的IP地址
    private String ip;
    //获取当前访问的用户
    private String username;

    private SysLog sysLog ;


    /*@Pointcut(  value = "execution(* com.meiyukai.controller.*.*(..))")
    private void pointcut1(){

    }*/


    //前置通知 主要获取开始时间，执行的类是哪一个，执行的方法。
    @Before(value = "execution(* com.meiyukai.controller.*.*(..))")  //或者省略pointcut1() 换成 execution
    public void doBefore(JoinPoint joinPoint) throws Exception {
        sysLog = new SysLog();
        visitTime = new Date();  //当前时间
        sysLog.setVisitTime(visitTime);
        clazz = joinPoint.getTarget().getClass(); //具体要访问的类
        String methodName  = joinPoint.getSignature().getName(); //获取方法名
        sysLog.setMethod(clazz.getName()+methodName);

        Object[] args = joinPoint.getArgs();//获取参数
        if(args == null || args.length==0){
            method = clazz.getDeclaredMethod(methodName);
        }else{
            Class[] paramClazzs = new Class[args.length];
            for(int i=0 ; i<args.length ; i++){
                Class tempClass = args[i].getClass();
                String tempClassName = tempClass.getName();

                if(tempClassName.contains("ModelMap")){
                    tempClass =   tempClass.getSuperclass().getSuperclass();
                }
                paramClazzs[i] = tempClass;
            }
            method = clazz.getDeclaredMethod(methodName , paramClazzs);
        }
    }




    //后置通知
    @AfterReturning(value = "execution(* com.meiyukai.controller.*.*(..))")
    public void doAfterReturning(JoinPoint joinPoint){

        Long time = new Date().getTime()-visitTime.getTime(); //操作时间
        sysLog.setExecutionTime(time);
        String methodValue = null;
        String clazzValue =null;
        String url = null;

        //获取 URL
        if(clazz!=null && method!=null&& clazz!= LogAop.class&& clazz!= sysLogController.class) {
            //1.获取类上的注解
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            //2.获取方法上的注解
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            //3.获取类上的注解的内容
            if(classAnnotation!=null){
                clazzValue = classAnnotation.value()[0].toString();

            }
            //4.获取方法上的注解的内容
            if(methodAnnotation!=null){
                methodValue =methodAnnotation.value()[0].toString();
            }
            url = clazzValue + methodValue; // 获取当前的url
            sysLog.setUrl(url);

            //获取访问的 IP地址
            ip = request.getRemoteAddr();
            sysLog.setIp(ip);

            //从Security上下文中获取当前操作的对象  (* --- 或者从sessioin中获取,调用 getAttribute（"SPRING_SECURITY_CONTEXT"）---*)
            SecurityContext securityContext = SecurityContextHolder.getContext();
            User user = (User) securityContext.getAuthentication().getPrincipal();
            String username = user.getUsername();
            sysLog.setUsername(username);
            sysLog.setId(UUID.randomUUID().toString().replace("-",""));
            sysLogService.saveSysLog(sysLog);

        }

    }





}
