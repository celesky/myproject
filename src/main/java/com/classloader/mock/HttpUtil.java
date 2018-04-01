package com.classloader.mock;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by pan on 2017/10/18.
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static RequestConfig REQUEST_CONFIG = RequestConfig
            .custom()
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(2000)
            .setSocketTimeout(5000).build();

    public static String post(String url,List<NameValuePair> formparams){

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setConfig(REQUEST_CONFIG);
        httppost.setEntity(entity);
        CloseableHttpResponse response =null;
        try {
            response = httpclient.execute(httppost);
            String responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
            return responseContent;
        } catch (ClientProtocolException e) {
            logger.error("HttpUtil post ClientProtocolException:"+e.getMessage(),e);
        } catch (IOException e) {
            logger.error("HttpUtil post IOException:"+e.getMessage(),e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                logger.error("HttpUtil post response.close:"+e.getMessage(),e);
            }
        }
        return null;
    }


    public void init(){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
// Increase max total connection to 200
        cm.setMaxTotal(200);
// Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
// Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }
}
