package com.cozi.xiaosai.mapper.dataOrigin.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.MenuInfoPojo;
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

    List<MenuInfoPojo> selectMenuInfoList();

    /**
     * 通过id查出边栏信息
     * @param id
     * @return
     */
    MenuInfoPojo selectmenuEditData(@Param(value = "id") Integer id);

    /**
     * 更新边栏信息
     * @param menuInfoPojo
     */
    void updatemenuinfo(MenuInfoPojo menuInfoPojo);

    /**
     * type为1，查导航栏记录表。为2，查侧边栏记录表 is为2，id为不等。 is为1，id为等
     * @param menuInfoPojo
     * @param type
     * @param is
     * @return
     */
    int selectCountByMenuInfoPojo(@Param(value = "mi") MenuInfoPojo menuInfoPojo,@Param(value = "type") Integer type,@Param(value = "is") Integer is);

    int insertNavigationBar(MenuInfoPojo menuInfoPojo);

    void insertSidebar(MenuInfoPojo menuInfoPojo);

    int selectMixIndex();

    void deleteBar(@Param(value = "navId") Integer navId);

    void deleteBarByidAndnavid(@Param(value = "ids") String ids);


}
