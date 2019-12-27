package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.mapper.dataOrigin.sys.DistributionMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.NavigationBarPojo;
import com.cozi.xiaosai.pojo.dataorigin.sys.SidebarPojo;
import com.cozi.xiaosai.service.sys.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    private DistributionMapper distributionMapper;

    @Override
    public R getSidebarInfo() {
        List<NavigationBarPojo> navigationBarPojos = distributionMapper.selectNavigationBar();
        Map<String, Object> sideBar = new HashMap<>();
        for (int i = 0; i < navigationBarPojos.size(); i++) {
            List<SidebarPojo> sidebarPojo = barConstruction(0, navigationBarPojos.get(i).getId());
            sideBar.put(navigationBarPojos.get(i).getNavigationBarName(), sidebarPojo);
        }
        return R.isOk().data(sideBar);
    }
    /**
     * 构造侧边栏信息
     *
     * @param parentId
     * @param navId
     * @return
     */
    public List<SidebarPojo> barConstruction(Integer parentId, Integer navId) {
        List<SidebarPojo> sidebarPojos = distributionMapper.selectSidebar(parentId, navId);
            if (sidebarPojos.size() > 0) {
                for (SidebarPojo sidebarPojo1 : sidebarPojos) {
                    List<SidebarPojo> sidebarPojos1 = barConstruction(sidebarPojo1.getId(), navId);
                    sidebarPojo1.setChild(sidebarPojos1);
                }
            }
        return sidebarPojos;
    }
}
