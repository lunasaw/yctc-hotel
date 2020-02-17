package com.altersoftware.hotel.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.PermissionGroupDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.AuthorizationVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndIdAndPermissionIdsVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndPermissionIdsVO;


public interface PermissionRestController {

    /**
     * 添加单个权限(params中包含userId和permissionId)
     *
     * @param authorizationVO
     * @return
     */
    ResultDO<Void> addPermission(AuthorizationVO authorizationVO);

    /**
     * 删除单个权限(params中包含userId和permissionId)
     *
     * @param authorizationVO
     * @return
     */
    ResultDO<Void> deletePermission(AuthorizationVO authorizationVO);

    /**
     * 显示所有拥有的权限集
     *
     * @param userNumber
     * @return
     */
    ResultDO<List<PermissionDO>> showPermissionsHave(String userNumber);

    /**
     * 显示所有未拥有的权限集
     *
     * @param userNumber
     * @return
     */
    ResultDO<List<PermissionDO>> showPermissionsNotHave(String userNumber);

    /**
     * 获得所有的权限集
     *
     * @param
     * @return
     */
    ResultDO<List<PermissionDO>> showAllPermissions();

    /**
     * 获得所有的角色
     *
     * @param
     * @return
     */
    ResultDO<List<PermissionGroupDO>> showAllRoles();

    /**
     * 删除角色
     *
     * @param permissionGroupId
     * @return
     */
    ResultDO<Void> deleteRoleByPermissionGroupId(Long permissionGroupId);

    /**
     * 增加角色
     *
     * @param permissionGroupNameAndPermissionIdsVO
     * @return
     */
    ResultDO<Void> addRole(PermissionGroupNameAndPermissionIdsVO permissionGroupNameAndPermissionIdsVO);

    /**
     * 修改角色
     *
     * @param permissionGroupNameAndPermissionIdsVO
     * @return
     */
    ResultDO<Void>
        modifyRole(PermissionGroupNameAndIdAndPermissionIdsVO permissionGroupNameAndIdAndPermissionIdsVO);

    /**
     * 根据PermissionGroupId获得PermissionGroupName
     *
     * @param PermissionGroupId
     * @return
     */
    ResultDO<String> getPermissionNameByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据PermissionGroupId
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<PermissionGroupDO> getPermissionNameAndIdByPermissionGroupId(@RequestBody Long permissionGroupId);

    /**
     * 根据PermissionGroupId获得PermissionIdList
     *
     * @param PermissionGroupId
     * @return
     */
    ResultDO<List<Long>> getPermissionIdListByPermissionGroupId(Long permissionGroupId);
}
