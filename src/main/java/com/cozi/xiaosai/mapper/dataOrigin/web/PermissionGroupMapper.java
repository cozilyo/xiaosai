package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.github.pagehelper.Page;

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
     * @param permissionGroupPojo 权限组信息
     * @return 权限组集合
     */
    Page<PermissionGroupPojo> selectPermissionGroupByInfo(PermissionGroupPojo permissionGroupPojo);
}
