package com.cozi.xiaosai.pojo.dataorigin.web;

import com.cozi.xiaosai.common.PageModel;

/**
 * 权限管理组
 * @author xiaosai
 * @date 2019-12-24 15:43
 * @version 1.0
 * @describe
 */

public class PermissionGroupPojo extends PageModel {
    private Integer id;
    private String groupName;
    private Integer groupType;
    private Integer accessLevel;
    private String createTime;
    private String modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "PermissionGroupPojo{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupType=" + groupType +
                ", accessLevel=" + accessLevel +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
