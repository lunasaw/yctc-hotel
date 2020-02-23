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

    // @Test
    // public void Test() throws Exception {
    // GetUrlPic getUrlPic = new GetUrlPic();
    // URL url = new URL("https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovph1iej20j60r7wfm.jpg");
    // String geturlpic = getUrlPic.geturlpic(url, 1);
    // url = new URL("https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovpi0mmj20j60j6q4f.jpg");
    // String geturlpic1 = getUrlPic.geturlpic(url, 2);
    // MyFaceContract myFaceContract = new MyFaceContract();
    // String path = ResourceUtils.getURL("classpath:static/").getPath();
    //
    // System.out.println(myFaceContract.contract(path + "body.jpg", path + "10013.jpg"));
    // }
    //
    // @Test
    // public void checkIn() throws FileNotFoundException {
    // String path = ResourceUtils.getURL("classpath:static/").getPath();
    // System.out.println(path);
    // boolean b = CheckIn.checkIn(10013);
    // System.out.println(b);
    // }

    @Test
    public void atest() throws Exception {
        String path = ResourceUtils.getURL("classpath:static/").getPath();
        String s = Base64Utils.GetImageStr(path + "10019.jpg");
        // System.out.println(s);
        BaseVO baseVO = new BaseVO();
        baseVO.setId64(s);
        baseVO.setCustomerId(10014);
        ResultDO<UserDO> userDOResultDO = checkInController.checkIdCard(baseVO);
        System.out.println(userDOResultDO);
    }

    @Test
    public void bface() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:static/").getPath();
        String s = Base64Utils.GetImageStr(path + "body.jpg");
        ResultDO<Void> voidResultDO = checkInController.checkFace(s, 10013);
        System.out.println(voidResultDO.isSuccess());
    }

    @Test
    public void live() throws Exception {
        System.out.println(FaceIR.scanVivo());
    }
}
