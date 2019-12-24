package com.cozi.xiaosai.controller.web.userControl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.web.PermissionGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/userListData",method = RequestMethod.POST)
    @ResponseBody
    public R getListData(@RequestBody User user){
        logger.info("用户信息请求参数："+user);
        return R.isOk().data(userService.userListByUser(user));
    }

    @RequestMapping(value = "/PermissionGroupListData",method = RequestMethod.POST)
    @ResponseBody
    public R getPermissionGroupListData(@RequestBody PermissionGroupPojo  permissionGroupPojo){
        logger.info("权限组请求参数："+permissionGroupPojo);
        return R.isOk().data(permissionGroupService.getPermissionGroup(permissionGroupPojo));
    }
}
