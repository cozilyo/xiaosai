package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupPojoParams;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限组持久层
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface PermissionGroupMapper {
    /**
     * 通过权限组信息查找
     * @param permissionGroupPojoParams 权限组信息
     * @return 权限组集合
     */
    Page<PermissionGroupPojo> selectPermissionGroupByInfo(PermissionGroupPojoParams permissionGroupPojoParams);

    /**
     * 添加权限组
     * @param permissionGroupPojoParams
     */
    void insertPermissionGroup(PermissionGroupPojoParams permissionGroupPojoParams);

    /**
     * 通过权限组名称查找，存在多少条数据
     * @param groupName
     * @return
     */
    int selectPermissionGroupBygroupName(@Param(value = "groupName") String groupName);

    /**
     * 通过权限组代号查找，存在多少条数据
     * @param groupType
     * @return
     */
    int selectPermissionGroupBygroupType(@Param(value = "groupType") Integer groupType);
}
