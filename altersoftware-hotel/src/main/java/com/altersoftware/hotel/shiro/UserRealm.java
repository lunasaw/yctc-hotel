package com.altersoftware.hotel.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.service.PermissionIService;
import com.altersoftware.hotel.service.UserIService;
import com.altersoftware.hotel.util.EnvUtil;


/**
 * 自定义的Realm
 *
 * @author wlt
 */
public class UserRealm extends AuthorizingRealm {

    private final static Logger LOG = LoggerFactory.getLogger("controllerLogger");
    /** 动态菜单渲染中 关键词or */
    private final static String OR_OPERATOR = " or ";
    /** 动态菜单渲染中 关键词and */
    private final static String AND_OPERATOR = " and ";
    /** 动态菜单渲染中 关键词not */
    private final static String NOT_OPERATOR = "not ";

    @Autowired
    private UserIService userService;
    @Autowired
    private PermissionIService permissionService;

    @Autowired
    private EnvUtil envUtil;

    /**
     * 执行授权逻辑
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 给资源进行授权
        long userId;
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject == null) {
                LOG.error("authorization subject is null, principalCollection={}, subject={}", principalCollection,
                    subject);
                return null;
            }
            userId = (long)subject.getPrincipal();
            if (userId <= 0) {
                LOG.error("authorization subject is null, subject={}, principalCollection={}", subject,
                    principalCollection);
                return null;
            }
        } catch (Exception e) {
            LOG.error("get userDO error, principalCollection={}", principalCollection, e);
            return null;
        }
        // 2.获得权限list
        List<String> permissions;
        try {
            ResultDO<List<String>> getPermissionsByUserDOResult =
                permissionService.getResourceOfPermissionsByUserId(userId);
            if (getPermissionsByUserDOResult.isSuccess() == false) {
                LOG.error("get permissions by userDO error, principalCollection={}, userId={}", principalCollection,
                    userId);
                return null;
            }
            permissions = getPermissionsByUserDOResult.getModule();
        } catch (Exception e) {
            LOG.error("get permissions error, principalCollection={}, userId={}", principalCollection, userId, e);
            return null;
        }

        // 3.添加资源的授权字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        // 日志数量太大，上线时关闭
        if (envUtil.isDaily()) {
            LOG.info("shiro authorization success, userId={}, principalCollection={}", userId, principalCollection);
        }
        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException {
        // 判断用户名和密码
        // 1.判断用户名
        UserDO userDO;
        try {
            UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
            if (token == null) {
                LOG.error("token is null, authenticationToken={}, token={}", authenticationToken, token);
                return null;
            }
            ResultDO<UserDO> getUserDOByNumberResultDO = userService.getUserDOByNumber(token.getUsername());
            if (getUserDOByNumberResultDO.isSuccess() == false) {
                // 用户名不存在
                return null; // shiro底层会抛出UnknowAccountException
            }
            userDO = getUserDOByNumberResultDO.getModule();
            if (userDO == null) {
                LOG.error("authentication userDO is null, authenticationToken={}, userDO={}", authenticationToken,
                    userDO);
                return null;
            }
        } catch (Exception e) {
            LOG.error("authentication error, authenticationToken={}", authenticationToken, e);
            return null;
        }
        // 2.判断密码
        LOG.info("shiro authentication success, authenticationToken={}, userDO={}", authenticationToken, userDO);
        return new SimpleAuthenticationInfo(userDO.getId(), userDO.getPassword(), "");
    }

    /**
     * 动态菜单渲染中支持or and关键词 不支持and or混用
     *
     * @param principals
     * @param permission
     * @return
     */
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        if (permission.contains(OR_OPERATOR)) {
            String[] permissions = permission.split(OR_OPERATOR);
            for (String orPermission : permissions) {
                if (isPermittedWithNotOperator(principals, orPermission)) {
                    return true;
                }
            }
            return false;
        } else if (permission.contains(AND_OPERATOR)) {
            String[] permissions = permission.split(AND_OPERATOR);
            for (String orPermission : permissions) {
                if (!isPermittedWithNotOperator(principals, orPermission)) {
                    return false;
                }
            }
            return true;
        } else {
            return isPermittedWithNotOperator(principals, permission);
        }
    }

    /**
     * 动态菜单渲染中支持not关键词
     *
     * @param principals
     * @param permission
     * @return
     */
    private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
        if (permission.startsWith(NOT_OPERATOR)) {
            return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
        } else {
            return super.isPermitted(principals, permission);
        }
    }
}
