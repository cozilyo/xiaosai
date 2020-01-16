package com.cozi.xiaosai.pojo.dataorigin.webParams;

import com.cozi.xiaosai.common.PageModel;

/**
 * @Author xiaosai
 * @Date 2019-12-12 11:46
 * @Version 1.0
 */

public class LogmanageParams extends PageModel {
    private Integer id;
//    操作者
    private String operator;
//    操作模块
    private Integer operationModule;
//    操作类型
    private String operationType;
//    操作对象
    private String operands;
//    操作时间
    private String operationTime;
//    操作ip
    private String ip;
//    操作内容
    private String operationContent;
//    开始时间
    private String startTime;
//    结束时间
    private String endTime;

    private String createTime;
    private String modifyTime;

    public LogmanageParams(){
    }

    /**
     *
     * @param id
     * @param operationModule 操作模块
     * @param operationType 操作类型
     * @param operands 对象
     */
    public LogmanageParams(Integer id, Integer operationModule,
                           String operationType, String operands, String operationContent){
        this.id = id;
        this.operationModule = operationModule;
        this.operationType = operationType;
        this.operands = operands;
        this.operationContent = operationContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
