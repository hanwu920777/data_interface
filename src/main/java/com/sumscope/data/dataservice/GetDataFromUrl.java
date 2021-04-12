package com.sumscope.data.dataservice;


import com.sumscope.data.bean.CurveAssoResultBean;
import com.sumscope.data.bean.ResultBean;
import com.sumscope.data.bean.SampleAssoResultBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GetDataFromUrl {



    @Resource
    private SplitPage splitPage;

    public List getSpData(String inputDate) {

        return splitPage.splitPage(ResultBean.class, "sdn_5111_oneday", 1, inputDate);
    }

    public List getCrData(String inputDate) {

        return splitPage.splitPage(ResultBean.class,"sdn_5110_oneday", 1, inputDate);

    }


    public List getAssoSampleData(String inputDate) {



        return splitPage.splitPage(SampleAssoResultBean.class, "sdn_5111_entry_oneday", 1, inputDate);

    }
    public List getAssoCurveData(String inputDate) {


        return splitPage.splitPage(CurveAssoResultBean.class, "sdn_5110_entry_oneday", 1, inputDate);

    }
}

