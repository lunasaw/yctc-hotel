package com.altersoftware.hotel.service;

import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.PermissionGroupDO;
import com.altersoftware.hotel.entity.ResultDO;

import java.util.List;



public interface PermissionIService {

    /**
     * Shiro用户认证
     * 
     * @param userId
     * @return
     */
    public ResultDO<Void> shiroAuthentication(long userId);

    /**
     * 初始化用户权限
     * 
     * @param userId
     * @return
     */
    public ResultDO<Void> initPermissionUserDOsByUserDO(long userId);

    /**
     * 通过userDO得到其拥有的所有权限的resource
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<String>> getResourceOfPermissionsByUserId(long userId);

    /**
     * 展示所有的权限
     * 
     * @return
     */
    public ResultDO<List<PermissionDO>> showAllPermissions();

    /**
     * 展示用户拥有的权限
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<PermissionDO>> showPermissions(long userId);

    /**
     * 添加单个权限
     * 
     * @param userNumber
     * @param permissionName
     * @return
     */
    public ResultDO<Void> addPermission(String userNumber, String permissionName);

    /**
     * 删除单个权限
     * 
     * @param userNumber
     * @param permissionName
     * @return
     */
    public ResultDO<Void> deletePermission(String userNumber, String permissionName);

    /**
     * 展示用户拥有的权限
     * 
     * @param userNumber
     * @return
     */
    public ResultDO<List<PermissionDO>> showPermissionsHave(String userNumber);

    /**
     * 展示所有permissionGroup
     * 
     * @param
     * @return
     */
    public ResultDO<List<PermissionGroupDO>> showAllPermissionGroup();

    /**
     * 增加单个permissionGroup
     * 
     * @param permissionGroupName
     * @param permissionIds
     * @return
     */
    public ResultDO<Void> addPermissionGroup(String permissionGroupName, List<Long> permissionIds);

    /**
     * 根据permissionGroupId删除permissionGroup
     * 
     * @param permissionGroupId
     * @return
     */
    public ResultDO<Void> delPermissionGroupByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId修改其拥有的所有权限
     * 
     * @param permissionGroupName
     * @param permissionGroupId
     * @param permissionIds
     * @return
     */
    public ResultDO<Void> modifyPermissionGroup(String permissionGroupName, Long permissionGroupId,
                                                List<Long> permissionIds);

    /**
     * 根据permissionGroupId展示其已拥有的所有权限PermissionDO
     * 
     * @param permissionGroupId
     * @return
     */
    public ResultDO<List<PermissionDO>> getPermissionsByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId获得permissionGroupName
     * 
     * @param permissionGroupId
     * @return
     */
    public ResultDO<String> getPermissionGroupNameByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId展示其已拥有的所有PermissionIds
     * 
     * @param permissionGroupId
     * @return
     */
    public ResultDO<List<Long>> getPermissionIdsByPermissionGroupId(Long permissionGroupId);

}
