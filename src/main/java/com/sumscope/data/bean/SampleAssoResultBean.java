package com.sumscope.data.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleAssoResultBean {

        private String CurveCode;
        private String BondKey;
        private String SecurityID;
        private String ListedMarket;
        private double Yield;
        private String BidYield;
        private String AskYield;
        private String MidYield;
        private String Spread1;
        private String CompanyID;
        private String TradeTime;
        private String SumscopePublishTime;

}
