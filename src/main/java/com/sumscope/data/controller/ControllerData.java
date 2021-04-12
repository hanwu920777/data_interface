package com.sumscope.data.controller;

import com.sumscope.data.getdata.OutputCurveData;
import com.sumscope.data.getdata.OutputSampleData;
import com.sumscope.data.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerData {


    @Autowired
    private OutputCurveData outputCurveData;
    @Autowired
    private OutputSampleData outputSampleData;
    @Autowired
    private DateUtil dateUtil;

    private String date="20210412";
    @RequestMapping("/s1")
    public Object getSample1() {

    return outputSampleData.data1("SPRA114001");

    }
    @RequestMapping("/s2")
    public Object getSample2() {

        return outputSampleData.data2("SPRA114001",dateUtil.dateT(date));

    }

    @RequestMapping("/c1")
    public Object getCurve1() {

        return outputCurveData.data1("SPRA114001");

    }
    @RequestMapping("/c2")
    public Object getCurve2() {

        return outputCurveData.data2("SPRA114001",dateUtil.dateT("2021ujhh03.16"));

    }


    }





