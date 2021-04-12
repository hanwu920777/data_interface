package com.sumscope.data;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.getdata.GetAssoSampleData;
import com.sumscope.data.getdata.OutputSampleData;
import com.sumscope.data.utils.DateUtil;
import com.sumscope.data.utils.RedisUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
class StoreDataApplicationTests {


    @Autowired
    private GetAssoSampleData getAssoSampleData;
    @Autowired
    private StoreData storeData;
    @Autowired
    private OutputSampleData outputSampleData;

    @Test
    void contextLoads() {

////        int[] res=new int[outputSampleData.data1("SPRA114002").size()];
////         for (int i = 0; i < outputSampleData.data1("SPRA114002").size(); i++) {
////            String userStr = JSON.toJSONString(outputSampleData.data1("SPRA114002").get(i));
////            Map<String, Object> hashMap = (Map) JSONObject.parse(userStr);
////            if (hashMap.get("curveCode").equals("SPRA114002")) {
////
////                res[i]=getAssoSampleData.putSampleData("SPRA114002", hashMap.get("sumscopePublishTime")).size();
////
////            }
//        }
//
//        System.out.println(Arrays.toString(res));
//
    }
}
