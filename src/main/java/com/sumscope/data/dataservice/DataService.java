package com.sumscope.data.dataservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DataService {

    private String userStr, userStr1;

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private StoreData storeData;

    public List inter1(String ID) {

        List<Map> findCur = new ArrayList<>();
        for (int i = 0; i < storeData.getRes().size(); i++) {
            userStr = JSON.toJSONString(storeData.getRes().get(i));
            Map<String, Object> hashMap = (Map) JSONObject.parse(userStr);
            if (hashMap.get("curveCode").equals(ID)) {
                findCur.add(hashMap);
            }
        }
        return findCur;
    }


    public List<Map> inter2(String ID, String date) {

        List<Map> findCur1 = new ArrayList<>();

        for (int i = 0; i < this.inter1(ID).size(); i++) {
            userStr1 = JSON.toJSONString(this.inter1(ID).get(i));
            Map<Object, String> hashMap1 = (Map) JSONObject.parse(userStr1);
            String dateInput = dateUtil.dateT(date);
            String dateEx = dateUtil.dateT(hashMap1.get("marketDataTime"));

            if (dateEx.equals(dateInput)) {
                findCur1.add(hashMap1);
            }
        }

        return findCur1;

    }
}




