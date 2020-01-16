package com.cozi.xiaosai.controller.web;

import com.cozi.xiaosai.common.PageFormatConver;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.LogmanageParams;
import com.cozi.xiaosai.service.web.LogManageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class LogManageController {

    @Autowired
    private LogManageService logManageService;

    /**
     * 日志管理-登录日志管理页
     * @return
     */
    @RequestMapping(value = "/logManageList",method = RequestMethod.GET)
    public String getLogManageListFtl(){
        return "web/logmanage/LogManageList";
    }

    /**
     * 日志管理-操作日志管理页
     * @return
     */
    @RequestMapping(value = "/logManageHdList",method = RequestMethod.GET)
    public String getLogManageHdListFtl(){
        return "web/logmanage/LogManageHdList";
    }

    /**
     * 日志管理-登录日志管理列表
     * @return
     */
    @RequestMapping(value = "/logManageListData",method = RequestMethod.POST)
    @ResponseBody
    public R getLogManageListData(@RequestBody(required = false) LogmanageParams logmanageParams){
        PageHelper.startPage(logmanageParams.getPage(),logmanageParams.getLimit());
        PageInfo<LogmanagePojo> logManage = new PageInfo<>(logManageService.getLogManageList(logmanageParams));
        return new PageFormatConver(logManage).isOK();
    }

    /**
     * 日志管理-操作日志管理列表
     * @param logmanageParams
     * @return
     */
    @RequestMapping(value = "/logManageListHdData",method = RequestMethod.POST)
    @ResponseBody
    public R getLogManageHdListData(@RequestBody(required = false) LogmanageParams logmanageParams){
        PageHelper.startPage(logmanageParams.getPage(),logmanageParams.getLimit());
        PageInfo<LogmanagePojo> logManage = new PageInfo<>(logManageService.getLogManageHdList(logmanageParams));
        return new PageFormatConver(logManage).isOK();
    }

}
