package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.mapper.dataOrigin.web.TimeManageMapper;
import com.cozi.xiaosai.pojo.dataorigin.web.TimeManagePojo;
import com.cozi.xiaosai.service.web.TimeManageService;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public R addTimeManage(TimeManagePojo timeManagePojo) {
        if(StringUtils.isEmpty(timeManagePojo.getName())){
            return R.isFail().msg(CueWordsEnum.TIME_MANAGE_FAILED_NAME.getValue());
        }
        if(StringUtils.isEmpty(timeManagePojo.getIncident())){
            return R.isFail().msg(CueWordsEnum.TIME_MANAGE_FAILED_INCIDENT.getValue());
        }
        if(StringUtils.isEmpty(timeManagePojo.getAccomplishment())){
            return R.isFail().msg(CueWordsEnum.TIME_MANAGE_FAILED_ACCOMPLISHMENT.getValue());
        }
        timeManageMapper.insertTimeManage(timeManagePojo);
        return R.isOk().msg(CueWordsEnum.TIME_MANAGE_SUCCESS_ADD.getValue());
    }

    @Override
    public R editTimeManageEcho(Integer id) {
        if(id.intValue()>0){
            return R.isOk().data(timeManageMapper.selectTimeManById(id));
        }
        return R.isFail().msg(CueWordsEnum.TIME_MANAGE_FAILED_ERROR.getValue());
    }

    @Override
    public R editTimeManage(TimeManagePojo timeManagePojo) {
        timeManageMapper.updateTimeManage(timeManagePojo);
        return R.isOk().msg(CueWordsEnum.TIME_MANAGE_SUCCESS_EDIT.getValue());
    }
}
