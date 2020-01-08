package com.cozi.xiaosai.pojo.dataorigin.sysParams;

/**
 * 用户信息修改
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class UserEditParams {

    private Integer id;
    private String userName;
    private String telephone;
    private String mail;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserEditParams{" +
                "userName='" + userName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mail='" + mail + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
