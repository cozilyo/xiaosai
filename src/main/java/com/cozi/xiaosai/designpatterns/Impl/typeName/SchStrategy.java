package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:45
 * @Version 1.0
 */

public class SchStrategy implements Strategy {
    @Override
    public String execute() {
        return "学校卫生监测";
    }
}
