package com.cozi.xiaosai.aop;

import com.cozi.xiaosai.annotation.Log1oneAnnotation;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.tool.Log1oneService;
import com.cozi.xiaosai.util.IpUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Author xiaosai
 * @Date 2019-12-11 18:18
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private static LogInfo logInfo = new LogInfo();

    @Autowired
    private Log1oneService log1oneService;

    // 切入点签名
    @Pointcut("@annotation(com.cozi.xiaosai.annotation.Log1oneAnnotation)")
    public void cut() {
    }

    // 前置通知
    @Before("cut()")
    public void BeforeCall() {
    }

    // 环绕通知
    @Around(value = "cut()")
    public Object AroundCall(ProceedingJoinPoint joinPoint) throws Throwable {
        //执行目标方法，并获得对应方法的返回值.如果不是R<T>则
        R r = null;
        try {
            r = (R)joinPoint.proceed();
        }catch (Exception e){
            return addLog(joinPoint);
        }
        //模块名称
        logInfo.setOperationModule(getModule(joinPoint));


        // 获取参数
        Object[] arguments = joinPoint.getArgs();
        for(Object o:arguments){
            if(o instanceof HttpServletRequest){
                String ipAddr = IpUtil.getIpAddr((HttpServletRequest) o);
                logInfo.setIp(ipAddr);
                String token = ((HttpServletRequest) o).getHeaders("token").toString();
                HttpSession session = ((HttpServletRequest) o).getSession();
                User user = (User)session.getAttribute("user");
                logInfo.setOperator(user.getUserName());
            }
        }

        if(StringUtils.isEmpty(logInfo.getIp())||StringUtils.isEmpty(logInfo.getOperator())){
            return r;
        }

        //获取注解方法的注解值
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        Method method = ms.getMethod();
        Log1oneAnnotation annotation = method.getAnnotation(Log1oneAnnotation.class);

        logInfo.setOperationType(annotation.operationType());
        logInfo.setOperands(annotation.operands());
        logInfo.setOperationContent(r.getMsg());

        log1oneService.addLog(logInfo);

        return r;
    }

    //如果不是以R<T>为返回值时
    public Object addLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解所切的方法所在类的全类名
        String typeName = joinPoint.getTarget().getClass().getName();

        //模块名称
        logInfo.setOperationModule(getModule(joinPoint));


        // 获取参数
        Object[] arguments = joinPoint.getArgs();
        for(Object o:arguments){
            if(o instanceof HttpServletRequest){
                String ipAddr = IpUtil.getIpAddr((HttpServletRequest) o);
                logInfo.setIp(ipAddr);
                String token = ((HttpServletRequest) o).getHeaders("token").toString();
                HttpSession session = ((HttpServletRequest) o).getSession();
                User user = (User)session.getAttribute("user");
                logInfo.setOperator(user.getUserName());
            }
        }

        //获取注解方法的注解值
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        Method method = ms.getMethod();
        Log1oneAnnotation annotation = method.getAnnotation(Log1oneAnnotation.class);

        logInfo.setOperationType(annotation.operationType());
        logInfo.setOperands(annotation.operands());
        logInfo.setOperationContent(annotation.msg());

        log1oneService.addLog(logInfo);

        return joinPoint.proceed();

    }

    public String getModule(ProceedingJoinPoint joinPoint){
        // 注解所切的方法所在类的全类名
        String typeName = joinPoint.getTarget().getClass().getName();
//        ExeStrategy exeStrategy = new ExeStrategy(new TyStrategy());

        if(typeName.contains("com.cozi.xiaosai")){
            return "学校";
        }else if(typeName.contains(StaticValues.TYPE_NAME)){
//            exeStrategy.executeStrategy();
            return StaticValues.TYPE_NAME_VALUE;
        }else if(typeName.contains(StaticValues.TYPE_NAME_CRB)){
//            exeStrategy = new ExeStrategy(new CrbStrategy());
//            exeStrategy.executeStrategy();
            return StaticValues.TYPE_NAME_CRB_VALUE;
        }else if(typeName.contains(StaticValues.TYPE_NAME_OCC)){
//            exeStrategy = new ExeStrategy(new OccStrategy());
//            exeStrategy.executeStrategy();
            return StaticValues.TYPE_NAME_OCC_VALUE;
        }else if(typeName.contains(StaticValues.TYPE_NAME_SCH)){
//            exeStrategy = new ExeStrategy(new SchStrategy());
//            exeStrategy.executeStrategy();
            return StaticValues.TYPE_NAME_SCH_VALUE;
        }else if(typeName.contains(StaticValues.TYPE_NAME_JHB)){
//            exeStrategy = new ExeStrategy(new JhbStrategy());
//            exeStrategy.executeStrategy();
            return StaticValues.TYPE_NAME_JHB_VALUE;
        }else{
            return "未知模块";
        }
    }

    // 后置通知
    @After("cut()")
    public void AfterCall() {
    }

    // 最终通知
    @AfterReturning("cut()")
    public void AfterReturningCall() {
    }

    // 异常通知
    @AfterThrowing(value = "cut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        throw new RuntimeException(ex);
    }
}
