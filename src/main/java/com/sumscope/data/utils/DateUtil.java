package com.sumscope.data.utils;
import org.springframework.stereotype.Component;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class DateUtil {

    public String dateT(String s){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.replaceAll("").trim().substring(0,8);
    }
        }


