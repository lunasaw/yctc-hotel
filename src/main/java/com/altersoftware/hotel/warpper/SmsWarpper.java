package com.altersoftware.hotel.warpper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 短信http接口
 *
 * @author wenyuan.ww
 */
@Component
public class SmsWarpper {

    /** 查账户信息的http地址 */
    private static final String URI_GET_USER_INFO = "https://sms.yunpian.com/v2/user/get.json";
    /** 智能匹配模板发送接口的http地址 */
    private static final String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";
    /** 编码格式。发送编码格式统一用UTF-8 */
    private static final String ENCODING = "UTF-8";
    /** 短信平台的APIKEY */
    private static final String API_KEY = "337972405d54aadb5a7051160faeab87";

    private static final Logger LOG = LoggerFactory.getLogger("serviceLogger");

    /**
     * 取账户信息
     *
     * @param apikey
     * @return json格式字符串
     * @throws IOException
     * @throws URISyntaxException
     */
    public static boolean getUserInfo() throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 智能匹配模板接口发短信
     *
     * @param apikey
     * @param text
     * @param mobile
     * @return json格式字符串
     * @throws IOException
     */
    public boolean sendSms(String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 基于HttpClient的通用POST方法
     *
     * @param url 提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */
    private static boolean post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = null;
        CloseableHttpResponse response = null;

        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
                LOG.info("post success, url={}, paramsMap={}, responseText={}", url, paramsMap, responseText);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("post exception, url=" + url + ", paramsMap=" + paramsMap, e);
            return false;
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                LOG.error("close response, url=" + url + ", paramsMap=" + paramsMap, e);
            }
        }
        return readResultFromJson(responseText);
    }

    /**
     * 解析Json并返回发送结果
     *
     * @param object
     * @return json解析结果code
     */
    private static boolean readResultFromJson(String jsonString) {
        Map<String, Object> result = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>() {});
        int code = (Integer)result.get("code");
        return code == 0;
    }
}
