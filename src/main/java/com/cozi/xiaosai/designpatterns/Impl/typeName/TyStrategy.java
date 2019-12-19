package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:41
 * @Version 1.0
 */

public class TyStrategy implements Strategy {
    @Override
    public String execute() {
        return "平台通用设置";
    }
}
