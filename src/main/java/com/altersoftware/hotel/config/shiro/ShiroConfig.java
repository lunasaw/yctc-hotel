package com.altersoftware.hotel.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.altersoftware.hotel.constant.RestPath;
import com.altersoftware.hotel.constant.StaticPath;
import com.altersoftware.hotel.constant.TemplatePath;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;


/**
 * Shiro的配置类
 *
 * @author wlt
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器 常用的过滤器：
         * anon: 无需认证（登录）可以访问
         * authc:必须认证才可以访问
         * user:如果使用
         * rememberMe的功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role: 该资源必须得到角色权限才可以访问
         */
        // 授权过滤器
        // 注：当前授权拦截后，shiro会自动跳转到未授权页面
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        // 无需登录的页面
        {
            filterMap.put("/" + StaticPath.COMMON_ERROR, "anon");
            // 统一错误页
            filterMap.put("/" + TemplatePath.USER_SIGN_IN, "anon");
            // 登录
            filterMap.put("/" + TemplatePath.USER_SIGNUP, "anon");
            // 注册
            filterMap.put("/" + TemplatePath.USER_SIGN_UP_SUCCESS, "anon");
            // 注册成功
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORDB_START, "anon");
            // 找密界面
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_BY_PHONE, "anon");
            // 手机找密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_BY_MAIL, "anon");
            // 邮箱找密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORDB, "anon");
            // 找密步骤三改密
            filterMap.put("/" + TemplatePath.USER_RETRIEVE_PASSWORD_SUCCESS, "anon");
            // 找密成功
        }
        // 需要登录的页面
        {

            filterMap.put("/" + TemplatePath.USER_MY_INFORMATION, "authc");
            // 我的信息页
            filterMap.put("/" + TemplatePath.USER_SIGN_IN_SUCCESS, "authc");
            // 登陆成功
            filterMap.put("/" + TemplatePath.USER_MANAGE, "authc");
            // 后台管理页
            filterMap.put("/" + TemplatePath.USER_UPDATE_PASSWORD, "authc");
            // 修改密码
            filterMap.put("/" + TemplatePath.USER_UPDATE_MAIL, "authc");
            // 修改邮箱
            filterMap.put("/" + TemplatePath.USER_MAIL_AUTHENTICATION, "authc");
            // 修改邮箱身份验证
            filterMap.put("/" + TemplatePath.USER_UPDATE_MOBILE, "authc");
            // 修改手机
            filterMap.put("/" + TemplatePath.USER_MOBILE_AUTHENTICATION, "authc");
            // 修改手机身份验证
            filterMap.put("/" + TemplatePath.USER_SIGN_OUT, "authc");
            // 注销登陆
            filterMap.put("/" + TemplatePath.USER_SIGN_OUT_SUCCESS, "authc");
            // 注销成功
            filterMap.put("/" + TemplatePath.FLOOR, "authc");
            //楼层信息
        }
        // 需要资源权限的页面   授权过滤器
        {

            // 管理员-权限管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT, "perms[admin:roleManagement]");
            // 管理员-角色管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_ADD, "perms[admin:roleManagement]");
            // 管理员-角色管理-增加角色
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT_MODIFY, "perms[admin:roleManagement]");
            // 管理员-角色管理-修改角色

     }
        // rest权限设置
        // 1.用户功能
        filterMap.put(RestPath.SIGN_IN, "anon");
        // 登录
        filterMap.put(RestPath.GET_USER_INFORMATION_BY_ID, "anon");
        // 获得用户信息
        // 2.邮件、短信的发送
        filterMap.put(RestPath.SEND_MAIL, "anon");
        // 发邮件验证码
        filterMap.put(RestPath.SEND_MAILFORUPDATEMAIL, "authc");
        // 发邮件验证码(修改邮箱时用)
        filterMap.put(RestPath.SEND_SMS, "anon");
        // 发短信验证码
        filterMap.put(RestPath.SEND_SMSFORUPDATEMOBILE, "authc");
        // 发短信验证码(修改手机时用)
        // 3.权限管理
        filterMap.put(RestPath.ADD_PERMISSION, "perms[admin:authorityManagement]");
        // 增加一条权限
        filterMap.put(RestPath.DELETE_PERMISSION, "perms[admin:authorityManagement]");
        // 删除一条权限

        // 8.消息系统
        filterMap.put(RestPath.SHOW_NEWS, "authc");
        // 获得用户消息列表
        filterMap.put(RestPath.TURN_TO_READED, "authc");
        // 将某条信息变更为已读
        filterMap.put(RestPath.TURN_TO_UNREAD, "authc");
        // 将某条信息变更为未读
        filterMap.put(RestPath.TURN_ALL_TO_READED, "authc");
        // 全部变更为已读
        filterMap.put(RestPath.TURN_ALL_TO_UNREAD, "authc");
        // 全部变更为未读
        filterMap.put(RestPath.SEND_NEWS_TO_USER_LIST, "authc");
        // 给用户推送消息


        // 设置自定义的登录页面
        shiroFilterFactoryBean.setLoginUrl("/" + TemplatePath.USER_SIGN_IN);

        // 设置自定义的未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/manage/no-authorization");

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     *
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     *
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * 配合ShiroDialect，用于thymeleaf和shiro标签配合使用
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
