package com.altersoftware.hotel.service;

import java.util.List;

import com.altersoftware.hotel.entity.PermissionDO;
import com.altersoftware.hotel.entity.PermissionGroupDO;
import com.altersoftware.hotel.entity.ResultDO;


public interface PermissionIService {

    /**
     * Shiro用户认证
     * 
     * @param userId
     * @return
     */
    ResultDO<Void> shiroAuthentication(long userId);

    /**
     * 初始化用户权限
     * 
     * @param userId
     * @return
     */
    ResultDO<Void> initPermissionUserDOsByUserDO(long userId);

    /**
     * 通过userDO得到其拥有的所有权限的resource
     * 
     * @param userId
     * @return
     */
    ResultDO<List<String>> getResourceOfPermissionsByUserId(long userId);

    /**
     * 展示所有的权限
     * 
     * @return
     */
    ResultDO<List<PermissionDO>> showAllPermissions();

    /**
     * 展示用户拥有的权限
     * 
     * @param userId
     * @return
     */
    ResultDO<List<PermissionDO>> showPermissions(long userId);

    /**
     * 添加单个权限
     * 
     * @param userNumber
     * @param permissionName
     * @return
     */
    ResultDO<Void> addPermission(String userNumber, String permissionName);

    /**
     * 删除单个权限
     * 
     * @param userNumber
     * @param permissionName
     * @return
     */
    ResultDO<Void> deletePermission(String userNumber, String permissionName);

    /**
     * 展示用户拥有的权限
     * 
     * @param userNumber
     * @return
     */
    ResultDO<List<PermissionDO>> showPermissionsHave(String userNumber);

    /**
     * 展示所有permissionGroup
     * 
     * @param
     * @return
     */
    ResultDO<List<PermissionGroupDO>> showAllPermissionGroup();

    /**
     * 增加单个permissionGroup
     * 
     * @param permissionGroupName
     * @param permissionIds
     * @return
     */
    ResultDO<Void> addPermissionGroup(String permissionGroupName, List<Long> permissionIds);

    /**
     * 根据permissionGroupId删除permissionGroup
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<Void> delPermissionGroupByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId修改其拥有的所有权限
     * 
     * @param permissionGroupName
     * @param permissionGroupId
     * @param permissionIds
     * @return
     */
    ResultDO<Void> modifyPermissionGroup(String permissionGroupName, Long permissionGroupId,
        List<Long> permissionIds);

    /**
     * 根据permissionGroupId展示其已拥有的所有权限PermissionDO
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<List<PermissionDO>> getPermissionsByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId获得permissionGroupName
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<String> getPermissionGroupNameByPermissionGroupId(Long permissionGroupId);

    /**
     * 根据permissionGroupId展示其已拥有的所有PermissionIds
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<List<Long>> getPermissionIdsByPermissionGroupId(Long permissionGroupId);

    /**
     * id获取权限组
     * 
     * @param permissionGroupId
     * @return
     */
    ResultDO<PermissionGroupDO> getPermissionGroupNameAndIdByPermissionGroupId(Long permissionGroupId);

}
