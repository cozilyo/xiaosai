package com.cozi.xiaosai.domain;

import java.util.Date;

/**
 * @Author xiaosai
 * @Date 2019-12-12 11:46
 * @Version 1.0
 */

public class LogInfo {
    private int id;
    private String operator;
    private String operationModule;
    private String operationType;
    private String operands;
    private String operationTime;
    private String ip;
    private String operationContent;
    private String createTime;
    private String modifyTime;

    public LogInfo(){
    }

    public LogInfo(int id,String operator,String operationModule,
                   String operationType,String operands,String operationTime,String ip,String operationContent){
        this.id = id;
        this.operator = operator;
        this.operationModule = operationModule;
        this.operationType = operationType;
        this.operands = operands;
        this.operationTime = operationTime;
        this.ip = ip;
        this.operationContent = operationContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationModule() {
        return operationModule;
    }

    public void setOperationModule(String operationModule) {
        this.operationModule = operationModule;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperands() {
        return operands;
    }

    public void setOperands(String operands) {
        this.operands = operands;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", operationModule='" + operationModule + '\'' +
                ", operationType='" + operationType + '\'' +
                ", operands='" + operands + '\'' +
                ", operationTime='" + operationTime + '\'' +
                ", ip='" + ip + '\'' +
                ", operationContent='" + operationContent + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
