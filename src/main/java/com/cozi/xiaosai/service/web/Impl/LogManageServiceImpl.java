package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.excel.LogManageExcel;
import com.cozi.xiaosai.mapper.dataOrigin.web.LogManageMapper;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.LogmanageParams;
import com.cozi.xiaosai.service.web.LogManageService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class LogManageServiceImpl implements LogManageService {

    @Autowired
    private LogManageMapper logManageMapper;

    @Override
    public void addLog(LogmanagePojo logmanagePojo) {
        logManageMapper.insertLog(logmanagePojo);
    }

    @Override
    public void addLogHd(LogmanagePojo logmanagePojo) {
        logManageMapper.insertLogHd(logmanagePojo);
    }

    @Override
    public Page<LogmanagePojo> getLogManageList(LogmanageParams logmanageParams) {
        return logManageMapper.selectLogManageList(logmanageParams);
    }

    @Override
    public Page<LogmanagePojo> getLogManageHdList(LogmanageParams logmanageParams) {
        return logManageMapper.selectLogManageHdList(logmanageParams);
    }

    @Override
    public List<LogManageExcel> getLogManageExcel(LogmanageParams logmanageParams) {
        return logManageMapper.selectLogManageExcel(logmanageParams);
    }

    @Override
    public List<LogManageExcel> getLogManageHdExcel(LogmanageParams logmanageParams) {
        return logManageMapper.selectLogManageHdExcel(logmanageParams);
    }
}
