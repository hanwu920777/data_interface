package com.sumscope.data.dataservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sumscope.data.bean.ResultBean;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Data
public class StoreData {
    private List<ResultBean> resSample;
    private List<ResultBean> resCurve;
    @Autowired
    private GetSampleDataFromUrl getSampleDataFromUrl;
    @Autowired
    private GetCurveDataFromUrl getCurveDataFromUrl;

    @PostConstruct
    public void storeSampleData(){
        String o = JSON.toJSONString(getSampleDataFromUrl.getSpData().get("resultTable"));
        resSample = JSONArray.parseArray(o, ResultBean.class);
    }

    @PostConstruct
    public void storeCurveData(){
        String o = JSON.toJSONString(getCurveDataFromUrl.getCrData().get("resultTable"));
        resCurve = JSONArray.parseArray(o, ResultBean.class);
    }
}
