package com.cozi.xiaosai.event;

import com.cozi.xiaosai.domain.LogInfo;
import org.springframework.context.ApplicationEvent;

/**
 * 日志监听自定义事件
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LogBehaviorEvent extends ApplicationEvent {

    private LogInfo logInfo;

    public LogBehaviorEvent(Object source, LogInfo logInfo) {
        super(source);
        this.logInfo=logInfo;
    }

    public LogInfo getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(LogInfo logInfo) {
        this.logInfo = logInfo;
    }
}
