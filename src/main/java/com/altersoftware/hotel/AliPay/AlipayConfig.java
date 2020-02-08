package com.altersoftware.hotel.AliPay;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号2021001117684862
    public static String APP_ID               = "2021001117684862";

    // 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
    public static String MERCHANT_PRIVATE_KEY =
        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDlK9w2F7DreLLEDMp1rkLcYXFwUYpijT54r+KJTRaXVXOh6gKFJF59fca3H8S4YXpz249jpi+5yAu36PedVMgfOJhTXIakajls3Oxxwq0V5xUWGuTB6K+btE9whDjtkoetKZuZvyioPLNIzUzuGPjLYMwcpypCqKF/IHOT5nK/x4Jotkxw0eblXI6HMjirr/OUXE4sfC0IMuy8XJEqsQxBuvfpDyYvVXKSZ+25Zn5L+QfdQPL2Z1n/9A3Ze7m7Rp6h1K3WHpvnc+W+QecN9D1plabPJnXaLkfezq87VLhPxYhMV2Mp6XacPwwvVxAKDVH09vfPe2yoSj1Ix6mJ3olbAgMBAAECggEBAJmDmP8PPa9u6elUXCcataUlDTVdGeNMlGWKBKlO32w+jLgQpuGDbFyJ7ZxsBn4wpjOIB3SMNXow3FC1GXHmAiyP39Ivr+3hTlhzYVwPOZzrb/+fwk92zHP0BCbuG6hhOMuxjI8gM18HUl3ZUMhKKBcs323uOOvwREaBeYrAm2uFOEDtb0UBPUGobMQ3X1lh35CabmYVwLwjNcfkgJaqWbvj3Zu6GJdhcuWX8wz+WF8itCHErUWRzBe6/BEpOo7im1JqYc/4Spx7C5lOaMVwnswPtFLUGWfZQkGqHKlK5V+y/gj5cRkmkY1y7SATl538wp18kPJDLF21q0v0iub2UjkCgYEA+8zePSy5eS+pcVpgtUTJbhJuhD0oSblR37SB5Yt2d4gDbsmefCBpQOmVjsY4uhobT2aHoMYTCAhdvoWnWbqNM74sGcAmKS8hui3IZZ0yjASGd6U0fqAg3sHJ4/8gb/JOAkHQ22wxktR1x6mPS7ytlm/R05kGHxgj6wGK0ILub5UCgYEA6P5fGYtE8vMlXTvotPguJFH9YDjWESSOSyUmJGMkuRCSGIRURRMpaMzNQkiX59a3cTzL/5w7PGNj1dZWlvHXgv1sRRHS5x61gAdZ/KsdL0hjw9jntQS6IhaqkfC1fSEL8AfzfNnAV09g8TvsNtfXg/41K093zQq3tpWuacfImS8CgYBLGgizIFLVlWSpfXZYuoKFxROXd5I7ov2LhpAzwcv8zOGROqt9hEFAbisAYZjr0PuSTBdp2Yo1nCExwTVv6tdQtoj6yTfYkskxeZRK0n8QCg19RBYLKoGDTzODQEYRfajMvYqo13VVwO68NZOa2FTCCOoBfaO4xH96CYS4ukSZnQKBgGpTy2qI2ApXU/HcaTJNICGLGSpURbzFBfrdFS7938BlA4cUvLBZMkiVTga1wj0XC9gteptH3PCOGv13N0TjUQqCRGqw26KFrSakNDjOjh8J1h2GWxeM9LShy22Wf/x+nEgKGOAdL12o6ACu6/mLPtsJo5IEThPQlE5KuLGlbrIZAoGBAKP3CnmSnKSn4eCtukoroycez559zHa+BlUndItgtU7LyZsOY58U1ehtClzHSOOvPsKIJ1JdoXXuNjarR+2QvnANXhob7sd/VWYaWZnBRPUALFTMGG36QaFdXSNnSJ88NKqP60TCFNLGLAL9fCD+id0TdFm0RhNEEHjcX6kElTVP";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
    public static String ALIPAY_PUBLIC_KEY    =
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjwU2FLypj4s0yjnlSuv92QqrbhmYRg1tQ7a13Q7R8I5Blr9SZgJ/NE5gysWCn9Z4tAZxCi0xbCs6X4mbfYZ6bl+WiLLqAKqRYyf8kpZtZcImqdWCUYp/Dhwq7xRKkJz81equlf0cXb3mUaGEv87OPOI7Dy2mm24NY+g1mH8VN6fWIiQd7D8TipWjI3dAxSCI2aVv2Tz7vaRlWKwLDp7qwnUnz3u035uVVwXXvokD2FXGemhzvFTK4tHKfEzut6UqhCoKgAdzkR2p7jqAuTr1HwXnvBcp15OVuntI/DroD8QWD4FAXz1KZq+I0ZyEmBHDs5QDpbH0J+UNjJ3Y3oHrkQIDAQAB";

    public static String notify_url           = "http://localhost:7901/hotel";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url           = "http://111.229.114.126";

    // 签名方式
    public static String SIGN_TYPE            = "RSA2";

    // 字符编码格式
    public static String CHARSET              = "utf-8";

    // 支付宝网关
    public static String GATEWAYURL           = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String LOG_PATH             = "/log/alilog";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * 
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
