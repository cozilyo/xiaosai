package com.cozi.xiaosai.listener;

import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.event.LogBehaviorEvent;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.service.tool.Log1oneService;
import com.cozi.xiaosai.service.web.LogManageService;
import com.cozi.xiaosai.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 日志自定义事件监听
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Component
public class LogBehaviorListener {

    @Autowired
    private Log1oneService log1oneService;

    @Autowired
    private LogManageService logManageService;

    @EventListener
    public void onLogBehaviorEvent(LogBehaviorEvent logBehaviorEvent){
        if(logBehaviorEvent!=null){
            LogmanagePojo logmanagePojo = logBehaviorEvent.getLogmanagePojo();

            //获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

            //获取session
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");

            //获取ip地址
            String ipAddr = IpUtil.getIpAddr(request);
            logmanagePojo.setIp(ipAddr);

            if(user!=null){
                logmanagePojo.setOperator(user.getUserName());
            }else {
                logmanagePojo.setOperator("");
            }

            if(logBehaviorEvent.getType().equals(0)){
                logManageService.addLog(logmanagePojo);
            }else {
                logManageService.addLogHd(logmanagePojo);
            }

        }
    }
}
