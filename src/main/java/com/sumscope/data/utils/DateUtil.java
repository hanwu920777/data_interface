package com.sumscope.data.utils;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component

public class DateUtil {
    private String date;
//解析输入的日期转化成xxxx.xx.xx的格式
    public String dateT(String s) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        String l=m.replaceAll("").trim().substring(0, 8);
        String f=l.substring(0,4)+"."+l.substring(4,6)+"."+l.substring(6,8);
        return f;
    }
//获取当前日期
    public String setDat() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String date = formatter.format(currentTime);

        return date;
    }
}


