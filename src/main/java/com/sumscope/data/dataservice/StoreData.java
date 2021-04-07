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
    private List<ResultBean> res;
    @Autowired
    private GetDataFromAPI getDataFromAPI;
    @PostConstruct
    public void storeData(){
        String o = JSON.toJSONString(getDataFromAPI.getData().get("resultTable"));
        res = JSONArray.parseArray(o, ResultBean.class);
    }
}
