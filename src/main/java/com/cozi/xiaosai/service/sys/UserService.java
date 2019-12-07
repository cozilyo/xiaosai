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
    int addUser(User user);

    //更新user
    void editUser(User user);

    //删除user
    void delUser(String userId);

    //通过用户名查找
    int userCountByUserName(String userName);

    //通过用户名查找
    User userByUserName(String userName);
}
