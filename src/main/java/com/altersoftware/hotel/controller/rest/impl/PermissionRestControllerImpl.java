package com.altersoftware.hotel.controller.rest.impl;

import java.util.Iterator;
import java.util.List;

import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.controller.rest.PermissionRestController;
import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.PermissionGroupDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.service.PermissionIService;
import com.altersoftware.hotel.vo.AuthorizationVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndIdAndPermissionIdsVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndPermissionIdsVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan({"edu.yctc.hotel.service"})
@ComponentScan({"edu.yctc.hotel.service.message"})
@RequestMapping("/restpermission")
@Async
/**
 * PermissionRest接口实现
 *
 * @author wlt
 */
public class PermissionRestControllerImpl implements PermissionRestController {

    @Autowired
    private PermissionIService permissionService;

    @Override
    @PostMapping("add-permission")
    public ResultDO<Void> addPermission(@RequestBody AuthorizationVO authorizationVO) {
        if (authorizationVO == null) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        String userNumber = authorizationVO.getUserNumber();
        String permissionName = authorizationVO.getPermissionName();
        return permissionService.addPermission(userNumber, permissionName);
    }

    @Override
    @PostMapping("delete-permission")
    public ResultDO<Void> deletePermission(@RequestBody AuthorizationVO authorizationVO) {
        if (authorizationVO == null) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        String userNumber = authorizationVO.getUserNumber();
        String permissionName = authorizationVO.getPermissionName();
        return permissionService.deletePermission(userNumber, permissionName);
    }

    @Override
    @PostMapping("show-permissions-have")
    public ResultDO<List<PermissionDO>> showPermissionsHave(@RequestBody String userNumber) {
        if (StringUtils.isBlank(userNumber)) {
            return new ResultDO<List<PermissionDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID);
        }
        return permissionService.showPermissionsHave(userNumber);
    }

    @Override
    @PostMapping("show-permissions-not-have")
    public ResultDO<List<PermissionDO>> showPermissionsNotHave(@RequestBody String userNumber) {
        if (StringUtils.isBlank(userNumber)) {
            return new ResultDO<List<PermissionDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID);
        }
        // 拥有的权限的list
        ResultDO<List<PermissionDO>> resultDOPermissionsHave = permissionService.showPermissionsHave(userNumber);
        if (resultDOPermissionsHave.isSuccess() == false) {
            return resultDOPermissionsHave;
        }
        List<PermissionDO> PermissionsHasList = resultDOPermissionsHave.getModule();
        // 所有的权限的list
        ResultDO<List<PermissionDO>> resultDOAllPermissions = permissionService.showAllPermissions();
        List<PermissionDO> AllPermissionsList = resultDOAllPermissions.getModule();
        for (int i = 0; i < PermissionsHasList.size(); i++) {
            for (Iterator<PermissionDO> iterator = AllPermissionsList.iterator(); iterator.hasNext();) {
                if (iterator.next().getId() == PermissionsHasList.get(i).getId()) {
                    iterator.remove();
                }
            }
        }
        return new ResultDO<List<PermissionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, AllPermissionsList);
    }

    @Override
    @PostMapping("show-all-permissions")
    public ResultDO<List<PermissionDO>> showAllPermissions() {
        return permissionService.showAllPermissions();
    }

    @Override
    @PostMapping("show-all-roles")
    public ResultDO<List<PermissionGroupDO>> showAllRoles() {
        return permissionService.showAllPermissionGroup();
    }

    @Override
    @PostMapping("delete-role-by-permissiongroupid")
    public ResultDO<Void> deleteRoleByPermissionGroupId(@RequestBody Long permissionGroupId) {
        if (permissionGroupId == null) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return permissionService.delPermissionGroupByPermissionGroupId(permissionGroupId);
    }

    @Override
    @PostMapping("add-role")
    public ResultDO<Void>
        addRole(@RequestBody PermissionGroupNameAndPermissionIdsVO permissionGroupNameAndPermissionIdsVO) {
        if (permissionGroupNameAndPermissionIdsVO == null) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        String permissionGroupName = permissionGroupNameAndPermissionIdsVO.getName();
        List<Long> permissionIds = permissionGroupNameAndPermissionIdsVO.getPermissonIds();
        System.out.println(permissionGroupName + " " + permissionIds);
        return permissionService.addPermissionGroup(permissionGroupName, permissionIds);
    }

    @Override
    @PostMapping("modify-role")
    public ResultDO<Void>
        modifyRole(@RequestBody PermissionGroupNameAndIdAndPermissionIdsVO permissionGroupNameAndIdAndPermissionIdsVO) {
        if (permissionGroupNameAndIdAndPermissionIdsVO == null) {
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        String permissionGroupName = permissionGroupNameAndIdAndPermissionIdsVO.getName();
        Long permissionGroupId = permissionGroupNameAndIdAndPermissionIdsVO.getId();
        List<Long> permissionIds = permissionGroupNameAndIdAndPermissionIdsVO.getPermissonIds();
        return permissionService.modifyPermissionGroup(permissionGroupName, permissionGroupId, permissionIds);
    }

    @Override
    @PostMapping("get-permissionname-by-permissiongroupid")
    public ResultDO<String> getPermissionNameByPermissionGroupId(@RequestBody Long permissionGroupId) {
        if (permissionGroupId == null) {
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return permissionService.getPermissionGroupNameByPermissionGroupId(permissionGroupId);
    }

    @Override
    @PostMapping("get-permissionidlist-by-permissiongroupid")
    public ResultDO<List<Long>> getPermissionIdListByPermissionGroupId(@RequestBody Long permissionGroupId) {
        if (permissionGroupId == null) {
            return new ResultDO<List<Long>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return permissionService.getPermissionIdsByPermissionGroupId(permissionGroupId);
    }
}
