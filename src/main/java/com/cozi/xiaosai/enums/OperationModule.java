package com.cozi.xiaosai.enums;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum OperationModule {

    //平台通用设置
    TONGYONGPINGTAI(1),
    //传染病监测
    CHUANRANBING(2),
    //结核病监测
    JIEHEBING(3),
    //职业健康及危害因素监测
    ZHIYEJIANKANG(4),
    //学校卫生监测
    XUEXIAOWEISHENG(5);

    private Integer module;

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    OperationModule(Integer module) {
        this.module = module;
    }
}
