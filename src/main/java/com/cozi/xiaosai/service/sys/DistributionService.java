package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sys.MenuInfoPojo;
import org.springframework.data.relational.core.sql.In;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */


public interface DistributionService {

    /**
     * 获取导航栏信息
     * @return
     */
    R getNavBarInfo();

    /**
     * 获取侧边栏信息
     * @return
     */
    R getSidebarInfo();

    /**
     * 获取菜单管理信息
     * @return
     */
    R getMenuInfo();

    /**
     * 通过id获取菜单管理信息
     * @param id
     * @return
     */
    MenuInfoPojo getmenuEditData(Integer id);

    R editMenuData(MenuInfoPojo menuInfoPojo);

    R addMenuData(MenuInfoPojo menuInfoPojo);
}
