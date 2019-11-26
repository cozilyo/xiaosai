package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.mapper.dataOrigin.sys.UserMapper;
import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import com.cozi.xiaosai.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:50
 * @Version 1.0
 */

/**
 * 用户逻辑类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void editUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void delUser(String userId) {
        userMapper.deleteUser(userId);
    }
}
