package com.altersoftware.hotel;

import com.altersoftware.hotel.service.PermissionIService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Iszychen@win10
 * @date 2020/2/26 22:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test {

	@Resource
	PermissionIService permissionIService;

	@org.junit.Test
	public void aTest() {
		permissionIService.initPermissionUserDOsByUserDO(10047);
	}

}
