package com.cozi.xiaosai.controller.web.timemanagecontroller;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.controller.sys.LoginController;
import com.cozi.xiaosai.pojo.dataorigin.web.TimeManagePojo;
import com.cozi.xiaosai.service.web.TimeManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private final Logger logger = LoggerFactory.getLogger(TimeManageController.class);

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

    /**
     * 时间管理编辑页
     * @return
     */
    @RequestMapping("/timeManageEdit")
    public String getTimeManageEdit(@RequestParam Integer id, Model model){
        model.addAttribute("id",id);
        logger.info("编辑页参数："+id);
        return "web/timemanage/timeManageEdit";
    }

    /**
     * 获取时间管理列表数据
     * @return
     */
    @RequestMapping(value = "/timeListData",method = RequestMethod.POST)
    @ResponseBody
    public R getTimeList(){
        return timeManageService.getTimeList();
    }

    /**
     * 添加时间管理
     * @param timeManagePojo
     * @return
     */
    @RequestMapping(value = "/addTimeManage",method = RequestMethod.POST)
    @ResponseBody
    public R addTimeManage(@RequestBody TimeManagePojo timeManagePojo){
        return timeManageService.addTimeManage(timeManagePojo);
    }

    /**
     * 时间管理编辑回显
     * @param id
     * @return
     */
    @RequestMapping(value = "/editTimeManageEcho",method = RequestMethod.POST)
    @ResponseBody
    public R editTimeManageEcho(@RequestParam(value = "id") Integer id){
        return timeManageService.editTimeManageEcho(id);
    }

    /**
     * 时间管理编辑
     * @param timeManagePojo
     * @return
     */
    @RequestMapping(value = "/editTimeManage",method = RequestMethod.POST)
    @ResponseBody
    public R editTimeManage(@RequestBody TimeManagePojo timeManagePojo){
        return timeManageService.editTimeManage(timeManagePojo);
    }

}
