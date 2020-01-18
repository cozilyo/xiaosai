package com.cozi.xiaosai.pojo.dataorigin.web;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class DeptManagePojo {


    /**
     * 节点标题
     */
    private String title;

    /**
     * 节点唯一索引值，用于对指定节点进行各类操作
     */
    private Integer id;

    private Integer deptParentId;

    /**
     * 节点字段名
     */
    private String field;

    /**
     * 子节点。支持设定选项同父节点
     */
    private List<DeptManagePojo> children;

    /**
     * 点击节点弹出新窗口对应的 url。需开启 isJump 参数
     */
    private String href;

    /**
     * 节点是否初始展开，默认 false
     */
    private boolean spread=false;

    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private boolean checked=false;

    /**
     * 节点是否为禁用状态。默认 false
     */
    private boolean disabled=false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<DeptManagePojo> getChildren() {
        return children;
    }

    public void setChildren(List<DeptManagePojo> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "DeptManagePojo{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", deptParentId=" + deptParentId +
                ", field='" + field + '\'' +
                ", children=" + children +
                ", href='" + href + '\'' +
                ", spread=" + spread +
                ", checked=" + checked +
                ", disabled=" + disabled +
                '}';
    }
}
