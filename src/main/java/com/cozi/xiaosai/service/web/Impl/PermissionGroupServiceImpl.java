package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.mapper.dataOrigin.web.PermissionGroupMapper;
import com.cozi.xiaosai.pojo.dataorigin.web.PermissionGroupPojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.PermissionGroupParams;
import com.cozi.xiaosai.service.web.PermissionGroupService;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page<PermissionGroupPojo> getPermissionGroup(PermissionGroupParams permissionGroupParams) {
        return permissionGroupMapper.selectPermissionGroupByInfo(permissionGroupParams);
    }

    @Override
    public R addPermissionGroup(PermissionGroupParams permissionGroupParams) {
        if(StringUtils.isEmpty(permissionGroupParams.getGroupName())||permissionGroupMapper.selectPermissionGroupBygroupName(permissionGroupParams.getGroupName(),0)>0){
            return R.isFail().msg(CueWordsEnum.PGROUP_FAILED_ADD_NAME.getValue());
        }
        if(permissionGroupParams.getGroupType().intValue()<=0||permissionGroupMapper.selectPermissionGroupBygroupType(permissionGroupParams.getGroupType(),0)>0){
            return R.isFail().msg(CueWordsEnum.PGROUP_FAILED_ADD_TYPE.getValue());
        }

        permissionGroupMapper.insertPermissionGroup(permissionGroupParams);
        return R.isOk().msg(CueWordsEnum.PGROUP_SUCCESS_ADD.getValue());
    }

    @Override
    public PermissionGroupPojo editPermissionGroupEcho(Integer id) {
        return permissionGroupMapper.selectPermissionGroupById(id);
    }

    @Override
    public R editPermissionGroup(PermissionGroupParams permissionGroupParams) {
        if(StringUtils.isEmpty(permissionGroupParams.getGroupName())
                ||permissionGroupMapper.selectPermissionGroupBygroupName(permissionGroupParams.getGroupName(), permissionGroupParams.getId())>0){
            return R.isFail().msg(CueWordsEnum.PGROUP_FAILED_EDIT_NAME.getValue());
        }
        if(permissionGroupParams.getGroupType().intValue()<=0||permissionGroupMapper.selectPermissionGroupBygroupType(permissionGroupParams.getGroupType(), permissionGroupParams.getId())>0){
            return R.isFail().msg(CueWordsEnum.PGROUP_FAILED_EDIT_TYPE.getValue());
        }
        try {
            permissionGroupMapper.updatePermissionGroup(permissionGroupParams);
            return R.isOk().msg(CueWordsEnum.PGROUP_SUCCESS_EDTI.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return R.isFail().msg(CueWordsEnum.PGROUP_FAILED_EDIT.getValue());
        }
    }
}
