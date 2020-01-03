package com.cozi.xiaosai.mapper.dataOrigin.web;

import com.cozi.xiaosai.pojo.dataorigin.web.TimeManagePojo;

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
    List<TimeManagePojo> selectTimeManage();
}
