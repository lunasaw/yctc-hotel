package com.altersoftware.hotel.util;

import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.altersoftware.hotel.checkIn.faceIdCompere.GetUrlPic;
import com.altersoftware.hotel.checkIn.faceIdCompere.MyFaceContract;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 19:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Face {

    @Test
    public void Test() throws Exception {
        GetUrlPic getUrlPic = new GetUrlPic();
        URL url = new URL("https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovph1iej20j60r7wfm.jpg");
        String geturlpic = getUrlPic.geturlpic(url, 1);
        url = new URL("https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovpi0mmj20j60j6q4f.jpg");
        String geturlpic1 = getUrlPic.geturlpic(url, 2);
        MyFaceContract myFaceContract = new MyFaceContract();
        String path = ResourceUtils.getURL("classpath:static").getPath();

        System.out.println(myFaceContract.contract(path + "1.jpg", path + "2.jpg"));
    }

    @Test
    public void checkIn() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:static").getPath();
        System.out.println(path);
        boolean b = CheckIn.checkIn("https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovph1iej20j60r7wfm.jpg",
            "https://wx2.sinaimg.cn/mw690/6ff51fefly1gc2ovpi0mmj20j60j6q4f.jpg");
        System.out.println(b);
    }
}
