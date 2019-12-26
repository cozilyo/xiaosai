package com.cozi.xiaosai.service.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 用户管理类
 * @author xiaosai
 * @date 2019-11-24 15:50
 * @version 1.0
 */

public interface UserService {

    /**
     * 查询User
     * @param userId 用户id
     * @return 用户信息
     */
    User getUser(String userId);

    /**
     * 添加user
     * @param user 用户信息
     * @return 影响的条数
     */
    int addUser(User user);

    /**
     * 更新user
     * @param user 用户信息
     */
    void editUser(User user);

    /**
     * 删除user
     * @param userId 用户id
     */
    void delUser(String userId);

    /**
     * 通过用户名查找
     * @param userName 用户名
     * @return 有多少条
     */
    int userCountByUserName(String userName);

    /**
     * 通过用户名查找
     * @param userName 用户名
     * @return 用户信息
     */
    User userByUserName(String userName);

    /**
     *通过用户信息查找
     * @param user 用户信息
     * @return 用户list
     */
    Page<User> userListByUser(User user);

    /**
     * 通过userid批量删除用户
     * @param userIds userid以‘，’隔开
     */
    void batchDelUser(String userIds);
}
