package com.cozi.xiaosai.mapper.dataOrigin.sys;

import com.cozi.xiaosai.pojo.dataOrigin.sys.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:49
 * @Version 1.0
 */

public interface UserMapper {

    //查询user
    User selectUser(@Param(value = "userId") String userId);

    //添加user
    void insertUser(User user);

    //更新user
    void updateUser(User user);

    //删除user
    void deleteUser(@Param(value = "userId") String userId);

    //通过用户名查找
    int userCountByUserName(@Param(value = "userName")String userName);

    //通过用户名查找
    User userByUserName(@Param(value = "userName")String userName);
}
