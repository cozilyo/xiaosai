package com.cozi.xiaosai.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class LogManageExcel {

    @Excel(name = "操作人",orderNum = "0")
    private String operator;

    @Excel(name = "操作模块",orderNum = "1")
    private Integer operationModule;

    @Excel(name = "操作类型",orderNum = "2")
    private String operationType;

    @Excel(name = "操作对象",orderNum = "3")
    private String operands;

    @Excel(name = "操作时间",orderNum = "4")
    private String operationTime;

    @Excel(name = "ip",orderNum = "5")
    private String ip;

    @Excel(name = "操作内容",orderNum = "6")
    private String operationContent;

    //@Excel(name = "创建时间",orderNum = "7")
    private String createTime;

    //@Excel(name = "修改时间",orderNum = "8")
    private String modifyTime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getOperationModule() {
        return operationModule;
    }

    public void setOperationModule(Integer operationModule) {
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
        return "LogManageExcel{" +
                "operator='" + operator + '\'' +
                ", operationModule=" + operationModule +
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
