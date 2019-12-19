package com.cozi.xiaosai.designpatterns.Impl.typeName;

import com.cozi.xiaosai.designpatterns.Strategy;

/**
 * @Author xiaosai
 * @Date 2019-12-19 11:50
 * @Version 1.0
 */

public class ExeStrategy {

    private Strategy strategy;

    public ExeStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public String executeStrategy(){
        return strategy.execute();
    }
}
