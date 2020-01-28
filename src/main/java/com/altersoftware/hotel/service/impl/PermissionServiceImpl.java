package com.altersoftware.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.altersoftware.hotel.cache.permission.UserPermissionCache;
import com.altersoftware.hotel.constant.ResultCode;
import com.altersoftware.hotel.dao.*;
import com.altersoftware.hotel.entity.*;
import com.altersoftware.hotel.service.PermissionIService;


/**
 * permissionService接口实现
 *
 * @author wlt
 */
@ComponentScan({"edu.yctc.hotel.dao"})
@Service("permissionService")
public class PermissionServiceImpl implements PermissionIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Resource
    private UserDAO userDAO;//用户
    @Resource
    private PermissionDAO permissionDAO;//权限
    @Resource
    private PermissionUserDAO permissionUserDAO;//权限信息
    @Resource
    private PermissionGroupDAO permissionGroupDAO;//权限组
    @Resource
    private PermissionGroupPermissionDAO permissionGroupPermissionDAO;//权限组信息

    /** 教师权限组 */
    private static final String TEACHER_GROUP_NAME = "permTeacher";
    private static final long TEACHER_GROUP_ID = 1;
    /** 学生权限组 */
    private static final String STUDENT_GROUP_NAME = "permStudent";
    private static final long STUDENT_GROUP_ID = 2;
    /** 管理员权限组 */
    private static final String ADMINISTRATOR_GROUP_NAME = "permAdministrator";
    private static final long ADMINISTRATOR_GROUP_ID = 3;

    //Shiro用户认证
    @Override
    public ResultDO<Void> shiroAuthentication(long userId) {
        // 参数检验
        if (userId <= 0) {
            LOG.error("shiro authentication user is null, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        // 1.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            LOG.error("shiro authentication user number error, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        // 2.封装用户数据
        UserDO userDO = userDAO.getUserDOById(userId);
        if (userDO == null) {
            LOG.error("shiro authentication get user by id is null, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userDO.getNumber(), userDO.getPassword());
        // 3.执行登录方法
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            // 登录失败：用户名不存在
            LOG.error("shiro authentication user number error, parameter illegal, userId={}", userId, e);
            return new ResultDO<Void>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER, null);
        } catch (IncorrectCredentialsException e) {
            // 登录失败：密码错误
            LOG.error("shiro authentication user password error, userId={}", userId, e);
            return new ResultDO<Void>(false, ResultCode.PASSWORD_ERROR, ResultCode.MSG_PASSWORD_ERROR, null);
        }
        LOG.info("shiro authentication success, userId={}", userId);
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    // 注册初始化用户权限
    @Override
    public ResultDO<Void> initPermissionUserDOsByUserDO(long userId) {
        // 参数检验
        if (userId <= 0) {
            LOG.error("init permissionUserDOs user is null, parameter illegal, userId={}", userId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            UserDO user = userDAO.getUserDOById(userId);
            if (user == null) {
                LOG.error(
                    "initPermissionUserDOsByUserDO fail, the number of userDO can not find in database, parameter illegal, userId={}",
                    userId);
                return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            // 判断是否赋权
            List<Long> permissionIdList = permissionUserDAO.getPermissionIdByUserId(userId);
            // 1.若该用户已初始化权限
            if (permissionIdList.size() > 0) {
                return new ResultDO<Void>(true, ResultCode.NO_NEED_TO_INIT_PERMISSION,
                    ResultCode.MSG_NO_NEED_TO_INIT_PERMISSION);
            }
            // 2.若该用户未初始化权限
            long type = user.getType();
            long permissionGroupId = type;
            List<Long> permissionIdlist =
                permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(permissionGroupId);
            if (permissionIdlist == null) {
                LOG.error("permissionIdlist is null get permissions by userDO error, parameter illegal, userId={}",
                    userId);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                    ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
            }
            for (int i = 0; i < permissionIdlist.size(); i++) {
                Long permissionId = permissionIdlist.get(i);
                PermissionUserDO permissionUserDO = new PermissionUserDO();
                permissionUserDO.setUserId(userId);
                permissionUserDO.setPermissionId(permissionId);
                permissionUserDAO.insert(permissionUserDO);
            }
        } catch (Exception e) {
            LOG.error("add permissionUserDO By userDO error, userId={}", userId, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    // 登陆初始化用户权限
    @Override
    public ResultDO<List<String>> getResourceOfPermissionsByUserId(long userId) {
        // 参数检验
        if (userId <= 0) {
            LOG.error("userId error, get resource of permissions error, parameter illegal, userId={}", userId);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        List<String> permissions = new ArrayList<String>();
        try {
            ResultDO<List<String>> resultDO = UserPermissionCache.getPermissionListByUserId(userId);
            if (resultDO.isSuccess()) {
                permissions = resultDO.getModule();
            } else {
                List<Long> permissionIdlist = permissionUserDAO.getPermissionIdByUserId(userId);
                if (permissionIdlist == null) {
                    LOG.error("permissionIdlist is null get permissions by userDO error, parameter illegal, userId={}",
                        userId);
                    return new ResultDO<List<String>>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                        ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
                }
                for (int i = 0; i < permissionIdlist.size(); i++) {
                    long permid = permissionIdlist.get(i);
                    PermissionDO permissionDO = permissionDAO.getPermissionDOById(permid);
                    if (permissionDO == null) {
                        LOG.error("permissionDO is null get permissions by userDO error, parameter illegal, userId={}",
                            userId);
                        return new ResultDO<List<String>>(false, ResultCode.NO_SUCH_PERMISSION,
                            ResultCode.MSG_NO_SUCH_PERMISSION);
                    }
                    permissions.add(permissionDO.getResource());
                }
                ResultDO<Void> addResultDO = UserPermissionCache.addPermissionList(userId, permissions);
                if (addResultDO.isSuccess() == false) {
                    LOG.error("add permission fail, resultDO={}, userId={}, permissions={}", addResultDO, userId,
                        permissions);
                }
            }
        } catch (Exception e) {
            LOG.error("get resource of permissions by userDO error, userId={}", userId, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissions);
    }

    //通过userDO得到其拥有的所有权限的resource
    @Override
    public ResultDO<List<PermissionDO>> showPermissions(long userId) {
        // 参数检验
        if (userId <= 0) {
            LOG.error("userId error, get resource of permissions error, parameter illegal, userId={}", userId);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID);
        }
        List<PermissionDO> permissions;
        try {
            permissions = new ArrayList<PermissionDO>();
            List<Long> permissionIdlist = permissionUserDAO.getPermissionIdByUserId(userId);
            if (permissionIdlist == null) {
                LOG.error("permissionIdlist is null get permissions by userDO error, parameter illegal, userId={}",
                    userId);
                return new ResultDO<List<PermissionDO>>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                    ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
            }
            for (int i = 0; i < permissionIdlist.size(); i++) {
                long permid = permissionIdlist.get(i);
                PermissionDO permissionDO = permissionDAO.getPermissionDOById(permid);
                if (permissionDO == null) {
                    LOG.error("permissionDO is null, get permissions by userDO error, parameter illegal, userId={}",
                        userId);
                    return new ResultDO<List<PermissionDO>>(false, ResultCode.NO_SUCH_PERMISSION,
                        ResultCode.MSG_NO_SUCH_PERMISSION);
                }
                permissions.add(permissionDO);
            }
        } catch (Exception e) {
            LOG.error("shiro authentication get permissions by userDO error, userId={}", userId, e);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<PermissionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissions);
    }

    //展示所有的权限
    @Override
    public ResultDO<List<PermissionDO>> showAllPermissions() {
        List<PermissionDO> permissions;
        try {
            permissions = new ArrayList<PermissionDO>();
            permissions = permissionDAO.showAllPermissions();
        } catch (Exception e) {
            LOG.error("show all permissions error", e);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<PermissionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissions);
    }

    // 添加单个权限
    @Override
    public ResultDO<Void> addPermission(String userNumber, String permissionName) {
        // 参数检验
        if (StringUtils.isBlank(userNumber) || StringUtils.isBlank(permissionName)) {
            LOG.error(
                "userNumber or permissionName is null, addPermission error, parameter illegal, userNumber={}, permissionName={}",
                userNumber, permissionName);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            UserDO userDO = userDAO.getUserDOByNumber(userNumber);
            if (userDO == null) {
                LOG.error("userDO is null, get userDO by number error, parameter illegal, userDO={}, userNumber={}",
                    userDO, userNumber);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            long userId = userDO.getId();
            PermissionDO permissionDO = permissionDAO.getPermissionDOByName(permissionName);
            if (permissionDO == null) {
                LOG.error(
                    "permissionDO is null, get userDO by number error, parameter illegal, permissionDO={} permissionName={}",
                    permissionDO, permissionName);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_PERMISSION, ResultCode.MSG_NO_SUCH_PERMISSION);
            }
            long permissionId = permissionDO.getId();
            // 判断赋予的权限是否是管理员权限组中的权限(管理员权限组中有的权限不可赋予其他角色)
            long adminPermissionGroupId = permissionGroupDAO.getPermissionGroupIdByName(ADMINISTRATOR_GROUP_NAME);
            List<Long> permissionIdlist =
                permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(adminPermissionGroupId);
            if (permissionIdlist == null) {
                LOG.error("Admin permissionGroup is null, parameter illegal, userNumber={}, permissionName={}",
                    userNumber, permissionName);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                    ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
            }
            for (int i = 0; i < permissionIdlist.size(); i++) {
                Long permissionIdTemp = permissionIdlist.get(i);
                if (permissionIdTemp == permissionId) {// 若该权限是管理员权限组中有的权限
                    LOG.error(
                        "Admin permissionGroup is null, parameter illegal, userNumber={}, permissionName={}, permissionId={}",
                        userNumber, permissionName, permissionId);
                    return new ResultDO<Void>(false, ResultCode.PERMISSION_WITHOUT_OPERATION,
                        ResultCode.MSG_PERMISSION_WITHOUT_OPERATION);
                }
            }
            // 判断该条权限是否有重复添加
            PermissionUserDO permissionUserDOTemp = permissionUserDAO.getPermissionUserDOIdByBothId(userId,
                permissionId);
            if (permissionUserDOTemp != null) {
                LOG.error("permission is repetitive, add permission error, userNumber={}, permissionName={}",
                    userNumber, permissionName);
                return new ResultDO<Void>(false, ResultCode.PERMISSION_REPETITION,
                    ResultCode.MSG_PERMISSION_REPETITION);
            }
            // 若无重复，则添加该权限
            PermissionUserDO permissionUserDO = new PermissionUserDO();
            permissionUserDO.setUserId(userId);
            permissionUserDO.setPermissionId(permissionId);
            permissionUserDAO.insert(permissionUserDO);
            // 清除缓存
            ResultDO<Void> deleteResultDO = UserPermissionCache.deletePermissionListByUserId(userId);
            if (deleteResultDO.isSuccess() == false) {
                LOG.error("add permission by userId fail, resultDO={}, userId={}", deleteResultDO, userId);
            }
        } catch (Exception e) {
            LOG.error("delete permission by userId error, userNumber={}, permissionName={}", userNumber, permissionName,
                e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    //删除单个权限
    @Override
    public ResultDO<Void> deletePermission(String userNumber, String permissionName) {
        if (StringUtils.isBlank(userNumber) || StringUtils.isBlank(permissionName)) {
            LOG.error(
                "userNumber or permissionName is null, addPermission error, parameter illegal, userNumber={}, permissionName={}",
                userNumber, permissionName);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            UserDO userDO = userDAO.getUserDOByNumber(userNumber);
            if (userDO == null) {
                LOG.error("userDO is null, get userDO by number error, parameter illegal, userDO={}, userNumber={}",
                    userDO, userNumber);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            long userId = userDO.getId();
            PermissionDO permissionDO = permissionDAO.getPermissionDOByName(permissionName);
            if (permissionDO == null) {
                LOG.error(
                    "permissionDO is null, get userDO by number error, parameter illegal, permissionDO={} permissionName={}",
                    permissionDO, permissionName);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_PERMISSION, ResultCode.MSG_NO_SUCH_PERMISSION);
            }
            long permissionId = permissionDO.getId();
            // 判断删除的权限是否是管理员权限组中的权限(管理员权限组中有的权限不可被删除)
            long adminPermissionGroupId = permissionGroupDAO.getPermissionGroupIdByName(ADMINISTRATOR_GROUP_NAME);
            List<Long> permissionIdlist =
                permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(adminPermissionGroupId);
            if (permissionIdlist == null) {
                LOG.error("Admin permissionGroup is null, parameter illegal, userNumber={}, permissionName={}",
                    userNumber, permissionName);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                    ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
            }
            for (int i = 0; i < permissionIdlist.size(); i++) {
                Long permissionIdTemp = permissionIdlist.get(i);
                if (permissionIdTemp == permissionId) {// 若该权限是管理员权限组中有的权限
                    LOG.error(
                        "Admin permissionGroup is null, parameter illegal, userNumber={}, permissionName={}, permissionId={}",
                        userNumber, permissionName, permissionId);
                    return new ResultDO<Void>(false, ResultCode.PERMISSION_WITHOUT_OPERATION,
                        ResultCode.MSG_PERMISSION_WITHOUT_OPERATION);
                }
            }
            // 判断该条权限记录是否存在
            PermissionUserDO permissionUserDOTemp = permissionUserDAO.getPermissionUserDOIdByBothId(userId,
                permissionId);
            if (permissionUserDOTemp == null) {
                LOG.error("no such authorization record, delete permission error, userNumber={}, permissionName={}",
                    userNumber, permissionName);
                return new ResultDO<Void>(false, ResultCode.NO_SUCH_AUTHORIZATION_RECORD,
                    ResultCode.MSG_NO_SUCH_AUTHORIZATION_RECORD);
            }
            // 若存在，则删除该权限
            permissionUserDAO.deleteById(permissionUserDOTemp.getId());
            // 清除缓存
            ResultDO<Void> deleteResultDO = UserPermissionCache.deletePermissionListByUserId(userId);
            if (deleteResultDO.isSuccess() == false) {
                LOG.error("add permission by userId fail, resultDO={}, userId={}", deleteResultDO, userId);
            }
        } catch (Exception e) {
            LOG.error("add permission error, userNumber={}, permissionName={}", userNumber, permissionName, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    //展示用户拥有的权限
    @Override
    public ResultDO<List<PermissionDO>> showPermissionsHave(String userNumber) {
        // 参数检验
        if (StringUtils.isBlank(userNumber)) {
            LOG.error("userId error, get resource of permissions error, parameter illegal, userNumber={}", userNumber);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID);
        }
        List<PermissionDO> permissions;
        try {
            UserDO userDO = userDAO.getUserDOByNumber(userNumber);
            if (userDO == null) {
                LOG.error("userDO is null, get userId by number error, parameter illegal, userDO={}, userNumber={}",
                    userDO, userNumber);
                return new ResultDO<List<PermissionDO>>(false, ResultCode.NO_SUCH_USER, ResultCode.MSG_NO_SUCH_USER);
            }
            long userId = userDO.getId();
            permissions = new ArrayList<PermissionDO>();
            List<Long> permissionIdlist = permissionUserDAO.getPermissionIdByUserId(userId);
            if (permissionIdlist == null) {
                LOG.error("permissionIdlist is null get permissions by userNumber error, parameter illegal, userId={}",
                    userId);
                return new ResultDO<List<PermissionDO>>(false, ResultCode.NO_SUCH_PERMISSION_GROUNP,
                    ResultCode.MSG_NO_SUCH_PERMISSION_GROUNP);
            }
            for (int i = 0; i < permissionIdlist.size(); i++) {
                long permid = permissionIdlist.get(i);
                PermissionDO permissionDO = permissionDAO.getPermissionDOById(permid);
                if (permissionDO == null) {
                    LOG.error("permissionDO is null, get permissions by userNumber error, parameter illegal, userId={}",
                        userId);
                    return new ResultDO<List<PermissionDO>>(false, ResultCode.NO_SUCH_PERMISSION,
                        ResultCode.MSG_NO_SUCH_PERMISSION);
                }
                permissions.add(permissionDO);
            }
        } catch (Exception e) {
            LOG.error("shiro authentication get permissions by userNumber error, userNumber={}", userNumber, e);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<PermissionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissions);
    }

    //展示所有permissionGroup
    @Override
    public ResultDO<List<PermissionGroupDO>> showAllPermissionGroup() {
        List<PermissionGroupDO> permissionGroups = new ArrayList<PermissionGroupDO>();
        try {
            permissionGroups = permissionGroupDAO.showALLPermissionGroups();
        } catch (Exception e) {
            LOG.error("shiro authentication showAllPermissionGroup error", e);
            return new ResultDO<List<PermissionGroupDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<PermissionGroupDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            permissionGroups);
    }

    //增加单个permissionGroup
    @Override
    public ResultDO<Void> addPermissionGroup(String permissionGroupName, List<Long> permissionIds) {
        // 参数检验
        if (StringUtils.isBlank(permissionGroupName) || permissionIds.size() == 0) {
            LOG.error("addPermissionGroup error, parameter illegal, permissionGroupName={}, permissionIds={}",
                permissionGroupName, permissionIds);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 添加角色组
            PermissionGroupDO permissionGroupDO = new PermissionGroupDO();
            permissionGroupDO.setName(permissionGroupName);
            permissionGroupDAO.insert(permissionGroupDO);
            // 获得角色组id
            long permissionGroupId = permissionGroupDAO.getPermissionGroupIdByName(permissionGroupName);
            // 添加权限
            PermissionGroupPermissionDO permissionGroupPermissionDO = new PermissionGroupPermissionDO();
            for (int i = 0; i < permissionIds.size(); i++) {
                permissionGroupPermissionDO.setPermissionGroupId(permissionGroupId);
                permissionGroupPermissionDO.setPermissionId(permissionIds.get(i));
                permissionGroupPermissionDAO.insert(permissionGroupPermissionDO);
            }
        } catch (Exception e) {
            LOG.error("shiro authentication addPermissionGroup error, permissionGroupName={}, permissionIds={}",
                permissionGroupName, permissionIds, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    //根据permissionGroupId删除permissionGroup
    @Override
    public ResultDO<Void> delPermissionGroupByPermissionGroupId(Long permissionGroupId) {
        // 参数检验
        if (permissionGroupId == null) {
            LOG.error("delPermissionGroup error, parameter illegal, permissionGroupId={}", permissionGroupId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (permissionGroupId == TEACHER_GROUP_ID || permissionGroupId == STUDENT_GROUP_ID
            || permissionGroupId == ADMINISTRATOR_GROUP_ID) {
            return new ResultDO<Void>(false, ResultCode.PERMISSION_GROUP_WITHOUT_OPERATION,
                ResultCode.MSG_PERMISSION_GROUP_WITHOUT_OPERATION);// 1034
        }
        try {
            // 删除permissionGroup中的权限
            permissionGroupPermissionDAO.deletePermissionsByPermissionGroupId(permissionGroupId);
            // 删除permissionGroup
            permissionGroupDAO.deleteById(permissionGroupId);
        } catch (Exception e) {
            LOG.error("shiro authentication get permissions by userNumber error, permissionGroupId={}",
                permissionGroupId, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    //根据permissionGroupId修改其拥有的所有权限
    @Override
    public ResultDO<Void> modifyPermissionGroup(String permissionGroupName, Long permissionGroupId,
                                                List<Long> permissionIds) {
        // 参数检验
        if (StringUtils.isBlank(permissionGroupName) || permissionIds.size() == 0) {
            LOG.error("addPermissionGroup error, parameter illegal, permissionGroupName={}, permissionIds={}",
                permissionGroupName, permissionIds);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (permissionGroupId == TEACHER_GROUP_ID || permissionGroupId == STUDENT_GROUP_ID
            || permissionGroupId == ADMINISTRATOR_GROUP_ID) {
            return new ResultDO<Void>(false, ResultCode.PERMISSION_GROUP_WITHOUT_OPERATION,
                ResultCode.MSG_PERMISSION_GROUP_WITHOUT_OPERATION);
        }
        try {
            // 删除permissionGroup中的权限
            permissionGroupPermissionDAO.deletePermissionsByPermissionGroupId(permissionGroupId);
            // 删除permissionGroup
            permissionGroupDAO.deleteById(permissionGroupId);
            // 添加角色组
            PermissionGroupDO permissionGroupDO = new PermissionGroupDO();
            permissionGroupDO.setName(permissionGroupName);
            permissionGroupDAO.insert(permissionGroupDO);
            long newPermissionGroupId = permissionGroupDAO.getPermissionGroupIdByName(permissionGroupName);
            // 添加权限
            PermissionGroupPermissionDO permissionGroupPermissionDO = new PermissionGroupPermissionDO();
            for (int i = 0; i < permissionIds.size(); i++) {
                permissionGroupPermissionDO.setPermissionGroupId(newPermissionGroupId);
                permissionGroupPermissionDO.setPermissionId(permissionIds.get(i));
                permissionGroupPermissionDAO.insert(permissionGroupPermissionDO);
            }
        } catch (Exception e) {
            LOG.error(
                "shiro authentication updatePermissionsByPermissionGroupId error, permissionGroupName={}, permissionIds={}",
                permissionGroupName, permissionIds, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }

    //根据permissionGroupId展示其已拥有的所有权限PermissionDO
    @Override
    public ResultDO<List<PermissionDO>> getPermissionsByPermissionGroupId(Long permissionGroupId) {
        // 参数检验
        if (permissionGroupId == null) {
            LOG.error("userId error, getPermissionsByPermissionGroupId error, parameter illegal, permissionGroupId={}",
                permissionGroupId);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID);
        }
        List<PermissionDO> permissionDOList;
        try {
            // 获得PermissionIds
            List<Long> permissionIds = new ArrayList<Long>();
            permissionDOList = new ArrayList<PermissionDO>();
            permissionIds = permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(permissionGroupId);
            // 获得permissionDOList
            for (int i = 0; i < permissionIds.size(); i++) {
                PermissionDO permissionDO = permissionDAO.getPermissionDOById(permissionIds.get(i));
                permissionDOList.add(permissionDO);
            }
        } catch (Exception e) {
            LOG.error("shiro authentication getPermissionsByPermissionGroupId error, permissionGroupId={}",
                permissionGroupId, e);
            return new ResultDO<List<PermissionDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<PermissionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissionDOList);
    }

    //根据permissionGroupId获得permissionGroupName
    @Override
    public ResultDO<String> getPermissionGroupNameByPermissionGroupId(Long permissionGroupId) {
        // 参数检验
        if (permissionGroupId == null) {
            LOG.error("userId error, getPermissionsByPermissionGroupId error, parameter illegal, permissionGroupId={}",
                permissionGroupId);
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        String permissionGroupName;
        try {
            permissionGroupName = permissionGroupDAO.getPermissionGroupNameById(permissionGroupId);
        } catch (Exception e) {
            LOG.error("shiro authentication getPermissionGroupNameByPermissionGroupId error, permissionGroupId={}",
                permissionGroupId, e);
            return new ResultDO<String>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
        return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissionGroupName);
    }

    //根据permissionGroupId展示其已拥有的所有PermissionIds
    @Override
    public ResultDO<List<Long>> getPermissionIdsByPermissionGroupId(Long permissionGroupId) {
        // 参数检验
        if (permissionGroupId == null) {
            LOG.error("userId error, getPermissionsByPermissionGroupId error, parameter illegal, permissionGroupId={}",
                permissionGroupId);
            return new ResultDO<List<Long>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        List<Long> permissionIds;
        try {
            permissionIds = permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(permissionGroupId);
        } catch (Exception e) {
            LOG.error("shiro authentication getPermissionIdsByPermissionGroupId error, permissionGroupId={}",
                permissionGroupId, e);
            return new ResultDO<List<Long>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
        return new ResultDO<List<Long>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, permissionIds);
    }

}
