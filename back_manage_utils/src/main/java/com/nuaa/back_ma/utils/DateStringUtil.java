package com.nuaa.back_ma.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: raintor
 * @Date: 2019/5/27 19:33
 * @Description:
 */
public class DateStringUtil {
    /**
     * 时间转换到字符串
     * @param date
     * @param patt
     * @return
     */
    public static String Date2String(Date date,String patt){
        SimpleDateFormat sp = new SimpleDateFormat(patt);
        String format = sp.format(date);
        return format;
    }

    public static Date String2Date(String s,String patt) throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat(patt);
        Date parse = sp.parse(s);
        return parse;
    }

}
