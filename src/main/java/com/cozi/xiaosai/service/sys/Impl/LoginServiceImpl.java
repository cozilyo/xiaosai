package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import com.cozi.xiaosai.service.sys.LoginService;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.service.tool.MailSendService;
import com.cozi.xiaosai.util.aes.AES;
import com.cozi.xiaosai.util.aes.AesKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Map<String, Object> userRegister(User user) {
        //未加密密码
        String password = user.getPassword();
        //密码加密
        user.setPassword(AES.encryptToBase64(password, AesKey.AES_KEY));
        userService.addUser(user);
        mailSendService.voidSendMail(2,user.getMail(),
                "You have registered your account in our xiaosai system. " +
                        "Please take good care of your account and password.Account number: "+user.getUserName()+", password: "+password+"。[xiaosai]");
        return ReturnMap.successResponse(StaticValues.LOGINSERVICE_REGISTER);
    }
}
