package com.cozi.xiaosai.controller.web.userControl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.web.PermissionGroupService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Spliterator;

/**
 * @Author xiaosai
 * @Date 2019-12-23 15:44
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping("/xiaosai")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionGroupService permissionGroupService;

    @RequestMapping("/userList")
    public String getUserList(){
        return "web/userControl/userList";
    }

    @RequestMapping("/PermissionGroupList")
    public String getPermissionGroupList(){
        return "web/userControl/permissionGroupList";
    }

    /**
     * 用户列表
     * @param user
     * @return
     */
    @RequestMapping(value = "/userListData",method = RequestMethod.POST)
    @ResponseBody
    public R getListData(@RequestBody User user){
        logger.info("用户信息请求参数："+user);
        return R.isOk().data(userService.userListByUser(user));
    }

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    @RequestMapping(value = "/batchDelUser",method = RequestMethod.POST)
    @ResponseBody
    public R batchDelUser(@RequestParam(value = "userIds") String userIds){
        logger.info("用户信息批量删除："+StringUtils.strip(userIds,"[]"));
        userService.batchDelUser(StringUtils.strip(userIds,"[]"));
        return R.isOk();
    }


    /**
     * 权限组列表
     * @param permissionGroupPojo
     * @return
     */
    @RequestMapping(value = "/PermissionGroupListData",method = RequestMethod.POST)
    @ResponseBody
    public R getPermissionGroupListData(@RequestBody PermissionGroupPojo  permissionGroupPojo){
        logger.info("权限组请求参数："+permissionGroupPojo);
        return R.isOk().data(permissionGroupService.getPermissionGroup(permissionGroupPojo));
    }


}
