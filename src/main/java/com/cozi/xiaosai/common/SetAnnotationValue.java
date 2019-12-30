package com.cozi.xiaosai.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 设置注解值
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class SetAnnotationValue {

    /**
     *
     * @param annotation 修改的注解
     * @param property 属性
     * @param value 值
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void setAnnotationValue(Annotation annotation, String property, Object value) throws NoSuchFieldException, IllegalAccessException {
        InvocationHandler handler = Proxy.getInvocationHandler(annotation);
        Field hField = handler.getClass().getDeclaredField("memberValues");
        hField.setAccessible(true);
        Map memberValues = (Map) hField.get(handler);
        memberValues.put(property, value);
    }
}
