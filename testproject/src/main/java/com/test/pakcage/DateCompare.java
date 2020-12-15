package com.test.pakcage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompare {
    private static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) throws ParseException {
        Date nowDate = formatter.parse("00:01");
        Date startTime = formatter.parse("00:00");
        Date endTime = formatter.parse("23:59");

       // nowDate.after()
        System.out.println(nowDate.compareTo(startTime) >= 0);
        System.out.println(nowDate.compareTo(endTime) <= 0);

    }
}
