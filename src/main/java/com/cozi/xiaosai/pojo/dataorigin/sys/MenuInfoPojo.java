package com.cozi.xiaosai.pojo.dataorigin.sys;

import java.util.List;

/**
 * 菜单信息
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class MenuInfoPojo {
    private Integer id;
    private Integer authorityId;
    private  String title;
    private  String href;
    private String icon;
    private String target;
    private Integer parentId;
    private Integer navId;
    private List<SidebarPojo> child;
    private String navigationBarName;
    private Integer navigationBarIndex;
    private Integer check = 0;
    private Integer isMenu;
    private String createTime;
    private String modifyTime;

    public MenuInfoPojo() {
    }

    public MenuInfoPojo(String navigationBarName) {
        this.navigationBarName = navigationBarName;
    }

    public MenuInfoPojo(Integer navId, String navigationBarName) {
        if(navId!=null){
            this.navId = navId;
        }else {
            this.navId = 0;
        }

        this.navigationBarName = navigationBarName;
    }

    public MenuInfoPojo(Integer navigationBarIndex) {
        this.navigationBarIndex = navigationBarIndex;
    }

    public MenuInfoPojo(String title, Integer parentId) {
        this.title = title;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public List<SidebarPojo> getChild() {
        return child;
    }

    public void setChild(List<SidebarPojo> child) {
        this.child = child;
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

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
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
        return "MenuInfoPojo{" +
                "id=" + id +
                ", authorityId=" + authorityId +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", icon='" + icon + '\'' +
                ", target='" + target + '\'' +
                ", parentId=" + parentId +
                ", navId=" + navId +
                ", child=" + child +
                ", navigationBarName='" + navigationBarName + '\'' +
                ", navigationBarIndex=" + navigationBarIndex +
                ", check=" + check +
                ", isMenu=" + isMenu +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
