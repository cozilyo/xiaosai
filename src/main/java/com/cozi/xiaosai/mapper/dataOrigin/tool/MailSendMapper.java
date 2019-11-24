package com.cozi.xiaosai.mapper.dataOrigin.tool;

import com.cozi.xiaosai.domain.EmailInfoDomain;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xiaosai
 * @Date 2019-11-24 14:50
 * @Version 1.0
 */

public interface MailSendMapper {
    EmailInfoDomain selectMailConfig(@Param(value = "id") Integer id);
}
