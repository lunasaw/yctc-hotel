package com.altersoftware.hotel.DAO;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.constant.entity.user.UserType;
import com.altersoftware.hotel.dao.UserDAO;
import com.altersoftware.hotel.entity.UserDO;

/**
 * @author czy@win10
 * @date 2020/1/22 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {

    private static final long   ID       = 10003;
    private static final String NAME     = "王小明";
    private static final String IDCARD   = "95001";
    private static final Double ACCOUNT  = 15696.5;
    private static final String EMAIL    = "15696756583@qq.com";
    private static final String MOBILE   = "15696756583";
    private static final String SEX      = "男";
    private static final int    AGE      = 21;
    private static final String PASSWORD =
        "5sxaaaArqNy97T9QIPL2yoQifDHiwWagRT9Zj6OYsTB/EyRwCIks4nrpwGlO2+t7y1VS4BmxpbKPpp+e4yJF3g==";
    private static final String FACEID   =
        "https://timgsa.baidu.com/ti11mg?image11&quality=80&size=bcom.cn%2Ft_s640x2000%2Fg5%2FM00%2F07%2F05%2FChMkJlfqgqiIYwKeAAXtkO-CXDoAAWaTQMkqykABe2o998.jpg";

    @Resource
    private UserDAO             userDAO;

    @Test
    public void aInster() {
        UserDO userDO = new UserDO();
        userDO.setId(ID);
        userDO.setName(NAME);
        userDO.setContactPhone(MOBILE);
        userDO.setPassword(PASSWORD);
        userDO.setSex(SEX);
        userDO.setType(UserType.MANAGEMENT);
        userDO.setIdCardNumber(IDCARD);
        userDO.setAge(AGE);
        userDO.setEmail(EMAIL);
        userDO.setFaceId(FACEID);
        userDO.setAccount(ACCOUNT);
        userDAO.insert(userDO);
        Assert.assertNotNull(userDO.getId());
    }

    @Test
    public void bGetCuostmerDOById() {
        UserDO userDO = userDAO.getUserDOById(ID);
        System.out.println(userDO);
        Assert.assertNotNull(userDO);
    }

    @Test
    public void cUpdate() {
        UserDO userDOById = userDAO.getUserDOById(ID);
        userDOById.setAge(userDOById.getAge() + 1);
        userDAO.update(userDOById);
        UserDO doById = userDAO.getUserDOById(ID);
        Assert.assertEquals(userDOById, doById);
    }

    @Test
    public void dGetCustomerByEmail() {
        UserDO userDOByEmail = userDAO.getUserDOByMail(EMAIL);
        System.out.println(userDOByEmail);
        Assert.assertNotNull(userDOByEmail);
    }

    @Test
    public void eGetCustomerByMobile() {
        UserDO userDOByMobile = userDAO.getUserDOByPhone(MOBILE);
        System.out.println(userDOByMobile);
        Assert.assertNotNull(userDOByMobile);
    }

    @Test
    public void fGetCustomerByMobileAndPassword() {
        UserDO UserDAOUserDOByMobileAndPassword =
            userDAO.getUserDOByMobileAndPassword(MOBILE, PASSWORD);
        System.out.println(UserDAOUserDOByMobileAndPassword);
        Assert.assertNotNull(UserDAOUserDOByMobileAndPassword);

    }

    @Test
    public void gGetCustomerByEmailAndPassword() {
        UserDO UserDOByEmailAndPassword = userDAO.getUserDOByEmailAndPassword(EMAIL, PASSWORD);
        System.out.println(UserDOByEmailAndPassword);
        Assert.assertNotNull(UserDOByEmailAndPassword);
    }

    @Test
    public void hGetCustomerByFaceId() {
        UserDO UserDOByfaceId = userDAO.getUserDOByfaceId(FACEID);
        System.out.println(UserDOByfaceId);
        Assert.assertNotNull(UserDOByfaceId);
    }

    @Test
    public void iDelete() {
        userDAO.deleteById(ID);
        UserDO UserDOById = userDAO.getUserDOById(ID);
        System.out.println(UserDOById);
        Assert.assertNull(UserDOById);
    }
}
