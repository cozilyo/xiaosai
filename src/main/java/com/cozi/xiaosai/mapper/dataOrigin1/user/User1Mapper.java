package com.cozi.xiaosai.mapper.dataOrigin1.user;

import com.cozi.xiaosai.pojo.dataOrigin.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiaosai
 * @Date 2019-11-21 14:34
 * @Version 1.0
 */

public interface User1Mapper {
    User getUser1(@Param(value = "id") Integer id);
}
