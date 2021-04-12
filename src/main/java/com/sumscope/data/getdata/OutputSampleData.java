package com.sumscope.data.getdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.GetDataFromUrl;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.utils.DateUtil;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@Data
public class OutputSampleData implements Getdata {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private StoreData storeData;
    @Autowired
    private GetAssoSampleData getAssoSampleData;
    @Autowired
    private GetDataFromUrl getDataFromUrl;

@Override
    public List data1(String ID) {

        List<Map> findSam1 = new ArrayList<>();
        for (int i = 0; i < storeData.getResSample().size(); i++) {
            String userStr = JSON.toJSONString(storeData.getResSample().get(i));
            Map<String, Object> outputMap = (Map) JSONObject.parse(userStr);
            if (outputMap.get("curveCode").equals(ID)) {
                outputMap.put("keyPoints", getAssoSampleData.getDataFromOneofBoth(ID, storeData.getResAssoSample(),(String) outputMap.get("sumscopePublishTime")));
                findSam1.add(outputMap);
            }
        }
        return findSam1;
    }

@Override
    public List data2(String ID, String inputDate) {
        if (!inputDate.equals(dateUtil.setDat())) {
            return this.getData(ID,inputDate,getDataFromUrl.getSpData(inputDate));
        } else {
            return this.getData(ID,inputDate,storeData.getResSample());
        }
    }
    public List getData(String ID,String inputDate,List l){
            List<Map> findSam2 = new ArrayList<>();
            for (int i = 0; i < l.size(); i++) {
                String userStr1 = JSON.toJSONString(l.get(i));
                Map<String, Object> outputMap1 = (Map) JSONObject.parse(userStr1);
//            String dateInput = dateUtil.dateT(inputDate);
//            String dateEx = dateUtil.dateT((String) hashMap1.get("marketDataTime"));

                if (outputMap1.get("curveCode").equals(ID)) {
                    outputMap1.put("keyPoints", getAssoSampleData.putSampleData(ID, inputDate,(String) outputMap1.get("sumscopePublishTime")));
                    findSam2.add(outputMap1);
                }
            }
            return findSam2;
        }
    }






