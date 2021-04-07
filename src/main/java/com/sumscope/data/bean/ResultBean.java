package com.sumscope.data.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean {
    private String MarketDataTime;
    private String CurveCode;
    private String BenchmarkCurveName;
    private String CurveType;
    private String CountryCode;
    private String InterpolationMethod;
    private String SumscopePublishTime;
    private String SpCurveStatus;
    private String SsCurveArray;
    private String Term;
    private String Yield;
}