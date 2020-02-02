package com.altersoftware.hotel.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altersoftware.hotel.constant.TemplatePath;
import com.altersoftware.hotel.controller.EducationController;
import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.PermissionIService;


@Controller
@ComponentScan({"com.altersoftware.hotel.service"})
@RequestMapping("/education")
/**
 * educationController接口实现
 *
 * @author wlt
 */
public class EducationControllerImpl implements EducationController {

    private final static Logger LOG = LoggerFactory.getLogger("educationControllerLogger");

    @Autowired
    private PermissionIService permissionService;

    @Override
    @GetMapping("authority-management")
    public String showAuthorityManagement(Model model) {
        ResultDO<List<PermissionDO>> resultDO = permissionService.showAllPermissions();
        if (resultDO.isSuccess() == false) {
            LOG.error("shiro authentication fail, ResultDO={}", resultDO);
            model.addAttribute("msg", "权限错误，请重新登录");
            return TemplatePath.USER_SIGN_IN;
        }
        List<PermissionDO> permissionDOList = resultDO.getModule();
        model.addAttribute("PermissionDOList", permissionDOList);
        return TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT;
    }



    @Override
    @RequestMapping("authority-role-management")
    public String showAuthorityRoleManagement(Model model) {
        return TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT;
    }

    @Override
    @RequestMapping("authority-role-management-add")
    public String showAuthorityRoleManagementAdd(Model model) {
        return TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD;
    }

    @Override
    @RequestMapping("authority-role-management-modify")
    public String showAuthorityRoleManagementModify(Model model) {
        return TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY;
    }
}
