package com.cozi.xiaosai.common;

/**
 * @Author xiaosai
 * @Date 2019-11-21 18:30
 * @Version 1.0
 */

public class GlobalReturnCode {

    public final static String return_code = "return_code";//状态码

    public final static String return_msg = "return_msg";//状态描述



    //枚举
    public enum  codeMsgEnum{
        SUCCESS(1, "操作成功!"),
        FAILURE(0, "操作失败!");

        private Integer code;
        private String msg;

        codeMsgEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
