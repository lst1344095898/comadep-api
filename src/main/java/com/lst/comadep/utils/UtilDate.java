package com.lst.comadep.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class UtilDate {
    static final SimpleDateFormat simpleFormatter=new SimpleDateFormat("%yy-%MM-%dd");

    /**
     * 得到当前日期字符串形式
     * @return
     */
    public static String getDateString(){
        return simpleFormatter.format(new Date());
    }
    public static String dateToString(Date date){
        return simpleFormatter.format(date);
    }
}
