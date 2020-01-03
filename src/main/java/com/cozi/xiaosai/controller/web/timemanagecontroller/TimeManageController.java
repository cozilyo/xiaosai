package com.cozi.xiaosai.controller.web.timemanagecontroller;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.service.web.TimeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private TimeManageService timeManageService;

    /**
     * 时间管理列表页
     * @return
     */
    @RequestMapping("/timeList")
    public String getTimeListHtml(){
        return "web/timemanage/timeList";
    }

    /**
     * 时间管理添加页
     * @return
     */
    @RequestMapping("/timeManageAdd")
    public String getTimeManageAdd(){
        return "web/timemanage/timeManageAdd";
    }

    @RequestMapping(value = "/timeListData",method = RequestMethod.POST)
    @ResponseBody
    public R getTimeList(){
        return timeManageService.getTimeList();
    }
}
