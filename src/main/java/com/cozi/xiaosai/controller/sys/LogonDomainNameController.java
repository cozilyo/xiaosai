package com.cozi.xiaosai.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xiaosai
 * @Date 2019-12-23 15:14
 * @Version 1.0
 * @Description:
 */
@Controller
public class LogonDomainNameController {

    /**
     *可通过域名加端口访问
     * @return
     */

    @RequestMapping("/")
    public String getLogin(){
        return "sys/XSlogin";
    }
}
