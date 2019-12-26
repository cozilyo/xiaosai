package com.cozi.xiaosai.mapper.dataOrigin.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:49
 * @Version 1.0
 */

public interface UserMapper {

    //查询user
    User selectUser(@Param(value = "userId") String userId);

    //添加user
    int insertUser(User user) throws Exception;

    //更新user
    void updateUser(User user) throws Exception;

    //删除user
    void deleteUser(@Param(value = "userId") String userId) throws Exception;

    //通过用户名查找
    int userCountByUserName(@Param(value = "userName")String userName);

    //通过用户名查找
    User userByUserName(@Param(value = "userName")String userName);

    //通过用户信息查找
    Page<User> selectUserListByUser(UserParams userParams);

    //通过userid批量删除用户
    void delBatchUser(@Param(value = "userIds") String userIds) throws Exception;
}
