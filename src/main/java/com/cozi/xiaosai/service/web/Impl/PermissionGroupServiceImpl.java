package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.mapper.dataOrigin.web.PermissionGroupMapper;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupPojoParams;
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
    public Page<PermissionGroupPojo> getPermissionGroup(PermissionGroupPojoParams permissionGroupPojoParams) {
        return permissionGroupMapper.selectPermissionGroupByInfo(permissionGroupPojoParams);
    }

    @Override
    public R addPermissionGroup(PermissionGroupPojoParams permissionGroupPojoParams) {
        if(permissionGroupMapper.selectPermissionGroupBygroupName(permissionGroupPojoParams.getGroupName())>0){
            return R.isFail().msg("权限组添加失败，名称不能重复！");
        }
        if(permissionGroupMapper.selectPermissionGroupBygroupType(permissionGroupPojoParams.getGroupType())>0){
            return R.isFail().msg("权限组添加失败，代号不能重复！");
        }

        permissionGroupMapper.insertPermissionGroup(permissionGroupPojoParams);
        return R.isOk().msg("权限组添加成功");
    }
}
