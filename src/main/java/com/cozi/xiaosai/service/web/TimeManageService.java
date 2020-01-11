package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.web.TimeManagePojo;
import com.cozi.xiaosai.pojo.dataorigin.webParams.TimeManageParams;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface TimeManageService {

    R getTimeList(TimeManageParams timeManageParams);

    R addTimeManage(TimeManagePojo timeManagePojo);

    R editTimeManageEcho(Integer id);

    R editTimeManage(TimeManagePojo timeManagePojo);
}
