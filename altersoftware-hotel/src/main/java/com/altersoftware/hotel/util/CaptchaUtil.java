package com.altersoftware.hotel.util;

import java.util.Random;

public class CaptchaUtil {

    /** 验证码长度 */
    private static final int VERIFICATION_CODE_LENGTH = 6;

    /**
     * 生成验证码
     *
     * @return captcha
     */
    public static String generateVerificationCode() {
        String captcha = "";
        Random random = new Random();// 随机数
        for (int i = 0; i < VERIFICATION_CODE_LENGTH; i++) {
            captcha += random.nextInt(10);
        }
        return captcha;
    }
}
