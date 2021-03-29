package cn.edu.gxu.util;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.util
 * @date 2021/3/27 19:18
 * @Description
 */
public class HttpClientUtils {
    public static String doGet(String url, Map<String, String> param, String token) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建uri 及请求参数
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if (token != null) {
                httpGet.setHeader("token", token);
            }
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                // inputStream = response.getEntity().getContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null, null);
    }

    public static String doPost(String url, Map<String, String> param, String token) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
//            if (token != null)
//                httpPost.setHeader("token", token);
//            httpPost.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
//            httpPost.setHeader(new BasicHeader("Connection", "keep-alive"));
            httpPost.setHeader(new BasicHeader("Cookie", "c5f84e8cf747961d14597c924a935dc8=d2Vi; ce127c93dec0b004c421751dc9389f17=MS4wLjA=; 671b750dad5f30d6eaf736b4cb910d35=ZDljMmQzMjY0ZmVhNzhhYzljYjg3OTRhMGYyNGRhODI=; f3ffe8e1f804f2074aa5cc55233673b8=ZDljMmQzMjY0ZmVhNzhhYzljYjg3OTRhMGYyNGRhODI=; 8e44f0089b076e18a718eb9ca3d94674=MzgxNQ==; 435e0648d634175c46bd40ac366545a8=dTY2NzgyMjQ=; 3d88fcbaa3581c4957147ef9ad47ec5e=Mw==; ce4a0b029c785bfaa2b398c06e1d94c0=OUJENkQ4MTA5RkFBNEIzNUIyOEYxNjE5RDkzMzgxREU="));
            httpPost.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36"));
//            httpPost.setHeader(new BasicHeader("Host", "47.93.62.250:3004"));

            //            httpPost.setHeader(new BasicHeader("Host", "47.93.62.250:3004"));
//            httpPost.setHeader(new BasicHeader("Accept-Encoding", "gzip, deflate"));
//            httpPost.setHeader(new BasicHeader("Host", "47.93.62.250:3004"));

            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doPost(String url, Map<String, String> param) {
        return doPost(url, param, null);
    }

    public static String doPostJson(String url, String json, String token) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("token", token);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }
}
