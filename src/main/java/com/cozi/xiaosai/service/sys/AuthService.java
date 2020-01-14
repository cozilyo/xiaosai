package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.common.R;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface AuthService {
    R bindUserIdAndToken(String token,Integer userId,Integer projId);
}
