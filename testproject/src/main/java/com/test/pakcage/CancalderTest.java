package com.test.pakcage;

import java.util.Calendar;
import java.util.Date;

public class CancalderTest {
    public static void main(String[] args) {


            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            System.out.println(calendar.get(Calendar.MONTH));
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));


    }
}
