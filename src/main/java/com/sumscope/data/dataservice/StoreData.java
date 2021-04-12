package com.sumscope.data.dataservice;

import com.sumscope.data.bean.CurveAssoResultBean;
import com.sumscope.data.bean.ResultBean;
import com.sumscope.data.bean.SampleAssoResultBean;
import com.sumscope.data.bean.RequestB;
import com.sumscope.data.utils.DateUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class StoreData {
    private List resSample=new ArrayList<>(),resCurve=new ArrayList<>(),resAssoCurve=new ArrayList<>(),
            resAssoSample=new ArrayList<>();


    @Autowired
    private SplitPage splitPage;
    @Autowired
    private RequestB requestB;
    @Autowired
   private  DateUtil dateUtil;

    @PostConstruct
    public void storeSampleData(){
//        requestB.setPage(1);
//        requestB.setDate("2021.3.16");
//        requestB.setSdnCode("sdn_5111_oneday");

        resSample = splitPage.splitPage(ResultBean.class,"sdn_5111_oneday", 1, dateUtil.setDat());
    }

    @PostConstruct
    public void storeCurveData(){

        resCurve = splitPage.splitPage(ResultBean.class,"sdn_5110_oneday", 1, dateUtil.setDat());

    }

    @PostConstruct
    public void storeAssoCurveData(){

        resAssoCurve = splitPage.splitPage(CurveAssoResultBean.class, "sdn_5110_entry_oneday", 1, dateUtil.setDat());
    }
    @PostConstruct
    public void storeAssoSampleData() {

        //String date=dateBean.getDate();

        resAssoSample = splitPage.splitPage(SampleAssoResultBean.class, "sdn_5111_entry_oneday", 1, dateUtil.setDat());
    }
}
