package com.altersoftware.hotel.service.impl;

import javax.annotation.Resource;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.UserDAO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.UserIService;
import com.altersoftware.hotel.util.SHA256Util;
import com.altersoftware.hotel.warpper.MailWarpper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@ComponentScan({"com.altersoftware.hotel.dao"})
@Service("userService")
/**
 * service接口实现
 *
 * @author 15272
 */
public class UserServiceImpl implements UserIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Resource
    private UserDAO userDAO;//用户

    @Autowired
    MailWarpper mailWarpper;//邮箱



      /*
           isBlank
           @param str 字符串
          @return 如果字符串为空或者长度为0，返回true，否则返回false
            */
    @Override
    public ResultDO<Void> signup(UserDO userDO) {

        // 0. 参数校验 //u=isBlank  空格也为true

        if (StringUtils.isBlank(userDO.getNumber()) || StringUtils.isBlank(userDO.getPassword())) {
            LOG.info("sign up fail, parameter invalid, userDO={}", userDO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 1. 插入数据库
            userDO.setPassword(SHA256Util.SHA256(userDO.getPassword()));
            userDAO.insert(userDO);
        } catch (Exception e) {
            LOG.error("sign up exception, userDO=" + userDO, e);
            return new ResultDO<>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
        }

        LOG.info("sign up success, userDO={}", userDO);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    @Override
    public ResultDO<Long> signin(UserDO userDO) {
        if (StringUtils.isBlank(userDO.getNumber()) || StringUtils.isBlank(userDO.getPassword())) {
            LOG.error("sign in fail, parameter illegal, userDO={}", userDO);
            return new ResultDO<Long>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            userDO.setPassword(SHA256Util.SHA256(userDO.getPassword()));
            UserDO userDOTemp = userDAO.getUserDOByNumberAndPassword(userDO.getNumber(), userDO.getPassword());
            if (userDOTemp == null) {
                LOG.error("sign in failed, userDO={}" + userDOTemp);
                return new ResultDO<Long>(false, ResultCode.INCORRECT_NUMBER_OR_PASSWORD,
                    ResultCode.MSG_INCORRECT_NUMBER_OR_PASSWORD, null);
            }
            LOG.info("sign in success, userDO={}", userDO);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDOTemp.getId());
        } catch (Exception e) {
            LOG.error("sign in fail, userDO={}", userDO, e);
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //更新密码
    @Override
    public ResultDO<Void> updatePassword(UserDO userDO, String oldPassword, String newPassword) {
        try {
            UserDO userDOTemp = userDAO.getUserDOByNumberAndPassword(userDO.getNumber(),
                SHA256Util.SHA256(oldPassword));
            //通过账户  旧密码查询用户
            if (userDOTemp == null) {
                // 老密码核验错误
                LOG.info("user oldPassword wrong, userDO={}, oldPassword={}, newPassword={}", userDO, oldPassword,
                    newPassword);
                return new ResultDO<>(false, ResultCode.PASSWORD_ERROR, ResultCode.MSG_PASSWORD_ERROR);
            }
            userDOTemp.setPassword(SHA256Util.SHA256(newPassword));
            userDAO.update(userDOTemp);
            LOG.info("update password success,userDO={}", userDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.info("updatePassword error,userDO={}", userDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过用户id获取用户
    @Override
    public ResultDO<UserDO> getUserDOById(long userId) {
        try {
            UserDO userDO = userDAO.getUserDOById(userId);
            if (userDO == null) {
                LOG.info("getUserDOById error,no such userDO,userId={}", userId);
                return new ResultDO<>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER, null);
            }
            LOG.info("getUserDOById success, userId={}", userId);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
            LOG.info("getUserDOById error,userId={}", userId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //通过邮箱查询用户
    @Override
    public ResultDO<UserDO> getUserDOByMail(String mail) {
        try {
            UserDO userDO = userDAO.getUserDOByMail(mail);
            if (userDO == null) {
                LOG.error("get userDO by mail fail, no such user, mail={}", mail);
                return new ResultDO<UserDO>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER, null);
            }
            LOG.info("get userDO by mail success,  mail={}", mail);
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
            LOG.error("get userDO by mail error", e);
            return new ResultDO<UserDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //通过手机找到userDO
    @Override
    public ResultDO<UserDO> getUserDOByPhone(String phone) {
        try {
            UserDO userDO = userDAO.getUserDOByPhone(phone);
            if (userDO == null) {
                LOG.info("get userDO by phone fail, no such user, phone={}", phone);
                return new ResultDO<UserDO>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            LOG.info("get userDO by phone success, phone={}", phone);
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
            LOG.error("get userDO by phone error", e);
            return new ResultDO<UserDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //通过 email修改密码
    @Override
    public ResultDO<Void> retrievePasswordByMail(String mail, String newPassword) {
        try {
            if (StringUtils.isBlank(mail) || StringUtils.isBlank(newPassword)) {
                LOG.error("parameter illegal, mail={}, newPassword={}", mail, newPassword);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            UserDO userDO = userDAO.getUserDOByMail(mail);
            if (userDO == null) {
                LOG.error("retrievePassWordByMail fail, no such userDO, mail={}, userDO={}", mail, userDO);
                return new ResultDO<>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            userDO.setPassword(SHA256Util.SHA256(newPassword));
            userDAO.update(userDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.info("retrieve password by mail error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //手机找密
    @Override
    public ResultDO<Void> retrievePasswordByPhone(String phone, String newPasssword) {
        try {
            if (StringUtils.isBlank(phone) || StringUtils.isBlank(newPasssword)) {
                LOG.error("parameter illegal, phone={}, newPassword={}", phone, newPasssword);
                return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            UserDO userDO = userDAO.getUserDOByPhone(phone);
            if (userDO == null) {
                LOG.error("retrievePassWordByPhone fail, no such userDO, phone={}, userDO={}", phone, userDO);
                return new ResultDO<>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            userDO.setPassword(SHA256Util.SHA256(newPasssword));
            userDAO.update(userDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.info("retrieve password by phone error", e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //修改邮箱
    @Override
    public ResultDO<Void> updateMail(UserDO userDO, String mail) {
        try {
            UserDO userDOTemp = userDAO.getUserDOById(userDO.getId());
            if (userDOTemp == null) {
                LOG.info("user wrong, userDO={}, Mail={}", userDO, mail);
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
            }
            userDOTemp.setMail(mail);
            userDAO.update(userDOTemp);
            LOG.info("update mail success,userDO={}, Mail={}", userDO, mail);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.info("update mail error,userDO={}, Mail={}", userDO, mail, e);

            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //修改手机
    @Override
    public ResultDO<Void> updateMobile(UserDO userDO, String mobile) {
        try {
            UserDO userDOTemp = userDAO.getUserDOById(userDO.getId());
            if (userDOTemp == null) {
                LOG.info("user wrong, userDO={}, mobile={}", userDO, mobile);
                return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
            }
            userDOTemp.setPhone(mobile);
            userDAO.update(userDOTemp);
            LOG.info("update mobile success, userDO={}, mobile={}", userDO, mobile);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.info("update mobile error, userDO={}, mobile={}", userDO, mobile, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    // 通过学号/工号找到userDO
    @Override
    public ResultDO<UserDO> getUserDOByNumber(String number) {
        try {
            UserDO userDO = userDAO.getUserDOByNumber(number);
            if (userDO == null) {
                LOG.error("get userDO by number fail, no such number, number={}", number);
                return new ResultDO<UserDO>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER, null);
            }
            LOG.info("get userDO by number success, number={}", number);
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
            LOG.error("get userDO by number error, number={}", number, e);
            return new ResultDO<UserDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //通过faceToken返回userDO
    @Override
    public ResultDO<UserDO> getUserDOByFaceToken(String faceToken) {
        if (StringUtils.isBlank(faceToken)) {
            LOG.error("get userDO by faceToken fail, parameter invalid, faceToken={}", faceToken);
            return new ResultDO<UserDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            UserDO userDO = userDAO.getUserDOByFaceToken(faceToken);
            LOG.info("get userDO by faceToken success, faceToken={}, userDO={}", faceToken, userDO);
            return new ResultDO<UserDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDO);
        } catch (Exception e) {
            LOG.error("get userDO by faceToken error, faceToken={}", faceToken, e);
            return new ResultDO<UserDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    // 更新userDO信息
    @Override
    public ResultDO<Void> updateUserDO(UserDO userDO) {
        if (userDO == null) {
            LOG.error("update userDO fail, parameter invalid, userDO={}", userDO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            userDAO.update(userDO);
            LOG.info("update userDO success, userDO={}", userDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("update userDO fail, userDO={}", userDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }




}
