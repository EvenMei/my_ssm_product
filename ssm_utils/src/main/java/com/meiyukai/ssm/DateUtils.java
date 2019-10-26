package com.meiyukai.ssm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

// Date 类型转换为 string
    public static String Date2Str(Date targerDate){
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(targerDate);
    }


    //String 类型转换为 Date
    public static Date Str2Date(String pattern , String targetStrDate ) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(targetStrDate);
    }
}
