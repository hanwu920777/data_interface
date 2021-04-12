package com.sumscope.data.getdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sumscope.data.dataservice.GetDataFromUrl;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OutputCurveData implements Getdata {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private StoreData storeData;
    @Autowired
    private GetAssoCurveData getAssoCurveData;
    @Autowired
    private GetDataFromUrl getDataFromUrl;

    @Override
    public List data1(String ID) {
        List<Map> findCur1 = new ArrayList<>();
        for (int i = 0; i < storeData.getResCurve().size(); i++) {
            String userStr = JSON.toJSONString(storeData.getResCurve().get(i));
            Map<String, Object> curveMap1 = (Map)JSONObject.parse(userStr);
            if (curveMap1.get("curveCode").equals(ID)) {
                curveMap1.put("keyPoints",getAssoCurveData.getDataFromOneofBoth(ID, storeData.getResAssoCurve(), (String) curveMap1.get("sumscopePublishTime")));
                findCur1.add(curveMap1);
            }
        }


        return findCur1;
    }

    @Override
    public List data2(String ID, String inputDate) {

            if (!inputDate.equals(dateUtil.setDat())) {
                return this.getData(ID,inputDate,getDataFromUrl.getCrData(inputDate));
            } else {
                return this.getData(ID,inputDate,storeData.getResCurve());
            }
        }



        public List getData(String ID,String inputDate,List l){
            List<Map> findCur2 = new ArrayList<>();
            for (int i = 0; i < l.size(); i++) {
                String userStr1 = JSON.toJSONString(l.get(i));
                Map<String, Object> curveMap2 = (Map) JSONObject.parse(userStr1);
//            String dateInput = dateUtil.dateT(inputDate);
//            String dateEx = dateUtil.dateT((String) hashMap1.get("marketDataTime"));

                if (curveMap2.get("curveCode").equals(ID)) {
                    curveMap2.put("keyPoints", getAssoCurveData.putYieldTermData(ID, inputDate, (String) curveMap2.get("sumscopePublishTime")));
                    findCur2.add(curveMap2);
                }
            }
            return findCur2;
        }
    }




