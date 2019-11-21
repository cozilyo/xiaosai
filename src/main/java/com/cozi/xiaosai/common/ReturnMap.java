package com.cozi.xiaosai.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xiaosai
 * @Date 2019-11-21 18:23
 * @Version 1.0
 */

/**
 * 返回结果设置为统一格式
 */
public class ReturnMap {
    //这里的线程安全是指使用自身的函数
    public static Map<String,Object> dataMap = new ConcurrentHashMap<String,Object>();

    /**
     * 成功
     * 默认返回结果
     * @return Map<String,Object>
     */
    public static Map<String,Object> successResponse(){
        dataMap.put(GlobalReturnCode.return_code,GlobalReturnCode.codeMsgEnum.SUCCESS.getCode());
        dataMap.put(GlobalReturnCode.return_msg,GlobalReturnCode.codeMsgEnum.SUCCESS.getMsg());
        return dataMap;
    }

    /**
     * 成功
     * 返回结果
     * @param msg 状态描述
     * @return Map<String,Object>
     */
    public static Map<String,Object> successResponse(String msg){
        dataMap.put(GlobalReturnCode.return_code,GlobalReturnCode.codeMsgEnum.SUCCESS.getCode());
        dataMap.put(GlobalReturnCode.return_msg,msg);
        return dataMap;
    }

    /**
     * 成功
     * 返回结果
     * @param code 状态码
     * @param msg 状态描述
     * @return Map<String,Object>
     */
    public static Map<String,Object> successResponse(Integer code,String msg){
        dataMap.put(GlobalReturnCode.return_code,code);
        dataMap.put(GlobalReturnCode.return_msg,msg);
        return dataMap;
    }

    /**
     * 失败
     * 默认返回结果
     * @return Map<String,Object>
     */
    public static Map<String,Object> failureResponse(){
        dataMap.put(GlobalReturnCode.return_code,GlobalReturnCode.codeMsgEnum.FAILURE.getCode());
        dataMap.put(GlobalReturnCode.return_msg,GlobalReturnCode.codeMsgEnum.FAILURE.getMsg());
        return dataMap;
    }

    /**
     * 失败
     * 返回结果
     * @param msg 状态描述
     * @return Map<String,Object>
     */
    public static Map<String,Object> failureResponse(String msg){
        dataMap.put(GlobalReturnCode.return_code,GlobalReturnCode.codeMsgEnum.FAILURE.getCode());
        dataMap.put(GlobalReturnCode.return_msg,msg);
        return dataMap;
    }

    /**
     * 失败
     * 返回结果
     * @param code 状态码
     * @param msg 状态描述
     * @return Map<String,Object>
     */
    public static Map<String,Object> failureResponse(Integer code,String msg){
        dataMap.put(GlobalReturnCode.return_code,code);
        dataMap.put(GlobalReturnCode.return_msg,msg);
        return dataMap;
    }

}
