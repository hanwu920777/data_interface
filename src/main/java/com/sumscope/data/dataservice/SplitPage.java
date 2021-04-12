package com.sumscope.data.dataservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@Data
public class SplitPage {

//分页获取数据
    public List<Object> splitPage( Class clazz,String sdnCode, int page, String date) {
        List<Object> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
       final String url = "http://restfulapi-cdh.dev.sumscope.com:7777/api/runapi";
        while (true) {
            JSONObject jsonData=null;

            JSONObject postData = new JSONObject();

            postData.put("apiName", sdnCode);
            postData.put("dataSourceId", "420");
            postData.put("pageSize", "1000");
            postData.put("startPage", page);
            postData.put("password", "000000");
            postData.put("user", "FX");
            postData.put("ApiVersion", "N");
            postData.put("conditions", "date:" + date);

            jsonData = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
            Map<String, Object> map = (Map) JSONObject.parse(String.valueOf(jsonData));
            String o = JSON.toJSONString(map.get("resultTable"));
            List<Object> lists = JSONArray.parseArray(o, clazz);
            if (!lists.isEmpty()) {
                for (Object l : lists) {
                    list.add(l);
                }
                page++;
            } else {
                break;
            }
        }
        return list;
    }
}