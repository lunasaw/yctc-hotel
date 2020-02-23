package com.altersoftware.hotel.util;

import java.io.FileNotFoundException;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.altersoftware.hotel.checkIn.CheckInController;
import com.altersoftware.hotel.entity.ResultDO;
import com.altersoftware.hotel.entity.UserDO;
import com.altersoftware.hotel.vo.BaseVO;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 19:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Face {

    @Resource
    private CheckInController checkInController;


    @Test
    public void atest() throws Exception {
        String path = ResourceUtils.getURL("classpath:static/").getPath();
        String s = Base64Utils.GetImageStr(path + "10019.jpg");
        // System.out.println(s);
        BaseVO baseVO = new BaseVO();
        baseVO.setId64(s);
        baseVO.setPhone("15696756582");
//	    baseVO.setCustomerId(10014);
        ResultDO<UserDO> userDOResultDO = checkInController.checkIdCard(baseVO);
        System.out.println(userDOResultDO);
    }



    @Test
    public void bface() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:static/").getPath();
        String s = Base64Utils.GetImageStr(path + "body.jpg");
        ResultDO<Void> voidResultDO = checkInController.checkFace(s, 10014);
        System.out.println(voidResultDO.isSuccess());
    }

    @Test
    public void live() throws Exception {
        System.out.println(FaceIR.scanVivo());
    }
}
