package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.controller.web.userControl.UserController;
import com.cozi.xiaosai.pojo.dataorigin.sys.MenuInfoPojo;
import com.cozi.xiaosai.service.sys.DistributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 页面布局
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class DistributionController {

    private final Logger logger = LoggerFactory.getLogger(DistributionController.class);

    @Autowired
    private DistributionService distributionService;

    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public String getMenuHTML(){

        return "sys/XSmenu";
    }

    @RequestMapping(value = "/menuEdit",method = RequestMethod.GET)
    public String getMenuEditHtml(@RequestParam(value = "id") Integer id, Model model){
        logger.info("id:"+id);
        model.addAttribute("id",id);
        return "sys/XSmenuEdit";
    }

    /**
     * 获取侧边栏信息
     * @return
     */
    @RequestMapping("/bar")
    @ResponseBody
    public R getSidebarInfo(){
        return distributionService.getSidebarInfo();
    }

    /**
     * 获取菜单信息
     * @return
     */
    @RequestMapping("/menuInfo")
    @ResponseBody
    public R getMenuInfo(){
        return distributionService.getMenuInfo();
    }


    /**
     * 菜单数据回显
     * @param id
     * @return
     */
    @RequestMapping(value = "/menuEditDataEcho",method = RequestMethod.POST)
    @ResponseBody
    public R getmenuEditData(@RequestParam(value = "id") Integer id){
        logger.info("id:"+id);
        return R.isOk().data(distributionService.getmenuEditData(id));
    }

    /**
     * 菜单管理编辑
     * @param menuInfoPojo
     * @return
     */
    @RequestMapping(value = "/editMenuData",method = RequestMethod.POST)
    @ResponseBody
    public R editMenuData(@RequestBody MenuInfoPojo menuInfoPojo){
        logger.info("菜单管理编辑："+menuInfoPojo);
        return distributionService.editMenuData(menuInfoPojo);
    }

}
