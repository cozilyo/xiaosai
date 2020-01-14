package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

@Controller
@RequestMapping("/xiaosai/app")
public class AppLoginController {

    @Autowired
    private AppLoginService appLoginService;

    /**
     * app登陆
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    @ResponseBody
    public R userLogin(@RequestBody User user, HttpServletRequest request,
                       HttpServletResponse response){
        return appLoginService.userLogin(user,request);
    }
}
