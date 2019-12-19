package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:43
 * @Version 1.0
 */

public class CrbStrategy implements Strategy {
    @Override
    public String execute() {
        return "传染病监测";
    }
}
