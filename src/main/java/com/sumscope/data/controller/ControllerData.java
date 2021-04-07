package com.sumscope.data.controller;


import com.sumscope.data.getdata.GetCurveData;
import com.sumscope.data.getdata.GetSampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerData {


    @Autowired
    private GetCurveData getCurveData;
    @Autowired
    private GetSampleData getSampleData;

    @RequestMapping("/s1")
    public Object getSample1(String ID) {

    return getSampleData.data1("SPRA114002").get(0);

    }
    @RequestMapping("/s2")
    public Object getSample2(String ID, String date) {

        return getSampleData.data2("SPRA114002","2021-03-16");


    }

    @RequestMapping("/c1")
    public Object getCurve1(String ID) {

        return getCurveData.data1("SPRA114002").get(0);

    }
    @RequestMapping("/c2")
    public Object getCurve2(String ID, String date) {

        return getCurveData.data2("SPRA114002","2021-03-16");


    }
}




