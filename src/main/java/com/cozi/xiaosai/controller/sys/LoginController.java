package com.cozi.xiaosai.controller.sys;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.common.UUID;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.enums.OperationModule;
import com.cozi.xiaosai.enums.OperationObjects;
import com.cozi.xiaosai.enums.OperationType;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.web.LogmanagePojo;
import com.cozi.xiaosai.publistener.LogBehaviorPublistener;
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
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private LogBehaviorPublistener logBehaviorPublistener;

    /**
     * 登录页
     * @param model
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginHtml(Model model){
        return "sys/XSlogin";
    }

    /**
     * 注册页
     * @return
     */
    @RequestMapping(value = "/regis",method = RequestMethod.GET)
    public String getRegisterHtml(){
        return "sys/XSregister";
    }

    /**
     * 二维码展示页
     * @return
     */
    @RequestMapping(value = "/qrCode",method = RequestMethod.GET)
    public String getQRcodeFtl(HttpServletRequest request,Model model){
        return "sys/QRcode";
    }

    /**
     *错误提示页419
     * @return
     */
    @RequestMapping(value = "/p419",method = RequestMethod.GET)
    public String get419Error(){
        return "sys/error/419";
    }

    /**
     * 错误提示页423
     * @return
     */
    @RequestMapping(value = "/p423",method = RequestMethod.GET)
    public String get423Error(){
        return "sys/error/423";
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
            String stringRandom = NumberUtil.getRandomString(5);
            redisUtils.set(stringRandom.toUpperCase(), CueWordsEnum.LOGIN_VERIFY.getValue(),30L);
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
        if(redisUtils.get(verifyInput.toUpperCase())!=null&&StaticValues.verify_code.equals(redisUtils.get(verifyInput.toUpperCase()).toString())){
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
    @ResponseBody
    public R userLogin(@RequestBody User user,HttpServletRequest request,
                       HttpServletResponse response, Model model){
        if(StringUtils.isEmpty(user.getUserName())){
            return R.isFail().msg(StaticValues.LOGIN_USERNAME_ISEMPTY);
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return R.isFail().msg(StaticValues.LOGIN_PASSWORD_ISEMPTY);
        }
        logger.info("^-^ enter into LoginController userLogin() user:"+user.getUserName());
        //验证码有效
        if(redisUtils.get(user.getCaptcha().toUpperCase())!=null&&StaticValues.verify_code.equals(redisUtils.get(user.getCaptcha().toUpperCase()).toString())){
            Map<String, Object> map = loginService.userLogin(user, user.getCaptcha(),request, response);
            if(map.get("return_code").equals(1)){
                try {
                    logBehaviorPublistener.publish(
                            new LogmanagePojo(0, OperationModule.TONGYONGPINGTAI.getModule(), OperationType.SELECT.getValue(),
                                    OperationObjects.XIAOSAI_USER.getValue(),CueWordsEnum.LOG_MANAGE_LOGIN_IN.getValue()), 0);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return R.isOk().data(user.getUserName()).msg(CueWordsEnum.LOGIN_SUCCESS.getValue());
            }else {
                return R.isFail().msg(CueWordsEnum.LOGIN_FAILED_PASSWORD_ERROR.getValue());
            }
        //验证码失效
        }else{
            return R.isFail().msg(CueWordsEnum.LOGIN_FAILED_VERIFY_ERROR.getValue());
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
        try {
            logBehaviorPublistener.publish(
                    new LogmanagePojo(0, OperationModule.TONGYONGPINGTAI.getModule(), OperationType.SELECT.getValue(),
                            OperationObjects.XIAOSAI_USER.getValue(),CueWordsEnum.LOG_MANAGE_LOGIN_OUT.getValue()), 0);
        }catch (Exception e){
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.invalidate();
        return "sys/XSlogin";
    }

    @RequestMapping(value = "/getLoginQr",method = RequestMethod.GET)
    public  void creteQrImg(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        try {
            //这里没啥操作 就是生成一个UUID插入 数据库的表里
            String uuid = UUID.getUuid();
            //logger.info("UUID:"+uuid);
            response.setHeader("uuid", uuid);
            // 这里是开源工具类 hutool里的QrCodeUtil
            // 网址：http://hutool.mydoc.io/
            QrCodeUtil.generate(uuid, 300, 300, "jpg",response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
