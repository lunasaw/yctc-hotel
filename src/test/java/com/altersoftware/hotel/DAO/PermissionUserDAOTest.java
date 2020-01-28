package com.altersoftware.hotel.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altersoftware.hotel.dao.PermissionUserDAO;
import com.altersoftware.hotel.entity.PermissionUserDO;

/**
 * @author czy@win10
 * @date 2020/1/23 22:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionUserDAOTest {

    private static final long ID            = 2;
    private static final long USER_ID       = 10004;
    private static final long PERMISSION_ID = 2;

    @Resource
    private PermissionUserDAO permissionUserDAO;

    @Test
    public void aInster() {
        PermissionUserDO permissionUserDO = new PermissionUserDO();
        permissionUserDO.setId(ID);
        permissionUserDO.setUserId(USER_ID);
        permissionUserDO.setPermissionId(PERMISSION_ID);
        permissionUserDAO.insert(permissionUserDO);
    }

    @Test
    public void bGetById() {
        PermissionUserDO permissionUserDOById = permissionUserDAO.getPermissionUserDOById(ID);
        System.out.println(permissionUserDOById);
        Assert.assertNotNull(permissionUserDOById);
    }

    @Test
    public void cGetByUserId() {
        List<Long> permissionIdByUserId = permissionUserDAO.getPermissionIdByUserId(USER_ID);
        System.out.println(permissionIdByUserId);
        Assert.assertNotNull(permissionIdByUserId);
    }

    @Test
    public void dUpdate() {
        PermissionUserDO permissionUserDOById = permissionUserDAO.getPermissionUserDOById(ID);
        int update = permissionUserDAO.update(permissionUserDOById);
        System.out.println(update);
        Assert.assertEquals(1, update);
    }

    @Test
    public void eDelete() {
        permissionUserDAO.deleteById(ID);
        PermissionUserDO permissionUserDOById = permissionUserDAO.getPermissionUserDOById(ID);
        System.out.println(permissionUserDOById);
        Assert.assertNull(permissionUserDOById);
    }

    @Test
    public void fDeleteByuser() {
        permissionUserDAO.deleteByUserId(USER_ID);
        List<Long> permissionIdByUserId = permissionUserDAO.getPermissionIdByUserId(USER_ID);
        System.out.println(permissionIdByUserId);
        Assert.assertEquals(0, permissionIdByUserId.size());
    }
}
