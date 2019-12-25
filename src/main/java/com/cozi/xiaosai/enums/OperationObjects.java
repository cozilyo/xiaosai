package com.cozi.xiaosai.enums;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum OperationObjects {
    UNKNOWN("unknown"),
    XIAOSAI_USER("xiaosai_user"),
    XIAOSAI_PERMISSION_GROUP("xiaosai_permission_group"),
    XIAOSAI_MAIL_CONFIG("xiaosai_mail_config"),
    XIAOSAI_LOG("xiaosai_log");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationObjects(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OperationObjects{" +
                "value='" + value + '\'' +
                '}';
    }
}
