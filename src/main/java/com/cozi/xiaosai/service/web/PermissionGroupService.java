package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupParams;
import com.github.pagehelper.Page;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface PermissionGroupService {
    /**
     * 通过权限组信息查找
     * @param permissionGroupParams 权限组信息
     * @return 权限组集合
     */
    Page<PermissionGroupPojo> getPermissionGroup(PermissionGroupParams permissionGroupParams);

    /**
     * 权限组添加
     * @param permissionGroupParams
     * @return
     */
    R addPermissionGroup(PermissionGroupParams permissionGroupParams);


    /**
     * 权限组编辑回显
     * @param id
     * @return
     */
    PermissionGroupPojo editPermissionGroupEcho(Integer id);

    /**
     * 权限组编辑
     * @param permissionGroupParams
     * @return
     */
    R editPermissionGroup(PermissionGroupParams permissionGroupParams);
}
