package com.altersoftware.hotel.AliPay;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 支付宝配置类
 *
 * @author Iszychen@win10
 * @date 2020/2/7 14:23
 */
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String APP_ID               = "2016092300579341";

    // 商户私钥，您的PKCS8格式RSA2私钥，这些就是我们刚才设置的
    public static String MERCHANT_PRIVATE_KEY =
        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkRbVEFHxPkl754hwz4w9iraA62H3/GjZ6RwHa+8LBy2mNOg89IaodAUd99ojYEDgnVxg8U9RhXF4COsm6Q+APy7YpCpu5GJv6X9HJYLXifyxc5gfr48CdR6JQDx2R5/aqMro0Dd69R3HOuZj5rctpVHs7gIvsSn5PV53OCOgLEWzbtcY3DKLkByevmoXVdnBDHRZKqv1H6N8i83YzNRVx6fr3IHZGiIxVbuEHUn5iT1FBArQVuHLki5JaM6nwWQIC2a0T2Yokp1kjqhFoNp08sgDZnlEtQP9SjoeQMrWO0mFI7Jb3ooMLqJwNsdzy0Bwonh0zfrltPwzYcs2d9vTtAgMBAAECggEAW+Kp+8TBq/ihq4Bwag2N45Je18uU3oaZBliFjynXzHKtPdPGBlm4P7UhejHWZZTc9BRheA0j9Lmn0/NyNwAUaoF2CQroA+biCHBkdhHkaybbd7MrpySj7tXM0p9B2QU5EgaB5PAFMTavUAS8rpwp9WbN74B9w9P/Rv4pRL/ym41iYVxFJ3r59GDOZ/GMYzcNrFi3Io5I7LSPBR/DP2XR/Z0V2ahZ5cVBxea0rIDum+veioknLmwglzmxI9/V8C+PkgryjsfokTlH2FWx+XBbhzfcelCq50QLdHSSLAR4u2kuWv1aiswNYBaEFJ7Ir0TUCa4rYzVUkfHb1W4wTHSYwQKBgQDo7btJatR/QfI0c+TmVVcoHdS9QimcJq5dDhccePH7ocHmK5NDabtB1UgzUBHTg/ePNWhrFzuFSV3GN3XZAMkxRNA5YxBnd9R27cI8zzo9ph+BRgInc79usKE4uM1kt3s/8+Tdlx8mMh31ssxy3PrznBec9W663Uz/tpxM/WanlQKBgQC0ixaHjdP8eW7Hrdj8KnBeHqxsrQMUfH37/LTZcnbvuIDGaFCntYTR3C0HjoOIi7mbbIV584A3nxoEhfSt+fTo6GxHHCkF5TIE2ewsCWOxrMGKhoPWibuJZOe+qBXTICaOCR80sKa5zHu3zkjymQcKBxHiLtVgbwW/CLYSt4Th+QKBgQDaps84i+AN1YnXUzN8RIAcWGRrhMAqpOTo1WE8iQweeinaNu12SrpNgjjUckVJmIe7Fxd978EfzU8J0uX9Xo9+gGo2dJfhiMsZGPdMvfqeBGNuppk/D5iT/5pX9KJZ+SLpVblxiXrkEAevrLfe2zF3nP9Nh9b58uNk57axTu4eQQKBgE83yEbqQF3DmowbB959cJibtORqdbODfHQYyfGve+hreHWWR+2OhBzhExEBw00ioepEj7yWz2eYc/4QGPBNgNzBPuFkxctEadIfHLWl2QyY1MNHiomUHamHkPfjINBmhwRDlGG2MTHNO2vHI9Luulv4BizMh+usS0UrOVi1FaVhAoGBAJGhjac7FODXn2cDQY4Rqf0cw8wUy4+XISRlHfRBt51mogZ/9xyfY4A/S5bkKwpzMAXtaF4r6URYj4tP5wFE48ANepHVDnXs4Bj/x+/NsgbLyiK0Mo2fL2WchYxWym8pzsifvWvrxWVI5pGtJRVl0xKN9KsJjwfRsFKS0YSzM0av";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。，这些就是我们刚才设置的
    public static String ALIPAY_PUBLIC_KEY    =
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApEW1RBR8T5Je+eIcM+MPYq2gOth9/xo2ekcB2vvCwctpjToPPSGqHQFHffaI2BA4J1cYPFPUYVxeAjrJukPgD8u2KQqbuRib+l/RyWC14n8sXOYH6+PAnUeiUA8dkef2qjK6NA3evUdxzrmY+a3LaVR7O4CL7Ep+T1edzgjoCxFs27XGNwyi5Acnr5qF1XZwQx0WSqr9R+jfIvN2MzUVcen69yB2RoiMVW7hB1J+Yk9RQQK0Fbhy5IuSWjOp8FkCAtmtE9mKJKdZI6oRaDadPLIA2Z5RLUD/Uo6HkDK1jtJhSOyW96KDC6icDbHc8tAcKJ4dM365bT8M2HLNnfb07QIDAQAB";

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
    public static String LOG_PATH             = "C:\\";

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
