package com.sumscope.data.swaggercontroller;

import com.sumscope.data.getdata.OutputCurveData;
import com.sumscope.data.getdata.OutputSampleData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiController")
public class SwaggerController {

@Autowired
private OutputCurveData outputCurveData;
@Autowired
private OutputSampleData outputSampleData;

        @ApiOperation(value = "样本券接口服务",notes = "获取最新发布的样本券数据",httpMethod = "POST")
        @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID")
        @RequestMapping(value = "/ss1")
        public Object api1(String ID) {

            return outputSampleData.data1(ID).get(0);
        }


        @ApiOperation(value = "样本券接口服务",notes = "获取指定日期的样本券数据",httpMethod = "POST")
        @ApiImplicitParams({
                    @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID"),
                    @ApiImplicitParam(dataType="String",name="date",required=true,value="date")
                 })
//      @ApiResponses({
//                     @ApiResponse(code=400,message="请求参数没填好"),
//                     @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
//                 })
        @RequestMapping(value = "/ss2")
         public Object api2(String ID,String date) {

            return outputSampleData.data2(ID,date);
        }

        @ApiOperation(value = "利率曲线接口服务",notes = "获取最新发布的利率曲线数据",httpMethod = "POST")
        @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID")
        @RequestMapping(value = "/sc1")
        public Object api3(String ID) {

            return outputCurveData.data1(ID).get(0);
        }


        @ApiOperation(value = "利率曲线接口服务",notes = "获取指定日期的利率曲线数据",httpMethod = "POST")
        @ApiImplicitParams({
                @ApiImplicitParam(dataType="String",name="ID",required=true,value="curveID"),
                @ApiImplicitParam(dataType="String",name="date",required=true,value="date")
        })
        @RequestMapping(value = "/sc2")
        public Object api4(String ID,String date) {

            return outputCurveData.data2(ID,date);
        }
}


