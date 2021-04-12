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

    public Object dateT(String s) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.replaceAll("").trim().substring(0, 8);
    }

    public String setDat() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String date = formatter.format(currentTime);

        return date;
    }
}


