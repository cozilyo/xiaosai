package com.cozi.xiaosai.util.redis;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum RedisKey {
    BAR("bar_8027eed5"),
    MENU("menu_a276e535");

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    RedisKey(String key) {
        this.key = key;
    }
}
