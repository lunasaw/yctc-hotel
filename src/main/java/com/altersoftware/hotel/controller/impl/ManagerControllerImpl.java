package com.altersoftware.hotel.controller.impl;

import javax.servlet.http.HttpSession;

import com.altersoftware.hotel.constant.ErrorText;
import com.altersoftware.hotel.constant.StaticPath;
import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.ManagerController;
import com.altersoftware.hotel.controller.session.SessionContentHolder;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.UserIService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@ComponentScan({"edu.yctc.hotel.service"})
@RequestMapping("/manage")
/**
 * managerController接口实现
 *
 * @author wlt
 */
public class ManagerControllerImpl implements ManagerController {

    private final static Logger LOG = LoggerFactory.getLogger("managerControllerLogger");

    @Autowired
    private UserIService userService;

    @Override
    @RequestMapping("no-authorization")
    public String showNoAuthorization() {

        return "manage/no-authorization";
    }

    @Override
    @RequestMapping("functions-of-mine")
    public String showFunctionsOfMine() {

        return "manage/functions-of-mine";
    }

    @Override
    @RequestMapping("user-manage")
    public String showUserManage(Model model, HttpSession httpSession) {
        if (StringUtils.isBlank(httpSession.getId())) {
            LOG.error("show user manage fail, sessionId is blank, model={}, sessionId={}", model, httpSession.getId());
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        long userId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (userId <= 0) {
            LOG.error("show user manage fail, userId <= 0, model={}, sessionId={}, userId={}", model,
                httpSession.getId(), userId);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.NO_SUCH_USER;
        }
        ResultDO<UserDO> resultDO = userService.getUserDOById(userId);
        if (resultDO.isSuccess() == false) {
            LOG.error("show user manage fail, get userDO by id fail, resultDO={}, model={}, sessionId={}, userId={}",
                resultDO, model, httpSession.getId(), userId);
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        String userName = resultDO.getModule().getName();
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        return TemplatePath.USER_MANAGE;
    }
}
