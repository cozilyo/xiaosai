package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:46
 * @Version 1.0
 */

public class JhbStrategy implements Strategy {
    @Override
    public String execute() {
        return "结核病监测";
    }
}
