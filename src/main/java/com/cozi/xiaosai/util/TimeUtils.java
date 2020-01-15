package com.cozi.xiaosai.util;

import java.util.Date;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class TimeUtils {
    /**
     *获取精确到秒的时间戳
     * @param date
     * @return
     */
    public static int getSecondTimestampTwo(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    public static void main(String[] args) {
        //1579079668089
        //1579079687417
        System.out.println(System.currentTimeMillis());
    }
}
