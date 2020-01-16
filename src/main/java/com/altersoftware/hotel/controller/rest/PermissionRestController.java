package com.altersoftware.hotel.controller.rest;

import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.PermissionGroupDO;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.vo.AuthorizationVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndIdAndPermissionIdsVO;
import com.altersoftware.hotel.vo.PermissionGroupNameAndPermissionIdsVO;

import java.util.List;



public interface PermissionRestController {

    /**
     * 添加单个权限(params中包含userId和permissionId)
     *
     * @param authorizationVO
     * @return
     */
    public ResultDO<Void> addPermission(AuthorizationVO authorizationVO);

    /**
     * 删除单个权限(params中包含userId和permissionId)
     *
     * @param authorizationVO
     * @return
     */
    public ResultDO<Void> deletePermission(AuthorizationVO authorizationVO);

    /**
     * 显示所有拥有的权限集
     *
     * @param userNumber
     * @return
     */
    public ResultDO<List<PermissionDO>> showPermissionsHave(String userNumber);

    /**
     * 显示所有未拥有的权限集
     *
     * @param userNumber
     * @return
     */
    public ResultDO<List<PermissionDO>> showPermissionsNotHave(String userNumber);

    /**
     * 获得所有的权限集
     *
     * @param
     * @return
     */
    public ResultDO<List<PermissionDO>> showAllPermissions();

    /**
     * 获得所有的角色
     *
     * @param
     * @return
     */
    public ResultDO<List<PermissionGroupDO>> showAllRoles();

    /**
     * 删除角色
     *
     * @param permissionGroupId
     * @return
     */
    public ResultDO<Void> deleteRoleByPermissionGroupId(Long permissionGroupId);

    /**
     * 增加角色
     *
     * @param permissionGroupNameAndPermissionIdsVO
     * @return
     */
    public ResultDO<Void> addRole(PermissionGroupNameAndPermissionIdsVO permissionGroupNameAndPermissionIdsVO);

    /**
     * 修改角色
     *
     * @param permissionGroupNameAndPermissionIdsVO
     * @return
     */
    public ResultDO<Void>
        modifyRole(PermissionGroupNameAndIdAndPermissionIdsVO permissionGroupNameAndIdAndPermissionIdsVO);

    /**
     * 根据PermissionGroupId获得PermissionGroupName
     *
     * @param PermissionGroupId
     * @return
     */
    public ResultDO<String> getPermissionNameByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据PermissionGroupId获得PermissionIdList
     *
     * @param PermissionGroupId
     * @return
     */
    public ResultDO<List<Long>> getPermissionIdListByPermissionGroupId(Long permissionGroupId);
}
