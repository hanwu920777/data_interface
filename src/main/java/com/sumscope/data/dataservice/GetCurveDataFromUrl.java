package com.sumscope.data.dataservice;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
@Service
public class GetCurveDataFromUrl {

    @Resource
    private HttpClientService httpClientService;
    public Map<String,Object> getCrData() {
        String curvebodyDataJson = null;
        try {
            String url = "http://restfulapi-cdh.dev.sumscope.com:7777/api/runapi";
            curvebodyDataJson = httpClientService.post(url, "{\n" +
                    "    \"apiName\": \"sdn_5110_oneday\",\n" +
                    "    \"dataSourceId\": \"420\",\n" +
                    "    \"pageSize\": \"100\",\n" +
                    "    \"startPage\": \"1\",\n" +
                    "    \"password\": \"000000\",\n" +
                    "    \"user\": \"FX\",\n" +
                    "    \"ApiVersion\": \"N\",\n" +
                    "    \"conditions\": \"date:2021.03.16; condition: order by marketDataTime desc\"\n" +
                    "}\n" +
                    " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (Map<String, Object>) JSONObject.parse(curvebodyDataJson);

    }
}

