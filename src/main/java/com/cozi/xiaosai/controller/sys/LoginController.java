package com.cozi.xiaosai.controller.sys;

/**
 * @Author xiaosai
 * @Date 2019-11-21 17:24
 * @Version 1.0
 */

import com.cozi.xiaosai.common.ReturnMap;
import com.cozi.xiaosai.pojo.dataOrigin.user.User;
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

    @RequestMapping("/register")
    public Map<String,Object> userRegister(User user, HttpServletRequest request,
                                           HttpServletResponse response){
        return ReturnMap.successResponse("注册成功");
    }

}
