package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupPojoParams;
import com.github.pagehelper.Page;

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
     * @param permissionGroupPojoParams 权限组信息
     * @return 权限组集合
     */
    Page<PermissionGroupPojo> getPermissionGroup(PermissionGroupPojoParams permissionGroupPojoParams);

    /**
     * 权限组添加
     * @param permissionGroupPojoParams
     */
    R addPermissionGroup(PermissionGroupPojoParams permissionGroupPojoParams);
}
