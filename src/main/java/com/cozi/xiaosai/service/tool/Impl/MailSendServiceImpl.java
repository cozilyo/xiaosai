package com.cozi.xiaosai.service.tool.Impl;

import com.cozi.xiaosai.domain.EmailInfoDomain;
import com.cozi.xiaosai.mapper.dataOrigin.tool.MailSendMapper;
import com.cozi.xiaosai.service.tool.MailSendService;
import com.cozi.xiaosai.util.EmailSendTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Author xiaosai
 * @Date 2019-11-24 14:46
 * @Version 1.0
 */

/**
 * 邮件配置处理类
 */
@Service
public class MailSendServiceImpl implements MailSendService {


    @Autowired
    private MailSendMapper mailSendMapper;

    @Override
    public EmailInfoDomain getMailConfig(Integer id) {
        EmailInfoDomain emailInfoDomain = mailSendMapper.selectMailConfig(id);
        return emailInfoDomain;
    }

    /**
     * 邮件发送
     * @param id 邮件配置id
     * @param mailAddr 待发送地址
     * @param content 待发送内容
     * @return
     */
    @Override
    public boolean sendMail(Integer id,String mailAddr,String content) {
        EmailInfoDomain emailInfoDomain = mailSendMapper.selectMailConfig(id);
        if(emailInfoDomain!=null){
            try {
                emailInfoDomain.setEmailAddress(mailAddr);
                emailInfoDomain.setDescribes(content);
                EmailSendTool.sendTenxungEmail(emailInfoDomain);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
