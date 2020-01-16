package com.cozi.xiaosai.event;

import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import org.springframework.context.ApplicationEvent;

/**
 * 日志监听自定义事件
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LogBehaviorEvent extends ApplicationEvent {

    private LogmanagePojo logmanagePojo;

    //日志管理类型：0-登录日志，1-操作日志
    private Integer type;

    public LogBehaviorEvent(Object source,LogmanagePojo logmanagePojo,Integer type) {
        super(source);
        this.logmanagePojo=logmanagePojo;
        this.type = type;
    }

    public LogmanagePojo getLogmanagePojo() {
        return logmanagePojo;
    }

    public void setLogmanagePojo(LogmanagePojo logmanagePojo) {
        this.logmanagePojo = logmanagePojo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
