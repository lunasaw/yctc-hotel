package com.altersoftware.hotel.controller.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.ErrorText;
import com.altersoftware.hotel.constant.StaticPath;
import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.UserController;
import com.altersoftware.hotel.controller.session.SessionContentHolder;
import com.altersoftware.hotel.controller.verification.VerificationCodeHolder;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.PermissionIService;
import com.altersoftware.hotel.service.UserIService;
import com.altersoftware.hotel.vo.*;

@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/user")
/**
 * userController接口实现
 *
 * @author 15272
 */
public class UserControllerImpl implements UserController {

    private final static Logger LOG = LoggerFactory.getLogger("controllerLogger");

    @Resource
    private UserIService        userService;

    @Autowired
    private PermissionIService  permissionService;

    @Override
    @PostMapping("signup")
    @Deprecated
    public String signup(@ModelAttribute UserDO userDO) {
        ResultDO<Void> resultDO = userService.signup(userDO);
        if (resultDO.isSuccess() == false) {
            LOG.error("sign up fail, userDO={}" + userDO);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        LOG.info("sign up success, userDO={}" + userDO);
        // 赋权
        ResultDO<Void> initPermissionResultDO = permissionService.initPermissionUserDOsByUserDO(userDO.getId());
        if (resultDO.isSuccess() == false) {
            LOG.error("sign up fail, userDO={}" + userDO);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + initPermissionResultDO.getMsg();
        }
        return "redirect:/" + StaticPath.USER_SIGNUP_SUCCESS;
    }

    @Override
    @GetMapping("sign-up")
    public String showSignup(ModelMap map) {
        map.addAttribute("userDO", new UserDO());
        return TemplatePath.USER_SIGNUP;
    }

    @Override
    @GetMapping("sign-in")
    public String showSignin(HttpSession httpSession, Model model) {
        ResultDO<Long> resultDO = SessionContentHolder.judgeSignin(httpSession.getId());
        if (resultDO.isSuccess() == false) {
            return TemplatePath.USER_SIGN_IN;
        }
        String name = userService.getUserDOById(resultDO.getModule()).getModule().getName();
        model.addAttribute("userName", name);
        return TemplatePath.USER_SIGN_IN_SUCCESS;
    }

    @Override
    @PostMapping("sign-in")
    public String signin(@ModelAttribute UserDO userDO, HttpSession httpSession, Model model,
        HttpServletResponse response) {
        try {
            // 参数检查
            if (StringUtils.isEmpty(userDO.getNumber()) || StringUtils.isEmpty(userDO.getPassword())) {
                LOG.error("sign in fail, parameter illegal, userDO={}, sessionId={}", userDO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
            }
            ResultDO<Long> resultDO = userService.signin(userDO);
            if (resultDO.isSuccess() == false) {
                LOG.error("sign in fail, userDO={}, sessionId={}, resultDO={}", userDO, httpSession.getId(), resultDO);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
            }
            long userId = resultDO.getModule();
            if (userId <= 0) {
                LOG.error("sign in fail, userDO={}, sessionId={}, resultDO={}", userDO, httpSession.getId(), resultDO);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
            }
            ResultDO<Void> shiroAuthenticationResultDO = permissionService.shiroAuthentication(userId);
            if (shiroAuthenticationResultDO.isSuccess() == false) {
                LOG.error("shiro authentication fail, userDO={}, sessionId={}, shiroAuthenticationResultDO={}", userDO,
                    httpSession.getId(), shiroAuthenticationResultDO);
                model.addAttribute("msg", "用户名或密码错误");
                return TemplatePath.USER_SIGN_IN;
            }
            ResultDO<Void> initPermissionResultDO = permissionService.initPermissionUserDOsByUserDO(userId);
            if (resultDO.isSuccess() == false) {
                LOG.error("sign up fail, userDO={}" + userDO);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + initPermissionResultDO.getMsg();
            }
            SessionContentHolder.addSignInUserId(httpSession.getId(), resultDO.getModule());
            LOG.info("sign in success, userDO={}, sessionId={}", userDO, httpSession.getId());
            UserDO module = userService.getUserDOById(resultDO.getModule()).getModule();
            String name = module.getName();
            model.addAttribute("userName", name);
            Cookie cookie = new Cookie("userId", Long.toString(module.getId()));
            cookie.setPath("/");
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
            return TemplatePath.USER_SIGN_IN_SUCCESS;

        } catch (Exception e) {
            LOG.error("sign in error, userDO={}, sessionId={}", userDO, httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
    }

    @Override
    @GetMapping("update-password")
    public String showUpdatePassword(ModelMap map, HttpSession httpSession) {
        map.addAttribute("passwordVO", new UpdatePasswordVO());
        return TemplatePath.USER_UPDATE_PASSWORD;
    }

    @Override
    @PostMapping("update-password")
    public String updatePassword(@ModelAttribute UpdatePasswordVO updatePasswordVO, HttpSession httpSession) {
        // 0. 参数校验
        if (StringUtils.isBlank(updatePasswordVO.getOldPassword())
            || StringUtils.isBlank(updatePasswordVO.getNewPassword())
            || StringUtils.isBlank(updatePasswordVO.getConfirmNewPassword())) {
            LOG.error("parameter illegal, updatePasswordVO={}, sessionId={}", updatePasswordVO, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("session error, updatePasswordVO={}, sessionId={}", updatePasswordVO, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }

        // 新密码二次输入校验
        if (StringUtils.equals(updatePasswordVO.getNewPassword(), updatePasswordVO.getConfirmNewPassword()) == false) {
            LOG.error("parameter illegal, updatePasswordVO={}, sessionId={}", updatePasswordVO, httpSession.getId());
            // 重定向到错误页
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.CONFIRM_INVALID;
        }

        try {
            // 1. service入参准备
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            ResultDO<UserDO> getUserDOByIdresultDO = userService.getUserDOById(userId);
            // 返回值成功判断
            if (getUserDOByIdresultDO.isSuccess() == false) {
                LOG.error("get user by id fail, resultDO={}, updatePasswordVO={}, sessionId={}", getUserDOByIdresultDO,
                    updatePasswordVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdresultDO.getMsg();
            }
            UserDO userDO = getUserDOByIdresultDO.getModule();

            // 3. 调用service
            ResultDO<Void> resultDO = userService.updatePassword(userDO, updatePasswordVO.getOldPassword(),
                updatePasswordVO.getNewPassword());
            if (resultDO.isSuccess() == false) {
                LOG.error("updatedate password fail, updatePasswordVO={}, resultDO={}, sessionId={}", updatePasswordVO,
                    resultDO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
            }
            SessionContentHolder.deleteSignInSessionBySessionId(httpSession.getId());
            // 重新种session
            SessionContentHolder.addSignInUserId(httpSession.getId(), userId);
            LOG.info("update password success, updatePasswordVO={}, sessionId={}", updatePasswordVO,
                httpSession.getId());
            return TemplatePath.USER_UPDATE_PASSWORD_SUCCESS;
        } catch (Exception e) {
            LOG.error("update password error, updatePasswordVO={}, sessionId={}", updatePasswordVO, httpSession.getId(),
                e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }

    }

    @Override
    @PostMapping("sign-out")
    public String signout(HttpSession httpSession) {

        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("session error, session={}", httpSession);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        try {
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            if (userId <= 0) {
                LOG.error("sign out error, userId <= 0, sessionId={}", httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
            }

            ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
            if (getUserDOByIdResultDO.isSuccess() == false) {
                LOG.error("sign out fail, userId={}, session={}, resultDO={}", userId, httpSession,
                    getUserDOByIdResultDO);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
            }
        } catch (Exception e) {
            LOG.error("sign out error, sessionId={}", httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        LOG.info("sign out success, sessionId={}, userId={}", httpSession.getId(),
            SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId()));
        SessionContentHolder.deleteSignInSessionBySessionId(httpSession.getId());
        return TemplatePath.USER_SIGN_OUT_SUCCESS;
    }

    @Override
    @GetMapping("sign-out")
    public String showSingout() {
        return TemplatePath.USER_SIGN_OUT;
    }

    @Override
    @GetMapping("verify-identity-step-a")
    public String showRetrievePassword() {
        return TemplatePath.USER_RETRIEVE_PASSWORDB_START;
    }

    @Override
    @GetMapping("verify-identity-step-b-mobile")
    public String showRetrievePasswordByPhone() {
        return TemplatePath.USER_RETRIEVE_PASSWORD_BY_PHONE;
    }

    @Override
    @GetMapping("verify-identity-step-b-email")
    public String showRetrievePasswordByMail() {
        return TemplatePath.USER_RETRIEVE_PASSWORD_BY_MAIL;
    }

    @Override
    @PostMapping("verify-identity-step-b-mobile")
    public String retrievePasswordByPhone(@ModelAttribute RetrievePasswordByPhoneVO retrievePasswordByPhoneVO,
        HttpSession httpSession) {

        if (StringUtils.isBlank(retrievePasswordByPhoneVO.getPhone())
            || StringUtils.isBlank(retrievePasswordByPhoneVO.getVerificationCode())) {
            LOG.error("parameter illegal, retrievePasswordByPhoneVO={}, sessionId={}", retrievePasswordByPhoneVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        String phone = retrievePasswordByPhoneVO.getPhone();
        String verificationCode = retrievePasswordByPhoneVO.getVerificationCode();
        // 返回核验结果
        boolean checkResult = VerificationCodeHolder.checkPhoneVerificationCode(phone, verificationCode);

        if (checkResult == false) {
            LOG.error("verificationCode not match, verificationCode={}, sessionId={}", verificationCode,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        LOG.info("verificationCode match success, retrievePasswordByPhoneVO={}, sessionId={}",
            retrievePasswordByPhoneVO, httpSession.getId());
        SessionContentHolder.addPhone(httpSession.getId(), retrievePasswordByPhoneVO.getPhone());
        return TemplatePath.USER_RETRIEVE_PASSWORDB;
    }

    @Override
    @PostMapping("verify-identity-step-b-email")
    public String retrievePasswordByMail(@ModelAttribute RetrievePasswordByMailVO retrievePasswordByMailVO,
        HttpSession httpSession) {
        // 0.参数验证
        if (StringUtils.isBlank(retrievePasswordByMailVO.getMail())
            || StringUtils.isBlank(retrievePasswordByMailVO.getVerificationCode())) {
            LOG.error("parameter illegal, retrievePasswordByMailVO={}, sessionId={}", retrievePasswordByMailVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        String mail = retrievePasswordByMailVO.getMail();
        String verificationCode = retrievePasswordByMailVO.getVerificationCode();
        boolean checkResult = VerificationCodeHolder.checkMailVerificationCode(mail, verificationCode);

        if (checkResult == false) {
            LOG.error("verificationCode not match, verificationCode={}, sessionId={}", verificationCode,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        LOG.info("verificationCode match success, retrievePasswordByMailVO={}, sessionId={}", retrievePasswordByMailVO,
            httpSession.getId());
        SessionContentHolder.addMail(httpSession.getId(), retrievePasswordByMailVO.getMail());
        return TemplatePath.USER_RETRIEVE_PASSWORDB;
    }

    @Override
    @PostMapping("verify-identity-step-c")
    public String retrievePasswordStepC(@ModelAttribute UpdatePasswordVO updatePasswordVO, HttpSession httpSession) {
        // 参数校验
        if (StringUtils.isEmpty(httpSession.getId())) {
            LOG.error("retrieve password step c error, session is empty, updatePasswordVO={}, sessionId={}",
                updatePasswordVO, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        if (StringUtils.isBlank(updatePasswordVO.getNewPassword())
            || StringUtils.isBlank(updatePasswordVO.getConfirmNewPassword())) {
            LOG.error("retrieve password step c error, parameter illegal, updatePasswordVO={}, sessionId={}",
                updatePasswordVO, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }

        String mail = SessionContentHolder.getMailBySessionId(httpSession.getId());
        String phone = SessionContentHolder.getPhoneBySessionId(httpSession.getId());
        if (StringUtils.isBlank(mail) && StringUtils.isBlank(phone)) {
            LOG.error("retrievePasswordStepC error, phone and mail both null, updatePasswordVO={}, httpSession={}",
                updatePasswordVO, httpSession);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        try {
            // 如果是邮箱找密
            if (!StringUtils.isBlank(mail)) {
                // 验证邮箱是否是刚才填的邮箱
                ResultDO<UserDO> resultDO = userService.getUserDOByMail(mail); // 返回结果判断
                if (resultDO.isSuccess() == false) {
                    LOG.error("get userDO by mail fail, resultDO={}, updatePasswordVO={}, sessionId={}", resultDO,
                        updatePasswordVO, httpSession.getId());
                    return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
                }

            } // 如果是手机找密
            else if (!StringUtils.isBlank(phone)) {
                // 验证手机是否是刚才填的手机
                ResultDO<UserDO> resultDO = userService.getUserDOByPhone(phone);
                if (resultDO.isSuccess() == false) {
                    LOG.error("get userDO by phone fail, resultDO={}, updatePasswordVO={}, sessionId={}", resultDO,
                        updatePasswordVO, httpSession.getId());
                    return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
                }

            } // 手机邮箱都找不到

            // 验证新密二次确认
            if (StringUtils.equals(updatePasswordVO.getNewPassword(), updatePasswordVO.getConfirmNewPassword()) == false
                || StringUtils.isBlank(updatePasswordVO.getNewPassword())
                || StringUtils.isBlank(updatePasswordVO.getConfirmNewPassword())) {
                LOG.error("parameter illegal, updatePasswordVO={}, sessionId={}", updatePasswordVO,
                    httpSession.getId());
                // 重定向到文案提示页面
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
            }
            // 改密
            // 邮箱改密
            if (!StringUtils.isBlank(mail)) {
                ResultDO<Void> updatePasswordResultDO = userService.retrievePasswordByMail(mail,
                    updatePasswordVO.getNewPassword());
                if (updatePasswordResultDO.isSuccess() == false) {
                    LOG.error(
                        "user service retrieve pass word by mail fail, resultDO={}, updatePasswordVO={}, sessionId={}",
                        updatePasswordResultDO, updatePasswordVO, httpSession.getId());
                    return "redirect:/" + StaticPath.COMMON_ERROR + "?" + updatePasswordResultDO.getMsg();
                }
                SessionContentHolder.deleteMailSessionBySessionId(httpSession.getId());
                LOG.info("retrieve password by mail success, mail={}, updatePasswordVO={}, sessionId={}", mail,
                    updatePasswordResultDO, updatePasswordVO, httpSession.getId());
                return TemplatePath.USER_RETRIEVE_PASSWORD_SUCCESS;
            }
            // 手机改密
            else if (!StringUtils.isBlank(phone)) {
                ResultDO<Void> updatePasswordResultDO = userService.retrievePasswordByPhone(phone,
                    updatePasswordVO.getNewPassword());
                if (updatePasswordResultDO.isSuccess() == false) {
                    LOG.error(
                        "user service retrieve password by phone fail, resultDO={}, updatePasswordVO={}, sessionId={}",
                        updatePasswordResultDO, updatePasswordVO, httpSession.getId());
                    return "redirect:/" + StaticPath.COMMON_ERROR + "?" + updatePasswordResultDO.getMsg();
                }
                SessionContentHolder.deletePhoneSessionBySessionId(httpSession.getId());
                LOG.info("retrieve password by phone success, phone={}, updatePasswordVO={}, sessionId={}", phone,
                    updatePasswordVO, httpSession.getId());
                return TemplatePath.USER_RETRIEVE_PASSWORD_SUCCESS;
            } else {
                LOG.error("retrieve password error, mail and phone both null, updatePasswordVO={}, sessionId={}",
                    updatePasswordVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
            }
        } catch (Exception e) {
            LOG.error("retrieve password step c error, updatePasswordVO={}, sessionId={}", updatePasswordVO,
                httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
    }

    @Override
    @GetMapping("mail-authentication")
    public String showMailAuthentication(ModelMap map, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
        if (getUserDOByIdResultDO.isSuccess() == false) {
            LOG.error("mail authentication get UserDO by id fail, getUserDOByIdResultDO={}, map={}, sessionId={}",
                getUserDOByIdResultDO, map, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
        }
        UserDO userDO = getUserDOByIdResultDO.getModule();
        if (userDO == null) {
            LOG.error("mail authentication userDO is null, userDO={}, userId={}", userDO, userId);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
        }
        map.addAttribute("userDO", userDO);
        map.addAttribute("mailCaptchaVO", new MailCaptchaVO());
        return TemplatePath.USER_MAIL_AUTHENTICATION;
    }

    @Override
    @PostMapping("mail-authentication")
    public String mailAuthentication(@ModelAttribute MailCaptchaVO mailCaptchaVO, HttpSession httpSession) {
        // 验证邮箱验证码
        // 0.参数验证
        if (StringUtils.isBlank(mailCaptchaVO.getCaptchaFromFront())) {
            LOG.error("mail authentication parameter illegal, mailCaptchaVO={}, sessionId={}", mailCaptchaVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("mail authentication session is null, mailCaptchaVO={}, sessionId={}", mailCaptchaVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        // 1. service入参准备
        UserDO userDO;
        try {
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
            if (getUserDOByIdResultDO.isSuccess() == false) {
                LOG.error(
                    "mail authentication get UserDO by id fail, getUserDOByIdResultDO={}, mailCaptchaVO={}, sessionId={}",
                    getUserDOByIdResultDO, mailCaptchaVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
            }
            userDO = getUserDOByIdResultDO.getModule();
            if (userDO == null) {
                LOG.error("mail authentication userDO is null, userDO={}, userId={}", userDO, userId);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
            }
        } catch (Exception e) {
            LOG.error("mail authentication session error, mailCaptchaVO={}, sessionId={}", mailCaptchaVO,
                httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        String mail = null;
        String getCaptchaFromFront = null;
        try {
            mail = userDO.getEmail();
            getCaptchaFromFront = mailCaptchaVO.getCaptchaFromFront();
        } catch (Exception e) {
            LOG.error("mail authentication mail or getCaptchaFromFront error, mail={}, getCaptchaFromFront={}", mail,
                getCaptchaFromFront, e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        // 2. 验证码托管
        boolean checkResult = VerificationCodeHolder.checkMailVerificationCode(mail, getCaptchaFromFront);
        if (checkResult == false) {
            LOG.error("mail authentication verificationCode not match, mail={}, getCaptchaFromFront={}", mail,
                getCaptchaFromFront);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        LOG.info("mail authentication captcha match success, mail={}, getCaptchaFromFront={}", mail,
            getCaptchaFromFront);
        SessionContentHolder.addMail(httpSession.getId(), userDO.getEmail());
        return TemplatePath.USER_UPDATE_MAIL;
    }

    @Override
    @PostMapping("updateMail")
    public String updateMail(@ModelAttribute UpdateMailVO updateMailVO, HttpSession httpSession) {
        // 验证邮箱验证码
        // 0.参数验证
        if (StringUtils.isBlank(updateMailVO.getMail()) || StringUtils.isBlank(updateMailVO.getCaptchaFromFront())) {
            LOG.error("update mail parameter illegal, updateMailVO={}, sessionId={}", updateMailVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("update mail session error, mailCaptchaVO={}, sessionId={}", updateMailVO, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        String mail = null;
        String getCaptchaFromFront = null;
        try {
            mail = updateMailVO.getMail();
            getCaptchaFromFront = updateMailVO.getCaptchaFromFront();
        } catch (Exception e) {
            LOG.error("update mail mail or getCaptchaFromFront error, mail={}, getCaptchaFromFront={}", mail,
                getCaptchaFromFront, e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        boolean checkResult = VerificationCodeHolder.checkMailVerificationCode(mail, getCaptchaFromFront);
        if (checkResult == false) {
            LOG.error("update mail verificationCode not match, mail={}, getCaptchaFromFront={}", mail,
                getCaptchaFromFront);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }

        LOG.info("update mail verificationCode match success, updateMailVO={}, sessionId={}", updateMailVO,
            httpSession.getId());
        SessionContentHolder.addMail(httpSession.getId(), updateMailVO.getMail());

        // 修改原邮箱值
        // 1. service入参准备
        UserDO userDO;
        try {
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
            if (getUserDOByIdResultDO.isSuccess() == false) {
                LOG.error("update mail get UserDO by id fail, getUserDOByIdResultDO={}, updateMailVO={}, sessionId={}",
                    getUserDOByIdResultDO, updateMailVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
            }
            userDO = getUserDOByIdResultDO.getModule();
            if (userDO == null) {
                LOG.error("updata mail userDO is null, userDO={}, userId={}", userDO, userId);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
            }
        } catch (Exception e) {
            LOG.error("update mail session error, updateMailVO={}, sessionId={}", updateMailVO, httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }

        // 2.调用service
        ResultDO<Void> resultDO = userService.updateMail(userDO, updateMailVO.getMail());
        if (resultDO.isSuccess() == false) {
            LOG.error("update mail fail, updateMailVO={}, resultDO={}", updateMailVO, resultDO);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        SessionContentHolder.deleteSignInSessionBySessionId(httpSession.getId());
        // 重新种session
        SessionContentHolder.addSignInUserId(httpSession.getId(), userDO.getId());
        LOG.info("update mail success, updateMailVO={}, sessionId={}", updateMailVO, httpSession.getId());

        return TemplatePath.USER_UPDATE_MAIL_SUCCESS;
    }

    @Override
    @GetMapping("mobile-authentication")
    public String showMobileAuthentication(ModelMap map, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
        if (getUserDOByIdResultDO.isSuccess() == false) {
            LOG.error("mobile authentication get UserDO by id fail, getUserDOByIdResultDO={}, map={}, sessionId={}",
                getUserDOByIdResultDO, map, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
        }
        UserDO userDO = getUserDOByIdResultDO.getModule();
        if (userDO == null) {
            LOG.error("mobile authentication userDO is null, userDO={}, userId={}", userDO, userId);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;

        }
        map.addAttribute("userDO", userDO);
        map.addAttribute("CaptchaVO", new CaptchaVO());
        return TemplatePath.USER_MOBILE_AUTHENTICATION;
    }

    @Override
    @PostMapping("mobile-authentication")
    public String mobileAuthentication(@ModelAttribute CaptchaVO mobileCaptchaVO, HttpSession httpSession) {
        // 验证手机验证码
        // 0. 参数校验
        if (StringUtils.isBlank(mobileCaptchaVO.getCaptchaFromFront())) {
            LOG.error("mobile authentication parameter illegal, mobileCaptchaVO={} sessionId={}", mobileCaptchaVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("mobile authentication session is null, mobileCaptchaVO={}, sessionId={}", mobileCaptchaVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        // 1. service入参准备
        UserDO userDO;
        try {
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
            if (getUserDOByIdResultDO.isSuccess() == false) {
                LOG.error(
                    "mobile authentication get UserDO by id fail, getUserDOByIdResultDO={}, mobileCaptchaVO={}, sessionId={}",
                    getUserDOByIdResultDO, mobileCaptchaVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
            }
            userDO = getUserDOByIdResultDO.getModule();
            if (userDO == null) {
                LOG.error("mobile authentication userDO is null, userDO={}, userId={}", userDO, userId);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
            }
        } catch (Exception e) {
            LOG.error("mobile authentication session error, mobileCaptchaVO={}, sessionId={}", mobileCaptchaVO,
                httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        String mobile = null;
        String getCaptchaFromFront = null;
        try {
            mobile = userDO.getContactPhone();
            getCaptchaFromFront = mobileCaptchaVO.getCaptchaFromFront();
        } catch (Exception e) {
            LOG.error("mobile authentication mobile or getCaptchaFromFront error, mobile={}, getCaptchaFromFront={}",
                mobile, getCaptchaFromFront, e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        // 2. 验证码托管
        boolean checkResult = VerificationCodeHolder.checkPhoneVerificationCode(mobile, getCaptchaFromFront);
        if (checkResult == false) {
            LOG.error("mobile authentication verificationCode not match, mobile={}, getCaptchaFromFront={}", mobile,
                getCaptchaFromFront);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        LOG.info("mobile authentication captcha match success, mobile={}, getCaptchaFromFront={}", mobile,
            getCaptchaFromFront);
        SessionContentHolder.addPhone(httpSession.getId(), userDO.getContactPhone());
        return TemplatePath.USER_UPDATE_MOBILE;
    }

    @Override
    @PostMapping("update-mobile")
    public String updateMobile(@ModelAttribute UpdateMobileVO updateMobileVO, HttpSession httpSession) {
        // 验证手机验证码
        // 0.参数验证
        if (StringUtils.isBlank(updateMobileVO.getMobile())
            || StringUtils.isBlank(updateMobileVO.getCaptchaFromFront())) {
            LOG.error("update mobile parameter illegal, updateMobileVO={}, sessionId={}", updateMobileVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("update mobile session error, mobileCaptchaVO={}, sessionId={}", updateMobileVO,
                httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        String mobile = null;
        String getCaptchaFromFront = null;
        try {
            mobile = updateMobileVO.getMobile();
            getCaptchaFromFront = updateMobileVO.getCaptchaFromFront();
        } catch (Exception e) {
            LOG.error("updateMobileVO error, mobile={}, getCaptchaFromFront={}", mobile, getCaptchaFromFront, e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        boolean checkResult = VerificationCodeHolder.checkPhoneVerificationCode(mobile, getCaptchaFromFront);
        if (checkResult == false) {
            LOG.error("update mobile verificationCode not match, mobile={}, getCaptchaFromFront={}", mobile,
                getCaptchaFromFront);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.VERIFICATION_CODE_NOT_MATCH;
        }
        LOG.info("update mobile verificationCode match success, updateMobileVO={}, sessionId={}", updateMobileVO,
            httpSession.getId());
        SessionContentHolder.addPhone(httpSession.getId(), updateMobileVO.getMobile());
        // 修改旧手机
        // 1. service入参准备
        UserDO userDO;
        try {
            long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
            ResultDO<UserDO> getUserDOByIdResultDO = userService.getUserDOById(userId);
            if (getUserDOByIdResultDO.isSuccess() == false) {
                LOG.error(
                    "update mobile get UserDO by id fail, getUserDOByIdResultDO={}, updateMobileVO={}, sessionId={}",
                    getUserDOByIdResultDO, updateMobileVO, httpSession.getId());
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + getUserDOByIdResultDO.getMsg();
            }
            userDO = getUserDOByIdResultDO.getModule();
            if (userDO == null) {
                LOG.error("updata mobile userDO is null, userDO={}, userId={}", userDO, userId);
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
            }
        } catch (Exception e) {
            LOG.error("update mobile session error, updateMobileVO={}, sessionId={}", updateMobileVO,
                httpSession.getId(), e);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.SYSTEM_ERROR;
        }
        // 2.调用service
        ResultDO<Void> resultDO = userService.updateMobile(userDO, updateMobileVO.getMobile());
        if (resultDO.isSuccess() == false) {
            LOG.error("update mobile fail, updateMobileVO={}, resultDO={}", updateMobileVO, resultDO);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        SessionContentHolder.deleteSignInSessionBySessionId(httpSession.getId());
        // 重新种session
        SessionContentHolder.addSignInUserId(httpSession.getId(), userDO.getId());
        LOG.info("update mobile success, updateMobileVO={}, sessionId={}", updateMobileVO, httpSession.getId());
        return TemplatePath.USER_UPDATE_MOBILE_SUCCESS;
    }

    @Override
    @GetMapping("home")
    public String showUserHome(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        ResultDO<UserDO> resultDO = userService.getUserDOById(userId);
        if (resultDO.isSuccess() == false) {
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        model.addAttribute("userName", resultDO.getModule().getName());
        long type = resultDO.getModule().getType();
        if (type == 90001 || type == 90002) {
            return TemplatePath.ADMIN_HOME;
        } else {
            return TemplatePath.USER_HOME;
        }
    }

    @Override
    @GetMapping("my-information")
    public String showMyInformation(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.USER_MY_INFORMATION;
    }

    @Override
    @GetMapping("my-informationupdate")
    public String showMyInformationupdate(Model model, HttpSession httpSession) {
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        model.addAttribute("userId", userId);
        return TemplatePath.USER_MY_INFORMATION_UPDATE;
    }

}
