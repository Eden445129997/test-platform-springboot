package com.platform.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.internal.http.HttpMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpClient {

    // 文本格式
    public static final MediaType textHtml = MediaType.parse("text/html");

    public static final MediaType textPlain = MediaType.parse("text/plain");

    public static final MediaType textXml = MediaType.parse("text/xml");

    // 媒体格式
    public static final MediaType applicationXWwwFormUrlencoded = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");

    public static final MediaType applicationJaon = MediaType.parse("application/json;charset=utf-8");

    public static final MediaType applicationXml = MediaType.parse("application/xml");

    public static final MediaType applicationMsword = MediaType.parse("application/msword");

    public static final MediaType applicationPdf = MediaType.parse("application/pdf");

    /**
     * 判断是否合法json
     * @param json
     * @return
     */
    public static boolean isJsonValid(String json) {
        ObjectMapper mapper = new ObjectMapper();

        if (json !=null && json.length() !=0) {
            try {
                mapper.readTree(json);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * 将map构造okhttp请求头
     * @param headers
     * @return
     */
    public static Headers buildHeaders(Map<String,String > headers) {
        Headers headers1 = null;
        Headers.Builder headersBuilder = new Headers.Builder();
        if (headers != null) {
            Iterator<String> iterator = headers.keySet().iterator();
            String key;
            while (iterator.hasNext()) {
                key = iterator.next();
                headersBuilder.add(key,headers.get(key));
            }
        }
        headers1 = headersBuilder.build();
        return headers1;
    }

    /**
     * 将map构建okhttp请求体
     * @param method
     * @param contentType
     * @param bodyMap
     * @return
     * @throws JsonProcessingException
     */
    public static RequestBody buildBody(String method,String contentType,Map<String,String> bodyMap) throws JsonProcessingException {
        RequestBody requestBody = null;
        // jackson
        ObjectMapper mapper = new ObjectMapper();
        String httpBody = null;

        // 非GET、HEAD请求则会进入这个判断
        if (HttpMethod.permitsRequestBody(method)) {
            if (contentType.indexOf("application/x-www-form-urlencoded") != -1){
                // map转params数据格式的string
                httpBody = buildParams(bodyMap).toString();
            } else {
                // map转json
                httpBody = mapper.writeValueAsString(bodyMap);
            }
            requestBody = RequestBody.create(MediaType.parse(contentType), httpBody);
        }
        return requestBody;
    }

    /**
     * 根据map参数构造url
     * @param paramsMap
     * @return
     */
    public static StringBuffer mergeUrl(String url,Map<String,String> paramsMap){
        StringBuffer sb = new StringBuffer(url);
        if (paramsMap !=null && paramsMap.keySet().size() > 0) {
            sb.append("?");
            sb.append(buildParams(paramsMap));
        }
        return sb;
    }

    /**
     * 根据map构造params
     * @param paramsMap
     * @return
     */
    public static StringBuffer buildParams(Map<String,String> paramsMap) {
        StringBuffer sb = new StringBuffer("");
        if (paramsMap != null && paramsMap.entrySet().size() > 0) {
            boolean firstFlag = true;
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, Object>) iterator.next();
                if (firstFlag) {
                    sb.append(entry.getKey() + "=" + entry.getValue());
                    firstFlag = false;
                } else {
                    sb.append("&" + entry.getKey() + "=" + entry.getValue());
                }
            }
        }
        return sb;
    }

    /**
     * @param method
     * @param url
     * @param headers
     * @param params
     * @param body
     * @return
     * @throws JsonProcessingException
     */
    public static String sendHttp(String method, String url, Map<String,String > headers ,Map<String,String> params, String body) throws JsonProcessingException {
        // 发送对象
        OkHttpClient okHttpClient = new OkHttpClient();
        // jackson
        ObjectMapper mapper = new ObjectMapper();

        Response response;
        String result = "";
        RequestBody requestBody = null;

        // 如果可以json序列化
        if (isJsonValid(body)) {
            requestBody = RequestBody.create(applicationJaon, body);
        } else {
            requestBody = RequestBody.create(applicationXWwwFormUrlencoded, body);
        }

        Request request = new Request.Builder()
                .url(mergeUrl(url,params).toString())
                .headers(buildHeaders(headers))
                .method(method,requestBody)
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param method
     * @param contentType
     * @param url
     * @param headers
     * @param paramsMap
     * @param bodyMap
     * @return
     * @throws JsonProcessingException
     */
    public static String sendHttpNew(String method,String contentType, String url, Map<String,String > headers ,Map<String,String> paramsMap, Map<String,String> bodyMap) throws JsonProcessingException {
        Response response;
        String result = "";
        // 发送对象
        OkHttpClient okHttpClient = new OkHttpClient();
        // 请求对象
        Request request = new Request.Builder()
                .url(mergeUrl(url, paramsMap).toString())
                .headers(buildHeaders(headers))
                .method(method, buildBody(method,contentType,bodyMap))
                .build();
        try {
            response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String headersStr = "{}";
        String paramsStr = "{\"id\":1,\"a\":\"test\"}";
        String bodyStr = "{}";
        Map<String,String> headerMap = mapper.readValue(headersStr,Map.class);
        Map<String,String> paramsMap = mapper.readValue(paramsStr,Map.class);
        Map<String,String> bodyMap = mapper.readValue(bodyStr,Map.class);
        System.out.println(bodyMap.isEmpty());
        bodyStr = mapper.writeValueAsString(bodyMap);
        System.out.println(bodyStr);

        System.out.println(buildParams(paramsMap));

        String context =
        HttpClient.sendHttp("GET","http://localhost:11001/queryProjectByKeyword",headerMap, paramsMap, bodyStr);
        System.out.println(context);


        System.out.println("================================================");

//        String strJson = "{\"a\":\"哈哈哈\"}";
        String strJson = "{'a':'哈哈哈'}";
        strJson = strJson.replace("'","\"");


        JsonNode jsonNode = mapper.readTree(strJson);
        System.out.println(jsonNode.get("a"));

        Map<String,String> jsonMap = mapper.readValue(strJson,Map.class);
        System.out.println(jsonMap.getClass().getTypeName());
        System.out.println(jsonMap);

        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("a","1");
        StringBuffer sb = mergeUrl("http://localhost:11001/queryProjectByKeyword",jsonMap);
        System.out.println(sb);
    }
}
