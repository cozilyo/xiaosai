package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.pojo.dataOrigin.sys.User;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:50
 * @Version 1.0
 */

public interface UserService {
    //查询User
    User getUser(String userId);

    //添加user
    void addUser(User user);

    //更新user
    void editUser(User user);

    //删除user
    void delUser(String userId);
}