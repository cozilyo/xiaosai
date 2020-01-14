package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.common.StaticValues;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.AppLoginService;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.util.aes.AES;
import com.cozi.xiaosai.util.aes.AesKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class AppLoginServiceImpl implements AppLoginService {

    @Autowired
    private UserService userService;

    @Override
    public R userLogin(User user, HttpServletRequest request) {
        if(StringUtils.isEmpty(user.getUserName())){
            return R.isFail().msg("用户名不能为空！");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return R.isFail().msg("密码不能为空！");
        }
        if(userService.userCountByUserName(user.getUserName())>0){
            //预存用户
            User user1 = userService.userByUserName(user.getUserName());
            if(AES.decryptFromBase64(user1.getPassword(),AesKey.AES_KEY).equals(user.getPassword())){
                //登录成功后将用户信息放入session中
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return R.isOk().msg(StaticValues.LOGINSERVICE_LOGIN_SUCCESS).data(user1);
            }else {
                return R.isFail().msg(StaticValues.LOGINSERVICE_LOGIN_FAILED);
            }
        }else {
            return R.isFail().msg(StaticValues.LOGINSERVICE_USERNAME_ISINEXISTENCE);
        }
    }
}
