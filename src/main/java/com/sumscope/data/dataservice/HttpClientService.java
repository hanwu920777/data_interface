package com.sumscope.data.dataservice;


import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class HttpClientService {
    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    private final OkHttpClient client = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(150, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .writeTimeout(300, TimeUnit.SECONDS)
            .build();

    /**
     * Post json
     * @return
     */
    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request =
                new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Post form
     */
    public String post(String url, Map<String, String> requestMap) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : requestMap.entrySet()) {
            builder = builder.add(entry.getKey(), entry.getValue());
        }
        FormBody body = builder.build();

        Request request =
                new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}

