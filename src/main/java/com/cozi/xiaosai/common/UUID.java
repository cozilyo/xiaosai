package com.cozi.xiaosai.common;

/**
 * @Author xiaosai
 * @Date 2019-12-4 11:48
 * @Version 1.0
 */

public class UUID {

    private static String uuid="abcdefghijklmnop";

    public static String getUuid(){
        uuid = java.util.UUID.randomUUID().toString().replace("-","").toLowerCase();
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getUuid());
    }

}
