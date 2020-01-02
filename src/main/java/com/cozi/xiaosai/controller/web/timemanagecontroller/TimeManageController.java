package com.cozi.xiaosai.controller.web.timemanagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 时间管理
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class TimeManageController {

    @RequestMapping("/timeList")
    public String getTimeListHtml(){
        return "web/timemanage/timeList";
    }
}
