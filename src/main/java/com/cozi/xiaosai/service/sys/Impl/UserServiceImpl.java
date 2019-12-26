package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.controller.web.userControl.UserController;
import com.cozi.xiaosai.mapper.dataOrigin.sys.UserMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.UserService;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public int addUser(User user) {
        try {
            return userMapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void editUser(User user) {
        try {
            userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delUser(String userId) {
        try {
            userMapper.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int userCountByUserName(String userName) {
        return userMapper.userCountByUserName(userName);
    }

    @Override
    public User userByUserName(String userName) {
        return userMapper.userByUserName(userName);
    }

    @Override
    public Page<User> userListByUser(User user) {
        return userMapper.selectUserListByUser(user);
    }

    @Override
    public void batchDelUser(String userIds) {
        try {
            userMapper.delBatchUser(userIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
