package com.foxfound.log.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class DateUtil {
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

    public static String getLastDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDay = null;
        try {
            currentDay = simpleDateFormat.parse(getCurrentDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }
}
