package com.cozi.xiaosai.publistener;

import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.event.LogBehaviorEvent;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 日志监听发布事件
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Component
public class LogBehaviorPublistener {

    private final ApplicationContext applicationContext;

    @Autowired
    public LogBehaviorPublistener(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 日志监听发布事件
     * @param logmanagePojo 日志操作对象
     * @param type 日志管理类型：0-登录日志，1-操作日志
     */
    public void publish(LogmanagePojo logmanagePojo,Integer type){
        applicationContext.publishEvent(new LogBehaviorEvent(this,logmanagePojo,type));
    }
}
