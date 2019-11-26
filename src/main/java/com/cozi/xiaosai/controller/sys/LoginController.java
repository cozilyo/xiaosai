package com.cozi.xiaosai.controller.sys;

/**
 * @Author xiaosai
 * @Date 2019-11-21 17:24
 * @Version 1.0
 */

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户登录处理接口
 */
@RestController
public class LoginController {

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/register")
    public Map<String,Object> userRegister(User user, HttpServletRequest request,
                                           HttpServletResponse response){
        userService.addUser(user);
        mailSendService.sendMail(1,"cozilyo@163.com","注册信息");
        return ReturnMap.successResponse("注册成功");
    }



}
