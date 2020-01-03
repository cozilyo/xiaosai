package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.R;
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

    /**
     * 菜单管理列表页
     * @return
     */
    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public String getMenuHTML(){

        return "sys/XSmenu";
    }

    /**
     * 菜单编辑页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/menuEdit",method = RequestMethod.GET)
    public String getMenuEditHtml(@RequestParam(value = "id") Integer id, Model model){
        logger.info("id:"+id);
        model.addAttribute("id",id);
        return "sys/XSmenuEdit";
    }

    /**
     * 菜单管理添加页
     * @return
     */
    @RequestMapping(value = "/menuAdd",method = RequestMethod.GET)
    public String getMenuAddHtml(){
        return "sys/XSmenuAdd";
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

    /**
     * 菜单管理添加
     * @param menuInfoPojo
     * @return
     */
    @RequestMapping(value = "/addMenuData",method = RequestMethod.POST)
    @ResponseBody
    public R addMenuData(@RequestBody MenuInfoPojo menuInfoPojo){
        logger.info("菜单管理添加："+menuInfoPojo);
        return distributionService.addMenuData(menuInfoPojo);
    }

    /**
     * 获取导航栏信息
     * @return
     */
    @RequestMapping(value = "/navBarInfo",method = RequestMethod.POST)
    @ResponseBody
    public R getNavBarInfo(){
        return distributionService.getNavBarInfo();
    }

    /**
     * 删除导航栏或侧边栏信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delBarInfo",method = RequestMethod.POST)
    @ResponseBody
    public R delBarInfo(@RequestParam(value = "id") Integer id){
        return distributionService.delBarInfo(id);
    }

}
