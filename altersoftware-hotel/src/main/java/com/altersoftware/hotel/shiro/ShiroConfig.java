package com.altersoftware.hotel.shiro;

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

        }
        // 需要资源权限的页面   授权过滤器
        {
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_MANAGEMENT, "perms[admin:authorityManagement]");
            // 管理员-权限管理
            filterMap.put("/" + TemplatePath.EDUCATION_AUTHORITY_ROLE_MANAGEMENT, "perms[admin:roleManagement]");
            // 管理员-角色管理

            filterMap.put("/" + TemplatePath.FLOOR, "perms[staff:FireFigure]");
            //楼层信息
            filterMap.put("/" + TemplatePath.CUSTOMER_INFO, "perms[satff:UserInformation]");
            //客户信息页面
            filterMap.put("/" + TemplatePath.ROOMS, "perms[customer:RoomReservation]");
            //房间预订
            filterMap.put("/" + TemplatePath.MENUS, "perms[customer:MealReservation]");
            //租赁页面
            filterMap.put("/" + TemplatePath.LEASE, "perms[customer:RentalOfGoods]");
            //管理员租赁页面
            filterMap.put("/" + TemplatePath.LEASE_ADMIN, "perms[staff:LeaseSetUp]");
            //菜品预订
            filterMap.put("/" + TemplatePath.ORDER_BY_CUSTOMER, "perms[customer:GuesRoomHistory]");
            //客户客房订单
            filterMap.put("/" + TemplatePath.RECORD_BY_CUSTOMER, "perms[customer:FoodHistoryOrder]");
            //客户菜品订单
            filterMap.put("/" + TemplatePath.GOODS_STATE_SET, "perms[customer:DeviceStatus]");
            //设置设备状态
            filterMap.put("/" + TemplatePath.GOAWAY, "perms[customer:CheckOutOnline]");
            //在线退房
            filterMap.put("/" + TemplatePath.ORDER_BY_ADMIN, "perms[staff:RoomOrder]");
	        //管理员客房订单
            filterMap.put("/" + TemplatePath.MENU_ADMIN, "perms[staff:RoomOrder]");
            //菜品配送订单
            filterMap.put("/" + TemplatePath.RECORD_BY_ADMIN, "perms[staff:OrderForFood]");
            //管理员菜品订单
            filterMap.put("/" + TemplatePath.ROOM_ADMIN, "perms[staff:RoomSettings]");
            //房间信息
            filterMap.put("/" + TemplatePath.ROOM_TYPE_ADMIN, "perms[staff:RoomTypeSettings]");
            //房间类别信息
            filterMap.put("/" + TemplatePath.ROOM_GOODS, "perms[staff:ItemStatusSettings]");
            //管理员房间状态设置
            filterMap.put("/" + TemplatePath.GOODS, "perms[staff:ItemSetup]");
            //物品设置
            filterMap.put("/" + TemplatePath.MENUS_ADMIN, "perms[staff:DishesSetUp]");
            //菜品设置
            filterMap.put("/" + TemplatePath.DEPARTMENT, "perms[staff:DepartmentalDistribution]");
            //部门分配
            filterMap.put("/" + TemplatePath.STAFF_INFO, "perms[staff:EmployeeInformation]");
            //员工信息
            filterMap.put("/" + TemplatePath.VIP_GRADE_SHOW, "perms[customer:ViewVipGrade]");
            //客户会员权益
            filterMap.put("/" + TemplatePath.VIP_INFO, "perms[staff:MembershipSetup]");
            //会员信息设置
            filterMap.put("/" + TemplatePath.VIP_GRADE_INFO, "perms[staff:MembershipVipGradeSetup]");
            //会员信息设置

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

        //1物品状态管理
        filterMap.put(RestPath.RETURN_BYROOMNUM_ANDNAME, "authc");
        // 通过房间号和物品名返回
        filterMap.put(RestPath.RETURN_BYROOMNUM, "authc");
        // 通过房间号返回物品状态
        filterMap.put(RestPath.RETURN_GOODSNAME, "authc");
        // 通过物品名返回物品状态
        filterMap.put(RestPath.RETURN_LIST, "authc");
        // 获取所有物品及状态
        filterMap.put(RestPath.DELET_GOODS_STATE, "perms[staff:ItemStatusSettings]");
        // 删除物品状态
        filterMap.put(RestPath.UPDATE_GOODS_STATE, "perms[staff:ItemStatusSettings]");
        // 修改物品状态
        filterMap.put(RestPath.ADD_GOODS_STATE, "perms[staff:ItemStatusSettings]");
        // 增加物品状态值
        filterMap.put(RestPath.UPDATE_ONE_STATE, "perms[staff:ItemStatusSettings]");
        // 更新物品状态值


        //2房间类别设置
        filterMap.put(RestPath.RETURN_BYROOMID, "authc");
        // 房间类别id查询房间类别信息
        filterMap.put(RestPath.GET_LIST, "authc");
        // 查询所有房间类别信息
        filterMap.put(RestPath.ADD_ROOMTYPE, "perms[staff:RoomTypeSettings]");
        // 增加一个房间类别
        filterMap.put(RestPath.UPDATE_ROOMTYPE, "perms[staff:RoomTypeSettings]");
        // 更新房间类别状态
        filterMap.put(RestPath.UPDATE_ROOMTYPE_PIC, "perms[staff:RoomTypeSettings]");
        // 更新房间照片
        filterMap.put(RestPath.DELETE_ROOMTYPE, "perms[staff:RoomTypeSettings]");
        // 删除指定房间类别数据
        filterMap.put(RestPath.DELETE_LIST_ROOMTYPE, "perms[staff:RoomTypeSettings]");
        // 删除多条记录

        //3房间信息设置
        filterMap.put(RestPath.RETURN_ROOMS_BYID, "authc");
        // 通过id获取房间信息
        filterMap.put(RestPath.GET_ROOM_LIST, "authc");
        // 显示所有房间信息
        filterMap.put(RestPath.RETURN_ROOMS_BYROOMNUM, "authc");
        // 按照房间号查找房间信息
        filterMap.put(RestPath.UPDATE_ROOMS, "perms[staff:RoomSettings]");
        // 更新房间信息
        filterMap.put(RestPath.ADD_ROOMS, "perms[staff:RoomSettings]");
        // 插入一个房间信息
        filterMap.put(RestPath.DELETE_ROOMS_BYID, "perms[staff:RoomSettings]");
        // id删除房间信息
        filterMap.put(RestPath.DELETE_ROOMS_BYIDLIST, "perms[staff:RoomSettings]");
        // 删除多条记录

        //4客户信息设置
        filterMap.put(RestPath.RETURN_CUSTOMER_BYNUMBER, "authc");
        // 会员号搜索客户/员工
        filterMap.put(RestPath.RETURN_CUSTOMER_BYCUSTOMERID, "authc");
        // 客户编号搜索客户
        filterMap.put(RestPath.RETURN_CLEANER_LIST, "authc");
        // 返回所有清洁部员工
        filterMap.put(RestPath.GET_ALL_CUSTOMERS, "authc");
        // 获取所有客户信息
        filterMap.put(RestPath.DELETE_CUSTOMER_BYID, "perms[satff:UserInformation]");
        // 删除指定客户信息
        filterMap.put(RestPath.DELETE_CUSTOMER_LIST, "perms[satff:UserInformation]");
        // 删除多条记录
        filterMap.put(RestPath.UPDATE_CUSTOMERS, "perms[satff:UserInformation]");
        // 修改客户信息

        //5员工信息设置
        filterMap.put(RestPath.GET_STAFF_LIST, "authc");
        // 获取所有员工信息
        filterMap.put(RestPath.GET_BY_DEPERTMENTID, "authc");
        // 获取通过部门号
        filterMap.put(RestPath.GET_STAFF_BYNUMBER, "authc");
        // 会员号搜索员工/员工
        filterMap.put(RestPath.DELETE_BYID, "perms[staff:EmployeeInformation]");
        // 删除指定员工信息
        filterMap.put(RestPath.DELETE_BYID_LIST, "perms[staff:EmployeeInformation]");
        // 删除多条记录
        filterMap.put(RestPath.UPDATE_STAFF, "perms[staff:EmployeeInformation]");
        // 修改员工信息
        filterMap.put(RestPath.UPDATE_STAFF_PIC, "perms[staff:EmployeeInformation]");
        // 修改员工照片信息


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
