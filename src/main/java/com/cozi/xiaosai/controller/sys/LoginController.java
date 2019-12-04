package com.cozi.xiaosai.controller.sys;

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

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginHtml(){
        return "xiaosai_login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterHtml(){
        return "xiaosai_register";
    }

    /**
     * 注册接口
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userRegister(User user, HttpServletRequest request,
                                           HttpServletResponse response){
        String uuid = UUID.getUuid();
        logger.info("^-^ enter into LoginController userRegister() 'registered user' : "+uuid);
        //唯一id标识
        user.setUserId(uuid);
        if(StringUtils.isEmpty(user.getName())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_NAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getUserName())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_USERNAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_PASSWORD_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getMail())&& VerifyUtil.verifyMail(user.getMail())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_MAIL_ISEMPTY);
        }
        return loginService.userRegister(user);
    }

    /**
     * 用户登录检查
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(User user, HttpServletRequest request,
                                        HttpServletResponse response){
        if(StringUtils.isEmpty(user.getUserName())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_USERNAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return ReturnMap.failureResponse(StaticValues.LOGIN_PASSWORD_ISEMPTY);
        }
        logger.info("^-^ enter into LoginController userLogin() user:"+user.getUserName());
        return loginService.userLogin(user);
    }


}
