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

    R getSidebarInfo();

    R getMenuInfo();

    MenuInfoPojo getmenuEditData(Integer id);

    R editMenuData(MenuInfoPojo menuInfoPojo);

    R addMenuData(MenuInfoPojo menuInfoPojo);
}
