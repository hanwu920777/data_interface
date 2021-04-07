package com.sumscope.data.dataservice;

import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Service
@NoArgsConstructor
public class GetSampleDataFromUrl {

    @Resource
    private HttpClientService httpClientService;
    public Map<String, Object> getSpData() {
        String samplebodyDataJson = null;
        try {
            String url = "http://restfulapi-cdh.dev.sumscope.com:7777/api/runapi";
            samplebodyDataJson = httpClientService.post(url, "{\n" +
                    "    \"apiName\": \"sdn_5111_oneday\",\n" +
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

        //JSONObject jsonObject = JSON.parseObject(bodyDataJson);

//        Map map = new HashMap();
//
//        try {
//            map = JsonUtil.toObject(bodyDataJson, Map.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        return (Map<String, Object>) JSONObject.parse(samplebodyDataJson);

    }
}