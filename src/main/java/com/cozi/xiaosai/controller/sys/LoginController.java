package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.annotation.Log1oneAnnotation;
import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.common.UUID;
import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import com.cozi.xiaosai.service.sys.LoginService;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import com.cozi.xiaosai.util.VerifyUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginHtml(Model model){
        model.addAttribute("msg","");
        return "sys/XSlogin";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterHtml(Model model){
        model.addAttribute("msg","");
        return "sys/xiaosai_register";
    }



    /**
     * 注册接口
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String userRegister(User user, HttpServletRequest request,
                                           HttpServletResponse response,Model model){
        String msg = "";
        String uuid = UUID.getUuid();
        logger.info("^-^ enter into LoginController userRegister() 'registered user' : "+uuid);
        //唯一id标识
        user.setUserId(uuid);
        if(StringUtils.isEmpty(user.getName())){
            msg = "姓名不能为空！";
            return returnMsg(model,msg);
        }
        if(StringUtils.isEmpty(user.getUserName())){
            msg = "用户名不能为空！";
            return returnMsg(model,msg);
        }
        if(StringUtils.isEmpty(user.getPassword())||StringUtils.isEmpty(user.getPasswords())||!user.getPassword().equals(user.getPasswords())){
            msg = "密码为空或者两次密码不一致！";
            return returnMsg(model,msg);
        }
        if(StringUtils.isEmpty(user.getMail())|| !VerifyUtil.verifyMail(user.getMail())){
            msg = "邮箱为空或者邮箱无效！";
            return returnMsg(model,msg);
        }
        if(userService.userCountByUserName(user.getUserName())>0){
            msg = "用户已存在！";
            return returnMsg(model,msg);
        }
        loginService.userRegister(user);
        model.addAttribute("msg",msg);
        return "sys/xiaosai_login";
    }

    public String returnMsg(Model model,String msg){
        model.addAttribute("msg",msg);
        return "sys/xiaosai_register";
    }

    /**
     *用户登录检查，成功后直接进入首页
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public String userLogin(User user, HttpServletRequest request,
                                        HttpServletResponse response,Model model){
        if(StringUtils.isEmpty(user.getUserName())){
            ReturnMap.failureResponse(StaticValues.LOGIN_USERNAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getPassword())){
            ReturnMap.failureResponse(StaticValues.LOGIN_PASSWORD_ISEMPTY);
        }
        logger.info("^-^ enter into LoginController userLogin() user:"+user.getUserName());
        Map<String, Object> map = loginService.userLogin(user, request, response);
        if(map.get("return_code").equals(1)){
            return "layuimini/index";
        }else {
            model.addAttribute("msg","用户名或密码错误！");
            return "sys/XSlogin";
        }

    }

}
