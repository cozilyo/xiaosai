package com.cozi.xiaosai.common;

import java.io.Serializable;

/**
 * @ Author     ：pengzhaofeng
 * @ Date       ：Created in 16:24 2018/12/27 0027
 * @ Description：返回结果封装类
 * @ Modified By：
 * @Version: 1.0
 **/
public class R<T> implements Serializable {
    private static final long serialVersionUID = -4577255781088498763L;
    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final int UNAUTHORIZED = 2;

    private T data; //服务端数据
    private int status; //状态码

    private String error = ""; //描述信息

    private String msg = "";

    //APIS
    public static R isOk() {
        return new R().status(OK);
    }

    public static R isFail() {
        return new R().status(FAIL);
    }

    public static R isFail(Throwable e) {
        return isFail().error(e);
    }

    public static R isFail(int error, ResultEnum r) {
        R result = isFail().error(r.getMessage());
        result.setStatus(error);
        return result;
    }

    public R error(Throwable e) {
        this.setError(e.getMessage());
        return this;
    }

    public R error(String errorMessage) {
        this.setError(errorMessage);
        return this;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public R status(int status) {
        this.setStatus(status);
        return this;
    }

    public R msg(String msg){
        this.setMsg(msg);
        return this;
    }


    //Constructors
    public R() {

    }

    //Getter&Setters

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    /*@Override
    public String toString() {
        String s = "";
        try {
            s = new ObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return
                "{\"data\":" + s + ", \"status\":" + status + ", \"error\":\"" + error + "\"}";
    }*/
}
