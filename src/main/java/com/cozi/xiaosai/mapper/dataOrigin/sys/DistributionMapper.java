package com.cozi.xiaosai.mapper.dataOrigin.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.NavigationBarPojo;
import com.cozi.xiaosai.pojo.dataorigin.sys.SidebarPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface DistributionMapper {

    List<NavigationBarPojo> selectNavigationBar();

    List<SidebarPojo> selectSidebar(@Param(value = "parentId") Integer parentId,@Param(value = "navId") Integer navId);
}
