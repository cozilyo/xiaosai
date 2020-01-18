package com.cozi.xiaosai.pojo.dataorigin.sys;

/**
 * @Author xiaosai
 * @Date 2019-11-21 13:18
 * @Version 1.0
 */

import com.cozi.xiaosai.common.PageModel;

/**
 * 用户信息
 */
public class User extends CaptchaPojo{
    private Integer id;
    private String userId;
    private Integer logoIconId;
    private Integer deptId;
    private String name;
    private String userName;
    private String password;
    private String passwords;
    private Integer age;
    private Integer gender;
    private String telephone;
    private String mail;
    private String idNum;
    private String address;
    private String remark;
    private String deptName;
    private String createTime;
    private String modifyTime;

    public User(){
    }

    public User(String name,Integer gender,String telephone){
        this.name=name;
        this.gender=gender;
        this.telephone=telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLogoIconId() {
        return logoIconId;
    }

    public void setLogoIconId(Integer logoIconId) {
        this.logoIconId = logoIconId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", passwords='" + passwords + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                ", mail='" + mail + '\'' +
                ", idNum='" + idNum + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
