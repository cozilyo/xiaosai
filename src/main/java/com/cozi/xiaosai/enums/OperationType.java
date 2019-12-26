package com.cozi.xiaosai.enums;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum OperationType {
    /**
     * 操作类型
     */
    UNKNOWN("unknown"),
    INSERT("insert"),
    DELETE("delete"),
    UPDATE("update"),
    SELECT("select"),
    AUDIT("audit"),
    BATHCHAUDIT("bathchaudit"),
    IMPORT("import"),
    EXPORT("export");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}
