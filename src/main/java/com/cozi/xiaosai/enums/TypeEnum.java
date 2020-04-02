package com.cozi.xiaosai.enums;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2020-3-28 16:42
 * @describe
 * @className
 */

public enum  TypeEnum {
    UNKNOWN("unknown"),
    BALL("ball"),
    HAND("hand");
    private String val;

   TypeEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
