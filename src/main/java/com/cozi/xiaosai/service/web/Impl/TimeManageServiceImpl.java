package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.mapper.dataOrigin.web.TimeManageMapper;
import com.cozi.xiaosai.service.web.TimeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class TimeManageServiceImpl implements TimeManageService {

    @Autowired
    private TimeManageMapper timeManageMapper;

    @Override
    public R getTimeList() {
        return R.isOk().data(timeManageMapper.selectTimeManage());
    }
}
