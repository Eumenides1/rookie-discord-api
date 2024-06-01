package com.rookie.stack.discord.users.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author eumenides
 * @description
 * @date 2024/6/1
 */
public interface MailService {

    // 发送普通邮件
    void sendSimpleMailMessage(String to, String subject, String content);

    // 发送html邮件
    void sendMimeMessage(String to, String subject, String content) throws MessagingException;

    // 发送带附件的邮件
    void sendMimeMessage(String to, String subject, String content, String filePath) throws MessagingException;


    // 发送带静态文件的邮件
    void sendMimeMessage(String to, String subject, String content, Map<String,String> rscIdMap) throws MessagingException;




}
