package com.searchone.searcheye.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpProxyUtil {
    private static HttpClient httpClient = null;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置最大连接数不超过200
        cm.setMaxTotal(200);
        //每个路由默认的连接数20
        cm.setDefaultMaxPerRoute(20);
        httpClient = HttpClientBuilder.create().setConnectionManager(cm).build();

    }

    public static byte[] get(String url) {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (httpResponse == null) {
            return null;
        }
        byte[] bytes = new byte[0];
        try {
            bytes = EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
        }
        return bytes;
    }
}
