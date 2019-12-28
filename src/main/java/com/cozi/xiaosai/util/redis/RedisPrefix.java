package com.cozi.xiaosai.util.redis;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public enum RedisPrefix {
    //侧边栏缓存
    BAR("XSBAR_7c2g56UYp6M15LDX17MEMlpI43H67D9z"),
    MENU("XSMENU_b8mrDx6vTzOwrb8D8SC2r492w4GfQyj8");

    private String prefix;

    RedisPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "RedisPrefix{" +
                "prefix='" + prefix + '\'' +
                '}';
    }
}
