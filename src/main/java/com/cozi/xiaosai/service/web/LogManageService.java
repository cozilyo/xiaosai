package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.LogmanageParams;
import com.github.pagehelper.Page;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface LogManageService {

    void addLog(LogmanagePojo logmanagePojo);

    void addLogHd(LogmanagePojo logmanagePojo);

    Page<LogmanagePojo> getLogManageList(LogmanageParams logmanageParams);

    Page<LogmanagePojo> getLogManageHdList(LogmanageParams logmanageParams);
}
