package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.LoginService;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import com.cozi.xiaosai.util.TimeUtils;
import com.cozi.xiaosai.util.aes.AES;
import com.cozi.xiaosai.util.aes.AesKey;
import com.cozi.xiaosai.util.redis.RedisKey;
import com.cozi.xiaosai.util.redis.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:55
 * @Version 1.0
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Map<String, Object> userRegister(User user) {
        //未加密密码
        String password = user.getPassword();
        //密码加密
        user.setPassword(AES.encryptToBase64(password, AesKey.AES_KEY));
        user.setLogoIconId(1);
        int i = userService.addUser(user);
        if(StringUtils.isNotEmpty(user.getMail())){
            mailSendService.voidSendMail(2,user.getMail(),
                    "You have registered your account in our xiaosai system. " +
                            "Please take good care of your account and password.Account number: "+
                            user.getUserName()+", password: "+password+"。[xiaosai]");
        }
        return ReturnMap.successResponse(StaticValues.LOGINSERVICE_REGISTER);
    }

    @Override
    public Map<String, Object> userLogin(User user, String captcha,HttpServletRequest request,
                                         HttpServletResponse response) {
        if(userService.userCountByUserName(user.getUserName())>0){
            //预存用户
            User user1 = userService.userByUserName(user.getUserName());
            if(AES.decryptFromBase64(user1.getPassword(),AesKey.AES_KEY).equals(user.getPassword())){
                //登录成功后将用户信息放入session中
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                //设置session有效性
                Map<String,Object> map = new HashMap<>();
                map.put("sesionId",session.getId());
                map.put("validity", System.currentTimeMillis());
                redisUtils.hmset(RedisKey.SESSION.getKey()+user1.getUserName(),map);

                return ReturnMap.successResponse(StaticValues.LOGINSERVICE_LOGIN_SUCCESS);
            }else {
                return ReturnMap.failureResponse(StaticValues.LOGINSERVICE_LOGIN_FAILED);
            }
        }else {
            return ReturnMap.failureResponse(StaticValues.LOGINSERVICE_USERNAME_ISINEXISTENCE);
        }
    }
}
