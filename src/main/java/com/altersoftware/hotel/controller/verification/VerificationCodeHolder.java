package com.altersoftware.hotel.controller.verification;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.exception.HotelException;
import com.altersoftware.hotel.util.CaptchaUtil;


/**
 * 邮箱和手机验证码托管
 *
 * @author 15272
 */
public class VerificationCodeHolder {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    /** 邮箱验证码的map */
    private static final Map<String, String> MAIL_VERIFICATION_CODE_MAP = new HashMap<>();
    /** 手机验证码的map */
    private static final Map<String, String> PHONE_VERIFICATION_CODE_MAP = new HashMap<>();
    /** 验证码失效时间5分钟，单位为秒 */
    private static final int SURVIVE_TIME = 5 * 60;

    /** 失效验证码线程池 */
    private static final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());

    /**
     * 添加邮箱及验证码
     *
     * @param mail
     * @param verificationCode
     */
    public static final String getMailVerificationCode(String mail) {
        if (StringUtils.isEmpty(mail)) {
            LOG.error("mail is empty, mail={}", mail);
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        // 生成验证码
        String verificationCode = CaptchaUtil.generateVerificationCode();
        MAIL_VERIFICATION_CODE_MAP.put(mail, verificationCode);

        // 验证码失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                VerificationCodeHolder.deleteMailVerificationCodeByMail(mail);
                LOG.info("mail verification code has been deleted, mail={}", mail);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);

        return verificationCode;
    }

    /**
     * 添加手机及验证码
     *
     * @param phone
     * @param phone
     */
    public static final String getPhoneVerificationCode(String phone) {
        if (StringUtils.isEmpty(phone)) {
            LOG.error("phone is empty, phone={}", phone);
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        // 生成验证码
        String verificationCode = CaptchaUtil.generateVerificationCode();
        PHONE_VERIFICATION_CODE_MAP.put(phone, verificationCode);

        // 验证码失效
        executorService.schedule(new Runnable() {

            @Override
            public void run() {
                VerificationCodeHolder.deleteMailVerificationCodeByMail(phone);
                LOG.info("mobile verification code has been deleted, mail={}", phone);
            }
        }, SURVIVE_TIME, TimeUnit.SECONDS);

        return verificationCode;
    }

    /**
     * 删除邮箱及验证码
     *
     * @param mail
     */
    public static final void deleteMailVerificationCodeByMail(String mail) {
        if (StringUtils.isEmpty(mail)) {
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (MAIL_VERIFICATION_CODE_MAP.containsKey(mail) == false) {
            return;
        }
        MAIL_VERIFICATION_CODE_MAP.remove(mail);
    }

    /**
     * 删除手机及验证码
     *
     * @param phone
     */
    public static final void deletePhoneVerificationCodeByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (PHONE_VERIFICATION_CODE_MAP.containsKey(phone) == false) {
            return;
        }
        PHONE_VERIFICATION_CODE_MAP.remove(phone);
    }

    /**
     * 核验邮箱验证码
     *
     * @param mail
     * @param verificationCode
     * @return
     */
    public static final boolean checkMailVerificationCode(String mail, String verificationCode) {
        if (StringUtils.isEmpty(mail) || StringUtils.isEmpty(verificationCode)) {
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return StringUtils.equals(MAIL_VERIFICATION_CODE_MAP.get(mail), verificationCode);
    }

    /**
     * 核验手机验证码
     *
     * @param phone
     * @param verificationCode
     * @return
     */
    public static final boolean checkPhoneVerificationCode(String phone, String verificationCode) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(verificationCode)) {
            throw new HotelException(ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return StringUtils.equals(PHONE_VERIFICATION_CODE_MAP.get(phone), verificationCode);
    }

}
