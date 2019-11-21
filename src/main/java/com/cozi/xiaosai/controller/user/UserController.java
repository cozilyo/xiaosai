package com.cozi.xiaosai.controller.user;

import com.cozi.xiaosai.pojo.dataOrigin.user.User;
import com.cozi.xiaosai.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author xiaosai
 * @Date 2019-11-21 14:24
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取主数据库用户信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/userData")
    public String getUserData(@RequestParam(value = "id") Integer id,
                              HttpServletRequest request, HttpServletResponse response){
        User user = userService.getUser(id);
        return user.toString();
    }

    /**
     * 获取从数据库用户信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/userData1")
    public String getUserData1(@RequestParam(value = "id") Integer id,
                              HttpServletRequest request, HttpServletResponse response){
        User user = userService.getUser1(id);
        return user.toString();
    }

}
