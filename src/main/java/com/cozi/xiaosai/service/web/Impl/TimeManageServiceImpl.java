package com.cozi.xiaosai.service.web.Impl;

import com.cozi.xiaosai.common.R;
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
            return R.isFail().msg("姓名不能为空！");
        }
        if(StringUtils.isEmpty(timeManagePojo.getIncident())){
            return R.isFail().msg("事件不能为空！");
        }
        if(StringUtils.isEmpty(timeManagePojo.getAccomplishment())){
            return R.isFail().msg("完成量不能为空！");
        }
        timeManageMapper.insertTimeManage(timeManagePojo);
        return R.isOk().msg("时间管理添加成功");
    }

    @Override
    public R editTimeManageEcho(Integer id) {
        if(id.intValue()>0){
            return R.isOk().data(timeManageMapper.selectTimeManById(id));
        }
        return R.isFail().msg("未能找到数据！");
    }

    @Override
    public R editTimeManage(TimeManagePojo timeManagePojo) {
        timeManageMapper.updateTimeManage(timeManagePojo);
        return R.isOk().msg("时间管理编辑成功");
    }
}
