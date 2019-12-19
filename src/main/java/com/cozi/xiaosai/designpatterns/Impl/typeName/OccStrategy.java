package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:44
 * @Version 1.0
 */

public class OccStrategy implements Strategy {
    @Override
    public String execute() {
        return "职业健康及危害因素监测";
    }
}
