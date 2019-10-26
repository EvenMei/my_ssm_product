package com.meiyukai.ssm;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String , Date> {
    @Override
    public Date convert(String s) {
        Date date = null;
        try{
            //10/23/2019 - 08:00  pattern  不写对会导致很多问题的发生。
            SimpleDateFormat sdf  = new SimpleDateFormat("MM/dd/yyyy - HH:mm");
            date =sdf.parse(s);
        }catch(Exception e){
          e.printStackTrace();
        }
        return date;

    }
}
