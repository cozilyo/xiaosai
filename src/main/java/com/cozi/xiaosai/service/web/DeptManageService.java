package com.cozi.xiaosai.service.web;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public interface DeptManageService {

    /**
     * 部门信息树结构
     * @return
     */
    R getDeptManageData();

    /**
     *
     * @param userParams
     * @return
     */
    R getDeptToUser(UserParams userParams);
}
