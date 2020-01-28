package com.altersoftware.hotel.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.constant.ConstantHolder;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.verification.VerificationCodeHolder;
import com.altersoftware.hotel.dao.UserDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.MessageIService;
import com.altersoftware.hotel.util.EnvUtil;
import com.altersoftware.hotel.warpper.MailWarpper;
import com.altersoftware.hotel.warpper.SmsWarpper;



@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("messageService")
public class MessageServiceImpl implements MessageIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    /** 邮件标题 */
    private final static String MAIL_TITLE = "【" + ConstantHolder.PRODUCT_NAME + " - 会员】邮箱验证码";
    /** 邮件验证码模板前缀 */
    private final static String MAIL_PREFIX = "您的验证码是";
    /** 邮件验证码模板后缀 */
    private final static String MAIL_SUBFIX = "。如非本人操作，请忽略本短信。";

    /** 短信验证码模板前缀 */
    private final static String SMS_PREFIX = "【哈沐信息技术】您的验证码是";
    /** 短信验证码模板后缀 */
    private final static String SMS_SUBFIX = "。如非本人操作，请忽略本短信。";

    @Resource
    private UserDAO userDAO;

    @Autowired
    MailWarpper mailWarpper;

    @Autowired
    SmsWarpper smsWarpper;

    @Autowired
    private EnvUtil envUtil;

    @Override
    public ResultDO<Void> sendVerificationCodeMail(String mail) {
        try {
            if (StringUtils.isBlank(mail)) {
                LOG.error("send mail fail, mail is null, mail={}", mail);
                return new ResultDO<>(false, ResultCode.NO_SUCH_MAIL, ResultCode.MSG_NO_SUCH_MAIL);
            }
            // 发邮件
            String verificationCode = VerificationCodeHolder.getMailVerificationCode(mail);
            mailWarpper.sendMail(mail, MAIL_TITLE, MAIL_PREFIX + verificationCode + MAIL_SUBFIX);
            LOG.info("send mail success, mail={}", mail);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("send mail error, mail={}", mail, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> sendVerificationCodeSms(String mobile) {
        try {
            if (StringUtils.isBlank(mobile)) {
                LOG.error("send sms fail, mobile is null, mobile={}", mobile);
                return new ResultDO<>(false, ResultCode.NO_SUCH_PHONE, ResultCode.MSG_NO_SUCH_PHONE);
            }
            // 发短信
            String verificationCode = VerificationCodeHolder.getPhoneVerificationCode(mobile);
            String content = SMS_PREFIX + verificationCode + SMS_SUBFIX;
            // 测试阶段关闭 TODO 上线时开启
            // if (envUtil.isOnline()) {
            boolean result = smsWarpper.sendSms(content, mobile);
            if (result == false) {
                LOG.error("send sms fail, sendSms fail, mobile={}", mobile);
                return new ResultDO<>(false, ResultCode.SEND_SMS_FAIL, ResultCode.MSG_SEND_SMS_FAIL);
            }
            // }
            LOG.info("send sms success, mobile={}, content={}", mobile, content);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("send sms error, mobile={}", mobile, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<String> sendSms(String mobile, String content) {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(content)) {
            LOG.error("send sms fail, parameter invalid, mobile={}, content={}", mobile, content);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            boolean result = smsWarpper.sendSms(content, mobile);
            if (result == false) {
                LOG.error("send sms fail, mobile={}, content={}", mobile, content);
                return new ResultDO<>(false, ResultCode.SEND_SMS_FAIL, ResultCode.MSG_SEND_SMS_FAIL);
            }
            LOG.info("send sms success, mobile={}, content={}", mobile, content);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("send sms error, mobile={}, sms={}", mobile, content, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
