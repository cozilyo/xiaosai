package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.TimeManagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.TimeManageParams;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface TimeManageMapper {
    /**
     * 查找时间管理列表
     * @return
     */
    Page<TimeManagePojo> selectTimeManage(TimeManageParams timeManageParams);

    /**
     * 添加时间管理
     * @param timeManagePojo
     */
    void insertTimeManage(TimeManagePojo timeManagePojo);

    TimeManagePojo selectTimeManById(@Param(value = "id") Integer id);

    void updateTimeManage(TimeManagePojo timeManagePojo);
}
