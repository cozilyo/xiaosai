package com.cozi.xiaosai.service.tool.Impl;

import com.cozi.xiaosai.domain.LogInfo;
import com.cozi.xiaosai.mapper.dataOrigin.tool.Log1oneMapper;
import com.cozi.xiaosai.service.tool.Log1oneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiaosai
 * @Date 2019-12-12 15:46
 * @Version 1.0
 */
@Service
public class Log1oneServiceImpl implements Log1oneService {

    @Autowired
    private Log1oneMapper log1oneMapper;
    @Override
    public void addLog(LogInfo logInfo) {
        log1oneMapper.insertLog(logInfo);
    }
}
