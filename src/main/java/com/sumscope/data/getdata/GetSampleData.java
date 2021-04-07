package com.sumscope.data.getdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class GetSampleData implements Getdata {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private StoreData storeData;

    @Override
    public List data1(String ID) {
        List<Map> findSam1 = new ArrayList<>();
        for (int i = 0; i < storeData.getResSample().size(); i++) {
            String userStr = JSON.toJSONString(storeData.getResSample().get(i));
            Map<String, Object> hashMap = (Map) JSONObject.parse(userStr);
            if (hashMap.get("curveCode").equals(ID)) {
                findSam1.add(hashMap);
            }
        }
        return findSam1;
    }

    @Override
    public List data2(String ID, String date) {
        List<Map> findSam2 = new ArrayList<>();

        for (int i = 0; i < this.data1(ID).size(); i++) {
            String userStr1 = JSON.toJSONString(this.data1(ID).get(i));
            Map<Object, String> hashMap1 = (Map) JSONObject.parse(userStr1);
            String dateInput = dateUtil.dateT(date);
            String dateEx = dateUtil.dateT(hashMap1.get("marketDataTime"));

            if (dateEx.equals(dateInput)) {
                findSam2.add(hashMap1);
            }
        }

        return findSam2;
    }
}

