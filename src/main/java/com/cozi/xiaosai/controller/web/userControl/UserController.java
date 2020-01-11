package com.cozi.xiaosai.controller.web.userControl;

import com.cozi.xiaosai.common.PageFormatConver;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.enums.OperationModule;
import com.cozi.xiaosai.enums.OperationObjects;
import com.cozi.xiaosai.enums.OperationType;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserEditParams;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupPojoParams;
import com.cozi.xiaosai.publistener.LogBehaviorPublistener;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.web.PermissionGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private LogBehaviorPublistener logBehaviorPublistener;

    /**
     * 用户列表页
     * @return
     */
    @RequestMapping("/userList")
    public String getUserList(){
        return "web/userControl/userList";
    }

    /**
     * 用户信息修改页
     * @return
     */
    @RequestMapping("/userInfoEdit")
    public String getUserInfoEdit(@RequestParam String userName, Model model){
        model.addAttribute("userName",userName);
        return "web/userControl/userInfoEdit";
    }

    /**
     * 修改密码页
     * @return
     */
    @RequestMapping("/userPasswordEdit")
    public String getuserPasswordFtl(@RequestParam String userName, Model model){
        model.addAttribute("userName",userName);
        return "web/userControl/userPassword";
    }

    /**
     * 权限组列表页
     * @return
     */
    @RequestMapping("/PermissionGroupList")
    public String getPermissionGroupList(){
        return "web/userControl/permissionGroupList";
    }

    /**
     * 权限组添加页
     * @return
     */
    @RequestMapping("/PermissionGroupAdd")
    public String getPermissionGroupAdd(){
        return "web/userControl/permissionGroupAdd";
    }

    /**
     * 权限组编辑页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/PermissionGroupEdit")
    public String getPermissionGroupEdit(@RequestParam(value = "id") Integer id, Model model){
        logger.info("id:"+id);
        model.addAttribute("id",id);
        return "web/userControl/permissionGroupEdit";
    }

    /**
     * 用户列表
     * @param userParams
     * @return
     */
    //@Log1oneAnnotation(operationType = OperationType.SELECT,operands = OperationObjects.XIAOSAI_USER)
    @RequestMapping(value = "/userListData",method = RequestMethod.POST)
    @ResponseBody
    public R getListData(@RequestBody(required = false) UserParams userParams){
        logger.info("用户信息请求参数："+userParams);
        logBehaviorPublistener.publish(new LogInfo(0, OperationModule.TONGYONGPINGTAI.getModule(),OperationType.SELECT.getValue(),OperationObjects.XIAOSAI_USER.getValue(),userParams.toString()));
        PageHelper.startPage(userParams.getPage(),userParams.getLimit(),"id");
        PageInfo<User> userPageInfo = new PageInfo<>(userService.userListByUser(userParams));
        return new PageFormatConver(userPageInfo).isOK();
    }

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/userEditEcho",method = RequestMethod.POST)
    @ResponseBody
    public R userEditEcho(@RequestParam(value = "userName") String userName){
        User user = userService.userByUserName(userName);
        user.setPassword("");
        if(user!=null){
            return R.isOk().data(user);
        }else {
            return R.isFail().msg("用户信息获取失败！");
        }
    }

    /**
     * 用户信息编辑
     * @param userEditParams
     * @return
     */
    @RequestMapping(value = "/userEditData",method = RequestMethod.POST)
    @ResponseBody
    public R userEditData(@RequestBody UserEditParams userEditParams){
        if(userEditParams.getId().intValue()<=0){
            return R.isFail().msg(CueWordsEnum.USER_FAILED_ID.getValue());
        }
        if(StringUtils.isEmpty(userEditParams.getUserName())){
            return R.isFail().msg(CueWordsEnum.USER_FAILED__USERNAME.getValue());
        }
        try {
            userService.editUserByUserEditParams(userEditParams);
            return R.isOk().msg(CueWordsEnum.BASICS_INFO_SUCCESS.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return R.isFail().msg(CueWordsEnum.BASICS_INFO_FAILED.getValue());
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/userPasswordEditData",method = RequestMethod.POST)
    @ResponseBody
    public R userPasswordEditData(@RequestBody User user, HttpServletRequest request){
        logger.info("修改密码参数："+user);
        R r = userService.userPasswordEdit(user);
        if(r.getCode()==0){
            HttpSession session = request.getSession();
            session.invalidate();
        }
        return r;
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
     * @param permissionGroupPojoParams
     * @return
     */
    @RequestMapping(value = "/PermissionGroupListData",method = RequestMethod.POST)
    @ResponseBody
    public R getPermissionGroupListData(@RequestBody PermissionGroupPojoParams permissionGroupPojoParams){
        logger.info("权限组请求参数："+permissionGroupPojoParams);
        PageHelper.startPage(permissionGroupPojoParams.getPage(),permissionGroupPojoParams.getLimit(),"id");
        PageInfo<PermissionGroupPojo> permissionGroupPojoPageInfo = new PageInfo<>(permissionGroupService.getPermissionGroup(permissionGroupPojoParams));
        return new PageFormatConver(permissionGroupPojoPageInfo).isOK();
    }

    /**
     * 权限组添加
     * @param permissionGroupPojoParams
     * @return
     */
    @RequestMapping(value = "/addPermissionGroup",method = RequestMethod.POST)
    @ResponseBody
    public R addPermissionGroup(@RequestBody PermissionGroupPojoParams permissionGroupPojoParams){
        logger.info("权限组请求参数："+permissionGroupPojoParams);
        return permissionGroupService.addPermissionGroup(permissionGroupPojoParams);
    }

    /**
     * 权限组编辑回显
     * @param id
     * @return
     */
    @RequestMapping(value = "/editPermissionGroupEcho",method = RequestMethod.POST)
    @ResponseBody
    public R editPermissionGroupEcho(@RequestParam(value = "id") Integer id){
        logger.info("id:"+id);
        return R.isOk().data(permissionGroupService.editPermissionGroupEcho(id));
    }

    /**
     * 权限组编辑
     * @param permissionGroupPojoParams
     * @return
     */
    @RequestMapping(value = "/editPermissionGroup",method = RequestMethod.POST)
    @ResponseBody
    public R editPermissionGroup(@RequestBody PermissionGroupPojoParams permissionGroupPojoParams){
        logger.info("权限组编辑参数："+permissionGroupPojoParams);
        return permissionGroupService.editPermissionGroup(permissionGroupPojoParams);
    }




}
