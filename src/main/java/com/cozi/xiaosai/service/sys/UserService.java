package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.pojo.dataOrigin.sys.User;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:50
 * @Version 1.0
 */

public interface UserService {
    User getUser(String userId);

    void addUser(User user);
}
