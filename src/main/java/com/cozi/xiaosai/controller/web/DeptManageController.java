package com.cozi.xiaosai.controller.web;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.cozi.xiaosai.service.web.DeptManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 部门管理
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class DeptManageController {

    @Autowired
    private DeptManageService deptManageService;

    /**
     * 部门管理页
     * @return
     */
    @RequestMapping("/deptManage")
    public String getDeptManageFtl(){
        return "web/DeptManage/DeptManageTree";
    }


    /**
     * 部门信息树结构
     * @return
     */
    @RequestMapping(value = "/deptManageData",method = RequestMethod.POST)
    @ResponseBody
    public R getDeptManageData(){
        return deptManageService.getDeptManageData();
    }

    /**
     * 某个部门下的人
     * @param userParams
     * @return
     */
    @RequestMapping(value = "/deptToUserData",method = RequestMethod.POST)
    @ResponseBody
    public R getDeptToUser(@RequestBody(required = false) UserParams userParams){
        return deptManageService.getDeptToUser(userParams);
    }

}
