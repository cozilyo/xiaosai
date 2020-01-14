package com.cozi.xiaosai.pojo.dataorigin.sys;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LoginTokenPojo {
    private Integer id;
    private String uuid;
    private Integer userId;
    private Integer state;
    private String loginTime;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LoginTokenPojo{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", userId=" + userId +
                ", state=" + state +
                ", loginTime='" + loginTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
