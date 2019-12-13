package com.cozi.xiaosai.common;

public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS("成功"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("未知错误"),
    
    /**
     * 参数格式不正确
     */
    PARAM_FORMAT_ERROR("参数格式不正确"),

    /**
     * 用户名错误或不存在
     */
    USERNAME_ERROR("用户名错误或不存在"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR("密码错误"),

    /**
     * 用户名不能为空
     */
    USERNAME_EMPTY("用户名不能为空"),

    /**
     * 无效学校
     */
    INVALID_SCHOOL("无效学校"),


    /**
     * 年级不可修改
     */
    GRADE_FINAL("年级不可修改"),

    /**
     * 班级不可修改
     */
    CLAZZ_FINAL("班级不可修改"),

    /**
     * 班级不可修改
     */
    SCHOOL_YEAR_FINAL("班级不可修改"),


    /**
     * 该班级下还存在学生无法删除
     */
    CLAZZ_EXISTS_STU("该班级下还存在学生无法删除"),


    /**
     * 改学校编码已被使用
     */
    SCHOOL_CODE_EXISTS("该学校编码已被使用"),


    /**
     * "未找到上传的文件"
     */
    FILE_ISEMPTY("未找到上传的文件"),

    /**
     * "未找到上传的文件"
     */
    FALSENESS_ISEMPTY("请上传正确的文件"),

    /**
     * "身份证号码错误"
     */
    IDNUM_ERROR("身份证号码错误"),

    /**
     * "身份证号码已存在"
     */
    IDNUM_EXIS("身份证号码已存在"),

    /**
     * "已存在本年度/季度数据"
     */
    EXIST_QUARTER_DATA("已存在本年度/季度数据"),


    NO_DATE_TO_IMPORT("没有可以导入的数据"),

    IMPORT_ERROR("导入出错!"),

    NOT_NULL_PARAM("请求参数不能为空"),

    /**
     * "未找到token"
     */
    TOKEN_NOT_FOUND("未找到token"),

    /**
     * "错误的token"
     */
    TOKEN_ERROR("错误的token"),

    /**
     * "token超时"
     */
    TOKEN_OVER_TIME("token超时"),


    NONENTITY_USER("用户不存在"),

    NOT_REGISTER("注册号不能为空"),

    EXIST_VALUE("数据已存在"),

    DATA_REPEAT("请不要导入重复数据");
    /**
     * 结果码描述
     */
    private String message;


    ResultEnum(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}

