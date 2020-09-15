package com.altersoftware.hotel.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONObject;
import com.altersoftware.hotel.checkIn.faceIdCompere.MyFaceContract;
import com.altersoftware.hotel.checkIn.tencentcloudapi.common.Credential;
import com.altersoftware.hotel.checkIn.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.altersoftware.hotel.checkIn.tencentcloudapi.common.profile.ClientProfile;
import com.altersoftware.hotel.checkIn.tencentcloudapi.common.profile.HttpProfile;
import com.altersoftware.hotel.checkIn.tencentcloudapi.ocr.v20181119.OcrClient;
import com.altersoftware.hotel.checkIn.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.altersoftware.hotel.checkIn.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import com.altersoftware.hotel.constant.ConstantHolder;

import sun.misc.BASE64Encoder;

/**
 * @author Iszychen@win10
 * @date 2020/2/21 22:34
 */
public class CheckIn {

    public static boolean checkIn(long customerId) {

        try {
            // URL img1 = new URL(url1);
            // URL img2 = new URL(url2);
            // GetUrlPic getUrlPic = new GetUrlPic();
            // getUrlPic.geturlpic(img1, 1);
            // getUrlPic.geturlpic(img2, 2);
            MyFaceContract myFaceContract = new MyFaceContract();
            String path = ResourceUtils.getURL("classpath:static/").getPath();
            File file = new File(path + customerId + ".jpg");
            boolean exists = file.exists();
            float contract = 0;
            if (exists == true) {
                contract = myFaceContract.contract(path + customerId + ".jpg", path + "tmp.jpg");
            }
            if (exists == false) {
                String psthWeb = ConstantHolder.FILE_UPLOAD + customerId + ".jpg";
                FileUtilsAlter.downloadHttpUrl(psthWeb, path, customerId + ".jpg");
                contract = myFaceContract.contract(path + customerId + ".jpg", path + "tmp.jpg");
            }
            if (contract > 0.6) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String calcAuthorization(String source, String secretId, String secretKey, String datetime)
        throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String signStr = "x-date: " + datetime + "\n" + "x-source: " + source;
        Mac mac = Mac.getInstance("HmacSHA1");
        Key sKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), mac.getAlgorithm());
        mac.init(sKey);
        byte[] hash = mac.doFinal(signStr.getBytes(StandardCharsets.UTF_8));
        String sig = new BASE64Encoder().encode(hash);

        String auth = "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"x-date x-source\", signature=\""
            + sig + "\"";
        return auth;
    }

    public static String urlencode(Map<?, ?> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                URLEncoder.encode(entry.getKey().toString(), "UTF-8"),
                URLEncoder.encode(entry.getValue().toString(), "UTF-8")));
        }
        return sb.toString();
    }

    public static boolean idEnsure(String name, String id)
        throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        // 云市场分配的密钥Id
        String secretId = "AKIDfdbmi33q187aooi6imaTSHpd14lf7x17umpm";
        // 云市场分配的密钥Key
        String secretKey = "2ak1uhjyXjLWMoZmS2C45o62JoKOBB7BD3Eu9ENM";
        String source = "market";

        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String datetime = sdf.format(cd.getTime());
        // 签名
        String auth = calcAuthorization(source, secretId, secretKey, datetime);
        // 请求方法
        String method = "GET";
        // 请求头
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Source", source);
        headers.put("X-Date", datetime);
        headers.put("Authorization", auth);

        // 查询参数
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("idcard", id);
        queryParams.put("name", name);
        // body参数
        Map<String, String> bodyParams = new HashMap<String, String>();

        // url参数拼接
        String url = "https://service-2n5qa8cl-1256140209.ap-shanghai.apigateway.myqcloud.com/release/eid/check";
        if (!queryParams.isEmpty()) {
            url += "?" + urlencode(queryParams);
        }

        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod(method);

            // request headers
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            // request body
            Map<String, Boolean> methods = new HashMap<>();
            methods.put("POST", true);
            methods.put("PUT", true);
            methods.put("PATCH", true);
            Boolean hasBody = methods.get(method);
            if (hasBody != null) {
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                conn.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                out.writeBytes(urlencode(bodyParams));
                out.flush();
                out.close();
            }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);
            Object retrunString = jsonObject.get("result");
            String string = retrunString.toString();
            JSONObject jsonObject1 = JSONObject.parseObject(string);
            Object name1 = jsonObject1.get("description");
            String string1 = name1.toString();
            return string1.equals("一致");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String IDCardOCR(long path) {
        try {

            Credential cred =
                new Credential("AKIDrW1GK9nutd8PMLDdMs8dvz2smRQPraWH", "jJeRrOksmSyQeTGuMYXMuHMTQDl7d0Al");
            HttpProfile httpProfile = new HttpProfile();
            (httpProfile).setEndpoint("ocr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-shanghai", clientProfile);
            // 身份证照片的的url地址
            String params =
                "{\"ImageUrl\":\"http://111.229.114.126:8087/iszychen/img/userInfo/" + path
                    + ".jpg\",\"CardSide\":\"FRONT\",\"Config\":\"{\\\"CropIdCard\\\":true,\\\"CropPortrait\\\":true}\"}";
            IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);

            IDCardOCRResponse resp = client.IDCardOCR(req);
            String string = IDCardOCRRequest.toJsonString(resp);
            JSONObject jsonObject = JSONObject.parseObject(string);
            Object retrunName = jsonObject.get("Name");
            String reName = retrunName.toString();
            Object retrunId = jsonObject.get("IdNum");
            String reId = retrunId.toString();
            String x = reName + "," + reId;
            System.out.println(x);
            return x;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String IDCardOCRBybase64(String base64path) {
        try {

            Credential cred =
                    new Credential("AKIDrW1GK9nutd8PMLDdMs8dvz2smRQPraWH", "jJeRrOksmSyQeTGuMYXMuHMTQDl7d0Al");
            HttpProfile httpProfile = new HttpProfile();
            (httpProfile).setEndpoint("ocr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-shanghai", clientProfile);
            // 身份证照片的的url地址
            String params = "{\"ImageBase64\":\""+base64path+"\",\"CardSide\":\"FRONT\"}";
            IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);

            IDCardOCRResponse resp = client.IDCardOCR(req);
            String string = IDCardOCRRequest.toJsonString(resp);
            JSONObject jsonObject = JSONObject.parseObject(string);
            Object retrunName = jsonObject.get("Name");
            String reName = retrunName.toString();
            Object retrunId = jsonObject.get("IdNum");
            String reId = retrunId.toString();
            String x = reName + "," + reId;
            System.out.println(x);
            return x;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return null;
    }
}
