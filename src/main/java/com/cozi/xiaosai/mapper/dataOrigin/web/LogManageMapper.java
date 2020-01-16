package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.LogmanageParams;
import com.github.pagehelper.Page;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface LogManageMapper {
    void insertLog(LogmanagePojo logmanagePojo);

    void insertLogHd(LogmanagePojo logmanagePojo);

    Page<LogmanagePojo> selectLogManageList(LogmanageParams logmanageParams);

    Page<LogmanagePojo> selectLogManageHdList(LogmanageParams logmanageParams);
}
