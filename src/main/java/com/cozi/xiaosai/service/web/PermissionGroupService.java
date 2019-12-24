package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface PermissionGroupService {
    /**
     * 通过权限组信息查找
     * @param permissionGroupPojo 权限组信息
     * @return 权限组集合
     */
    List<PermissionGroupPojo> getPermissionGroup(PermissionGroupPojo permissionGroupPojo);
}
