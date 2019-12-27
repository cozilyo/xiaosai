package com.cozi.xiaosai.pojo.dataorigin.sys;

import java.lang.ref.PhantomReference;

/**
 * 导航栏信息
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class NavigationBarPojo {
    private Integer id;
    private String navigationBarName;
    private Integer navigationBarIndex;
    private String createTime;
    private String modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNavigationBarName() {
        return navigationBarName;
    }

    public void setNavigationBarName(String navigationBarName) {
        this.navigationBarName = navigationBarName;
    }

    public Integer getNavigationBarIndex() {
        return navigationBarIndex;
    }

    public void setNavigationBarIndex(Integer navigationBarIndex) {
        this.navigationBarIndex = navigationBarIndex;
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
        return "NavigationBarPojo{" +
                "id=" + id +
                ", navigationBarName='" + navigationBarName + '\'' +
                ", navigationBarIndex=" + navigationBarIndex +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
