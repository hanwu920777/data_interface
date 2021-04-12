package com.sumscope.data.getdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.GetDataFromUrl;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.utils.DateUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class GetAssoSampleData {

    @Autowired
    private StoreData storeData;
    @Autowired
    private GetDataFromUrl getDataFromUrl;
    @Autowired
    private DateUtil dateUtil;



    public List<Map<String ,Object>> putSampleData(String ID, String inputDate,String publishTime) {
        if(!inputDate.equals(dateUtil.setDat())){
            return this.getDataFromOneofBoth(ID,  getDataFromUrl.getAssoSampleData(inputDate),publishTime);
        }else{
            return this.getDataFromOneofBoth(ID, storeData.getResAssoSample(),publishTime);
        }
    }


    public List<Map<String ,Object>> getDataFromOneofBoth(String ID, List l,String publishTime){


        List<Map<String ,Object>> assoSampleDataList = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            Map<String, Object> sampleDataMap = new HashMap<>();
            String assoSampleStr = JSON.toJSONString(l.get(i));
            Map<String, Object> hashMap = (Map) JSONObject.parse(assoSampleStr);
            if (hashMap.get("curveCode").equals(ID)&&hashMap.get("sumscopePublishTime").equals(publishTime)) {
                Set keyset = hashMap.keySet();
                Iterator iterator = keyset.iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    Object value = hashMap.get(key);
                    if (!key.equals("curveCode") && !key.equals("sumscopePublishTime")) {
                        sampleDataMap.put(key, value);
                    }
                }
                assoSampleDataList.add(sampleDataMap);
            }
        }

        return assoSampleDataList;
    }
}
