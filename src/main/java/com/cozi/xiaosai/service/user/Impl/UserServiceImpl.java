package com.cozi.xiaosai.service.user.Impl;

import com.cozi.xiaosai.mapper.dataOrigin.user.UserMapper;
import com.cozi.xiaosai.mapper.dataOrigin1.user.User1Mapper;
import com.cozi.xiaosai.pojo.dataOrigin.user.User;
import com.cozi.xiaosai.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiaosai
 * @Date 2019-11-21 14:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    //主数据库
    @Autowired
    private UserMapper userMapper;

    //从数据库
    @Autowired
    private User1Mapper user1Mapper;

    @Override
    public User getUser(Integer id) {
        User user = userMapper.getUser(id);
        return user;
    }

    @Override
    public User getUser1(Integer id) {
        User user1 = user1Mapper.getUser1(id);
        return user1;
    }
}
