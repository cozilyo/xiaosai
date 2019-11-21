package com.cozi.xiaosai.mapper.dataOrigin.user;

import com.cozi.xiaosai.pojo.dataOrigin.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiaosai
 * @Date 2019-11-21 14:34
 * @Version 1.0
 */

public interface UserMapper {
    User getUser(@Param(value = "id") Integer id);
}
