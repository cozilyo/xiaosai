package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupParams;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

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
     * @param permissionGroupParams 权限组信息
     * @return 权限组集合
     */
    Page<PermissionGroupPojo> selectPermissionGroupByInfo(PermissionGroupParams permissionGroupParams);

    /**
     * 添加权限组
     * @param permissionGroupParams
     */
    void insertPermissionGroup(PermissionGroupParams permissionGroupParams);

    /**
     * 通过权限组名称查找，存在多少条数据
     * @param groupName
     * @param id 如果没有id,则为0或者“”
     * @return
     */
    int selectPermissionGroupBygroupName(@Param(value = "groupName") String groupName,@Param(value = "id") int id);

    /**
     * 通过权限组代号查找，存在多少条数据
     * @param groupType
     * @param id 如果没有id,则为0或者“”
     * @return
     */
    int selectPermissionGroupBygroupType(@Param(value = "groupType") Integer groupType,@Param(value = "id") int id);

    /**
     * 通过id查找权限组信息
     * @param id
     * @return
     */
    PermissionGroupPojo selectPermissionGroupById(@Param(value = "id") Integer id);

    /**
     * 权限组编辑
     * @param permissionGroupParams
     * @exception
     */
    void updatePermissionGroup(PermissionGroupParams permissionGroupParams) throws Exception;
}
