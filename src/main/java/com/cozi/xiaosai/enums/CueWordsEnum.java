package com.cozi.xiaosai.enums;

/**
 * 网站所有静态变量值
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum  CueWordsEnum {

    UN(1,"不明白！"),

    LOGIN_VERIFY(2,"登入验证码"),
    LOGIN_SUCCESS(3,"登录成功"),

    LOGIN_FAILED_PASSWORD_ERROR(4,"密码不正确，请重新登录！"),
    LOGIN_FAILED_VERIFY_ERROR(5,"验证码不正确或失效！"),

    USER_FAILED_ID(6,"id无效！"),
    USER_FAILED__USERNAME(7,"用户名不能为空!"),

    BASICS_INFO_SUCCESS(8,"基本资料编辑成功"),
    BASICS_INFO_FAILED(9,"基本资料编辑失败！"),

    //logoIcon默认值
    LOGO_ICON_DEFAULT_TITLE(10,"小噻科技"),
    LOGO_ICON_DEFAULT_IMAGE(11,"../layuimini/images/personal-01.png"),
    LOGO_ICON_DEFAULT_HREF(12,"/xiaosai/index"),
    LOGO_ICON_FAILED_POJO(13,"数据获取失败！"),
    LOGO_ICON_FAILED_USERNAME(14,"用户名不能为空，修改失败！"),
    LOGO_ICON_SUCCESS(15,"设置成功"),
    LOGO_ICON_FAILED(16,"设置失败！"),

    //菜单管理
    MENU_MANAGE_EDIT_SUCCESS(17,"菜单管理编辑成功"),
    MENU_MANAGE_NAV_NAVID(18,"导航id无效或与导航标识不一致！"),
    MENU_MANAGE_SIDEBAR_TITLE(19,"侧边栏名称不能为空或同级重复!"),
    MENU_MANAGE_SUCCESS_DELETE(20,"删除成功"),
    MENU_MANAGE_FAILED_ID(21,"id不存在"),
    MENU_MANAGE_UNVALID_ID(22,"id无效"),

    //密码修改
    USER_FAILED_INEXISTENCE(23,"用户不存在！"),
    USER_FAILED_OLDANDNEW_PASSWORD(24,"新旧密码不允许为空！"),
    USER_SUCCESS_EDIT_PASSWORD(25,"密码修改成功，请重新登录"),
    USER_FAILED_EDIT_PASSWORD(26,"密码修改失败！"),
    USER_FAILED_OLD_PASSWORD(27,"旧密码错误，请重新输入!"),

    //权限组管理
    PGROUP_FAILED_ADD_NAME(28,"权限组添加失败，名称不能为空或重复！"),
    PGROUP_FAILED_ADD_TYPE(29,"权限组添加失败，代号不能为空或重复！"),
    PGROUP_SUCCESS_ADD(30,"权限组添加成功"),
    PGROUP_FAILED_EDIT_NAME(31,"权限组编辑失败，名称不能为空或重复！"),
    PGROUP_FAILED_EDIT_TYPE(32,"权限组编辑失败，代号不能为空或重复！"),
    PGROUP_SUCCESS_EDTI(33,"权限组编辑成功"),
    PGROUP_FAILED_EDIT(34,"权限组编辑失败！"),

    //时间管理
    TIME_MANAGE_FAILED_NAME(35,"姓名不能为空！"),
    TIME_MANAGE_FAILED_INCIDENT(36,"事件不能为空！"),
    TIME_MANAGE_FAILED_ACCOMPLISHMENT(37,"完成量不能为空！"),
    TIME_MANAGE_SUCCESS_ADD(38,"时间管理添加成功"),
    TIME_MANAGE_FAILED_ERROR(39,"未能找到数据！"),
    TIME_MANAGE_SUCCESS_EDIT(40,"时间管理编辑成功"),

    //拦截器
    INTERCEPTOR_APP_URL_CONTROLLER(41,"/xiaosai/app"),
    INTERCEPTOR_LOGIN_FORWARD_URL(42,"/xiaosai/login"),
    INTERCEPTOR_SESSION_ATTR_KEY(43,"user"),

    //日志管理
    LOG_MANAGE_LOGIN_IN(44,"登入系统"),
    LOG_MANAGE_LOGIN_OUT(45,"登出系统")
    ;

    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    CueWordsEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
}
