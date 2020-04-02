package com.cozi.xiaosai.util;

import com.cozi.xiaosai.enums.TypeEnum;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2020-3-28 16:16
 * @describe
 * @className
 */

public class SwitchUtils {

    public static String return_string(TypeEnum type) {
        switch (type) {
            case UNKNOWN :
                return "unknown";
            case BALL:
                return "ball";
            default:
                return "hand";
        }
    }

    public static void main(String[] args) {
        //System.out.println(return_string(TypeEnum.BALL));
        /*String str = "1S2S3";
        String[] s = str.split("S");
        System.out.println(GsonUtil.gsonString(s));*/

        String str = "2";
        String[] s = {str,str,str,str};
        String[] s1 = new String[4];

        System.out.println(GsonUtil.gsonString(s));
    }
}
