package com.cozi.xiaosai.service.tool;

import com.cozi.xiaosai.domain.EmailInfoDomain;

/**
 * @Author xiaosai
 * @Date 2019-11-24 14:45
 * @Version 1.0
 */

/**
 * 邮箱处理逻辑类
 */
public interface MailSendService {

    EmailInfoDomain getMailConfig(Integer id);

    void voidSendMail(Integer id,String mailAddr,String content);

    boolean sendMail(Integer id,String mailAddr,String content);
}
