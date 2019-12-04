package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.ReturnMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author xiaosai
 * @Date 2019-11-21 20:30
 * @Version 1.0
 */

/**
 * 认证平台
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * 邮箱验证码认证
     * @param userId 用户id
     * @param authCode 认证码
     * @return
     */
    @RequestMapping(value = "/mail",method = RequestMethod.POST)
    public Map<String,Object> mailAuth(@RequestParam(value = "userId") String userId, @RequestParam(value = "authCode")String authCode){
        if("123456".equals(authCode)&& StringUtils.isNotEmpty(userId)){
            return ReturnMap.successResponse("认证成功!");
        }else {
            return ReturnMap.failureResponse("认证失败!");
        }
    }

    @RequestMapping("/ma")
    public String getString(){
        return "sss";
    }

}
