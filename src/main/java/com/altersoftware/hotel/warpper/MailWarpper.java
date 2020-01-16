package com.altersoftware.hotel.warpper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 邮箱接口
 *
 * @author wenyuan.ww
 */
@Component
public class MailWarpper {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    /** 发送方邮件地址 */
    private static final String FROM_MAIL = "2980253435@qq.com";

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送文本邮件
     *
     * @param toMail
     * @param subject
     * @param text
     */
    public void sendMail(String toMail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_MAIL);
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(text);

        try {
            mailSender.send(message);
            LOG.info("mail has been sent, message={}", message);
        } catch (Exception e) {
            LOG.error("sendMail exception, toMail=" + toMail + ", subject=" + subject + ", text=" + text
                + ", exception=", e);
        }
    }
}
