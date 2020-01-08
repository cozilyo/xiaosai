package com.cozi.xiaosai.mapper.dataOrigin.sys;

import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserEditParams;
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

    /**
     * 查询user
     * @param userId
     * @return
     */
    User selectUser(@Param(value = "userId") String userId);

    /**
     * 添加user
     * @param user
     * @return
     * @throws Exception
     */
    int insertUser(User user) throws Exception;

    /**
     * 更新user
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     *通过UserEditParams为参数修改
     * @throws Exception
     */
    void updateUserByUP(UserEditParams userEditParams)throws Exception;

    /**
     * 修改密码
     * @param user
     * @throws Exception
     */
    void updatePassword(User user)throws Exception;

    /**
     * 删除user
     * @param userId
     * @throws Exception
     */
    void deleteUser(@Param(value = "userId") String userId) throws Exception;

    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    int userCountByUserName(@Param(value = "userName")String userName);

    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    User userByUserName(@Param(value = "userName")String userName);

    /**
     * 通过用户信息查找
     * @param userParams
     * @return
     */
    Page<User> selectUserListByUser(UserParams userParams);

    /**
     * 通过userid批量删除用户
     * @param userIds
     * @throws Exception
     */
    void delBatchUser(@Param(value = "userIds") String userIds) throws Exception;
}
