package com.cozi.xiaosai.pojo.dataorigin.sys;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class CaptchaPojo {
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public String toString() {
        return "CaptchaPojo{" +
                "captcha='" + captcha + '\'' +
                '}';
    }
}
