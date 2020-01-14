package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface AppLoginService  {
    /**
     * app登录认证
     * @param user
     * @param request
     * @return
     */
    R userLogin(User user, HttpServletRequest request);
}
