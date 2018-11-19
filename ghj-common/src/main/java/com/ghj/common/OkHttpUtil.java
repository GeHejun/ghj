package com.ghj.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {

    public static JsonObject syncGet(String url, Map<String, String> params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String urlParam = dealParams(url, params);
        Request request = new Request.Builder()
                .url(urlParam)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }
        return pareseResponseString(response.body().toString());

    }

    public static JsonObject pareseResponseString(String responseString) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseString, JsonObject.class);
        return jsonObject;
    }

    public static String dealParams(String url, Map<String, String> params) {
        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            String value = null;
            try {
                value = URLEncoder.encode(values.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringBuffer.append(keys.next() + "=" + value);
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }

        return url + stringBuffer.toString();

    }
}
