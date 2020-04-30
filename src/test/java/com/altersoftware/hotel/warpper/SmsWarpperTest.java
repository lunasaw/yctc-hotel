package com.altersoftware.hotel.warpper;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Iszychen@win10
 * @date 2020/2/5 14:48
 */
public class SmsWarpperTest {

    @Resource
    private SmsWarpper  smsWarpper;

    @Autowired
    private MailWarpper mailWrapper;

    // 由于此单测跑一遍发一个邮件，暂时注释掉
    // @Test
    public void sendTestEmai() {
        mailWrapper.sendMail("15696756582@163.com", "title", "沙雕");
    }

    // @Test
    public void sendTest() throws IOException {
        smsWarpper.sendSms("短信接口测试", "15696758582");
    }
}
