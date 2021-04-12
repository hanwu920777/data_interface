package com.sumscope.data.getdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.GetDataFromUrl;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetAssoCurveData {
    private List<Map> yieldTermList;
    @Autowired
    private StoreData storeData;
    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private GetDataFromUrl getDataFromUrl;


    public List putYieldTermData(String ID, String inputDate,String publishTime) {
        if(!inputDate.equals(dateUtil.setDat())){
            return this.getDataFromOneofBoth(ID,  getDataFromUrl.getAssoCurveData(inputDate),publishTime);
        }else{
            return this.getDataFromOneofBoth(ID, storeData.getResAssoCurve(),publishTime);
        }
    }

    public List getDataFromOneofBoth(String ID, List l,String publishTime){
        yieldTermList=new ArrayList<>();
        for(int i=0;i<l.size();i++){
            Map<String, Object> yieldTermMap=new HashMap<>();

            String assoStr = JSON.toJSONString(l.get(i));
            Map<String, Object> hashMap = (Map) JSONObject.parse(assoStr);
            if (hashMap.get("curveCode").equals(ID)&&hashMap.get("sumscopePublishTime").equals(publishTime)) {
                yieldTermMap.put("term",hashMap.get("term"));
                yieldTermMap.put("yield",hashMap.get("yield"));
                yieldTermList.add(yieldTermMap);
            }
        }
        return yieldTermList;
    }
}

