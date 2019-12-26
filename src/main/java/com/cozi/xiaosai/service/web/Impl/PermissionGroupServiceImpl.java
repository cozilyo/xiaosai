package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.mapper.dataOrigin.web.PermissionGroupMapper;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.service.web.PermissionGroupService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

@Service
public class PermissionGroupServiceImpl implements PermissionGroupService {

    @Autowired
    private PermissionGroupMapper permissionGroupMapper;

    @Override
    public Page<PermissionGroupPojo> getPermissionGroup(PermissionGroupPojo permissionGroupPojo) {
        return permissionGroupMapper.selectPermissionGroupByInfo(permissionGroupPojo);
    }
}
