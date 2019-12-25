package com.cozi.xiaosai.enums;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum OperationUnit {
    UNKNOWN("unknown"),
    PCS("平台通用设置"),
    MOID("传染病监测"),
    TS("结核病监测"),
    OHHM("职业健康及危害因素监测"),
    SHM("学校卫生监测");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationUnit(String value) {
        this.value = value;
    }
}
