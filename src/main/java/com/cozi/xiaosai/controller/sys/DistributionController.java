package com.cozi.xiaosai.controller.sys;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.service.sys.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private DistributionService distributionService;

    /**
     * 获取侧边栏信息
     * @return
     */
    @RequestMapping("/bar")
    @ResponseBody
    public R getSidebarInfo(){
        return distributionService.getSidebarInfo();
    }

}
