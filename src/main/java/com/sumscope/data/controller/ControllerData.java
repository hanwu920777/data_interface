package com.sumscope.data.controller;


import com.sumscope.data.dataservice.GetDataFromUrl;
import com.sumscope.data.dataservice.SplitPage;
import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.getdata.GetAssoCurveData;
import com.sumscope.data.getdata.GetAssoSampleData;
import com.sumscope.data.getdata.OutputCurveData;
import com.sumscope.data.getdata.OutputSampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerData {


    @Autowired
    private OutputCurveData outputCurveData;
    @Autowired
    private OutputSampleData outputSampleData;

    @Autowired
    private StoreData storeData;
    @Autowired
    private GetAssoCurveData getAssoCurveData;

    @Autowired
    private GetAssoSampleData getAssoSampleData;
    @Autowired
    private SplitPage splitPage;
    @Autowired
    private GetDataFromUrl getDataFromUrl;



//    @RequestMapping("/g3")
//    public Object getSample121() {
//
//        return outputSampleData.getData("SPRA114001","2021.04.12",storeData.getResSample());
//
//    }
    @RequestMapping("/s1")
    public Object getSample1() {

    return outputSampleData.data1("SPRA114001");

    }
    @RequestMapping("/s2")
    public Object getSample2() {

        return outputSampleData.data2("SPRA114001","2021.04.12");

    }
    @RequestMapping("/f1")
    public Object getSample3() {

        return getDataFromUrl.getSpData("2021.03.16");


    }

    @RequestMapping("/f2")
    public Object getCurve1() {

        return getDataFromUrl.getCrData("2021.03.16");

    }
    @RequestMapping("/f3")
    public Object getCurve2() {

        return getDataFromUrl.getAssoSampleData("2021.03.16");
    }

        @RequestMapping("/f4")
        public List getCurve3() {

           return getDataFromUrl.getAssoCurveData("2021.03.16");

        }
    @RequestMapping("/c4")
    public List getCurve4() {

        return storeData.getResSample();

    }
    @RequestMapping("/c5")
    public List getCurve5() {

        return storeData.getResCurve();

    }
    @RequestMapping("/c6")
    public List getCurve6() {

        return storeData.getResAssoCurve();

    }
    @RequestMapping("/c7")
    public List getCurve7() {

        return storeData.getResAssoSample();

    }

    @RequestMapping("/c8")
    public List getCurve8() {

        return outputCurveData.data1("SPRA114001");

    }
    @RequestMapping("/c9")
    public List getCurve9() {

        return outputCurveData.data2("SPRA114001","2021.03.16");

    }


    }





