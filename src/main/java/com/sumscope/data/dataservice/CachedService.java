//package com.sumscope.data.dataservice;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.sumscope.data.utils.RedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public  class CachedService {
//
//    public CachedService(GetDataFromAPI getDataFromAPI, RedisUtil redisUtil) {
//        this.getDataFromAPI = getDataFromAPI;
//        this.redisUtil = redisUtil;
//    }
//
//    @Autowired
//    private GetDataFromAPI getDataFromAPI;
//    private RedisUtil redisUtil;
//
//
//    public void cachesIn() {
//
//            redisUtil.lSet("data", getDataFromAPI.getData());
//
//
//        String s = JSON.toJSONString(redisUtil.lGetIndex("data",-1));
//    }
//}
