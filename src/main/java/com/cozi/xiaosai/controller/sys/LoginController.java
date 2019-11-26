package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-11-21 17:24
 * @Version 1.0
 */

/**
 * 用户登录处理接口
 */
@Controller
@RequestMapping("/xiaosai")
public class LoginController {

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getRegisterHtml(){
        return "xiaosai_login";
    }

    /**
     * 注册接口
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userRegister(User user, HttpServletRequest request,
                                           HttpServletResponse response){
        //userService.addUser(user);
        System.out.println(user);
        //mailSendService.sendMail(1,"cozilyo@163.com","注册信息");
        return ReturnMap.successResponse("注册成功");
    }

    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(User user, HttpServletRequest request,
                                        HttpServletResponse response){
        System.out.println(user);
        return ReturnMap.successResponse("登录成功");
    }


}
