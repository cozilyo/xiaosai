package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.common.UUID;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.LoginService;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import com.cozi.xiaosai.util.NumberUtil;
import com.cozi.xiaosai.util.RandomValidateCodeUtil;
import com.cozi.xiaosai.util.redis.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 用户登录处理接口
 * @author xiaosai
 * @date 2019-11-21 17:24
 * @version 1.0
 * @describe
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

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginHtml(Model model){
        return "sys/XSlogin";
    }

    @RequestMapping(value = "/regis",method = RequestMethod.GET)
    public String getRegisterHtml(){
        return "sys/XSregister";
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            //随机生成验证码，并放入redis中
            String stringRandom = NumberUtil.getStringRandom(5);
            redisUtils.set(stringRandom.toUpperCase(),"登入验证码",30L,1);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response,stringRandom);
            //输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>  ", e);
        }
    }

    @RequestMapping(value = "/checkVerify")
    @ResponseBody
    public Map<String,Object> checkVerify(@RequestParam(value = "verifyInput") String verifyInput){
        if(redisUtils.get(verifyInput.toUpperCase(), 1)!=null&&StaticValues.verify_code.equals(redisUtils.get(verifyInput.toUpperCase(), 1).toString())){
            return ReturnMap.successResponse();
        }else {
            return ReturnMap.failureResponse();
        }
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
        /*if(StringUtils.isEmpty(user.getName())){
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
        }*/
        /*if(userService.userCountByUserName(user.getUserName())>0){
            msg = "用户已存在！";
            return returnMsg(model,msg);
        }*/
        loginService.userRegister(user);
        return "sys/XSlogin";
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
    public String userLogin(User user, @RequestParam(value = "captcha") String captcha, HttpServletRequest request,
                            HttpServletResponse response, Model model){
        if(StringUtils.isEmpty(user.getUserName())){
            ReturnMap.failureResponse(StaticValues.LOGIN_USERNAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getPassword())){
            ReturnMap.failureResponse(StaticValues.LOGIN_PASSWORD_ISEMPTY);
        }
        logger.info("^-^ enter into LoginController userLogin() user:"+user.getUserName());
        //验证码有效
        if(redisUtils.get(captcha.toUpperCase(), 1)!=null&&StaticValues.verify_code.equals(redisUtils.get(captcha.toUpperCase(), 1).toString())){
            Map<String, Object> map = loginService.userLogin(user, captcha,request, response);
            if(map.get("return_code").equals(1)){
                return "redirect:/xiaosai/index";
            }else {
                return "sys/XSlogin";
            }
        //验证码失效
        }else{
            return "sys/XSlogin";
        }
    }

    /**
     * 获取用户信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public User getUserName(HttpServletRequest request,
                           HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }


    /**
     * 注销登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request,
                           HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();
        return "sys/XSlogin";
    }

}
