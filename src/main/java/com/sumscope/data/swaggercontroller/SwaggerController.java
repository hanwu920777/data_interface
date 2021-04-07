package com.sumscope.data.swaggercontroller;

import com.sumscope.data.controller.ControllerData;
import com.sumscope.data.dataservice.DataService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiController")
public class SwaggerController {

@Autowired
private ControllerData controllerData;

@Autowired
private DataService dataService;

        @ApiOperation(value = "接口服务",notes = "获取最新发布的实时曲线",httpMethod = "POST")
        @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID")
        @RequestMapping(value = "/s1")
        public Object api1(String ID) {

            return dataService.inter1(ID).get(0);
        }

    @ApiOperation(value = "接口服务",notes = "获取指定日期的日终曲线",httpMethod = "POST")
    @ApiImplicitParams({
                    @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID"),
                    @ApiImplicitParam(dataType="String",name="date",required=true,value="date")
                 })
//    @ApiResponses({
//                     @ApiResponse(code=400,message="请求参数没填好"),
//                     @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
//                 })
    @RequestMapping(value = "/s2")
    public Object api2(String ID,String date) {

        return dataService.inter2(ID,date);
    }
    }


