package com.altersoftware.hotel.util;

import java.net.URL;

import org.springframework.util.ResourceUtils;

import com.altersoftware.hotel.checkIn.FaceIdCompere.GetUrlPic;
import com.altersoftware.hotel.checkIn.FaceIdCompere.MyFaceContract;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 22:34
 */
public class CheckIn {

    public static boolean checkIn(String url1, String url2) {

        try {
            URL img1 = new URL(url1);
            URL img2 = new URL(url2);
            GetUrlPic getUrlPic = new GetUrlPic();
            getUrlPic.geturlpic(img1, 1);
            getUrlPic.geturlpic(img2, 2);
            MyFaceContract myFaceContract = new MyFaceContract();
            String path = ResourceUtils.getURL("classpath:static").getPath();
            float contract = myFaceContract.contract(path + "1.jpg", path + "2.jpg");
            if (contract > 0.9) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
