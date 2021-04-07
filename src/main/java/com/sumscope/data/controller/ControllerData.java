package com.sumscope.data.controller;

import com.sumscope.data.dataservice.StoreData;
import com.sumscope.data.dataservice.GetDataFromAPI;


import com.sumscope.data.dataservice.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerData {


    @Autowired
    private DataService dataService;
    @Autowired
    private StoreData storeData;


    @RequestMapping("/p1")
    public Object getApi1(String ID) {

    return dataService.inter1("SPRA114002").get(0);

    }
    @RequestMapping("/p2")
    public Object getApi2(String ID, String date) {

        return dataService.inter2("SPRA114002","2021-03-16");


    }
}




