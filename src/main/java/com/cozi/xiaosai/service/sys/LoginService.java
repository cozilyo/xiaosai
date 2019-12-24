package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-11-24 14:42
 * @Version 1.0
 */

public interface LoginService {

    Map<String,Object> userRegister(User user);

    Map<String,Object> userLogin(User user, String captcha,HttpServletRequest request,
                                 HttpServletResponse response);
}
