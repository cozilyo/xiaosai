package com.cozi.xiaosai.controller.web;

import com.cozi.xiaosai.controller.web.userControl.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(BlogController.class);

    /**
     * blog主页
     * @return
     */
    @RequestMapping("/mainPage")
    public String getMainPageFtl(){
        return "web/blog/mainPage";
    }
}
