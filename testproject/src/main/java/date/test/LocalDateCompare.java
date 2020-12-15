package date.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateCompare {
    public static void main(String[] args) {

        LocalTime date = DateUtils.stringConversionLocalDateTimehhMM(DateUtils.getTimeHHMMToString(new Date()));
        System.out.println(date.atDate(LocalDate.now()));
        System.out.println(Date.from(date.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println(LocalDateTime.MAX);
        System.out.println(Date.from(LocalDateTime.MIN.atZone(ZoneId.systemDefault()).toInstant()));
        //System.out.println( Date.from(LocalDate.now().atTime(date).toInstant()) );


       // System.out.println(date.);
//        LocalTime date1 =DateUtils.stringConversionLocalDateTimehhMM("00:00");
//        LocalTime date2 =DateUtils.stringConversionLocalDateTimehhMM("23:59");
//        LocalTime date3 =DateUtils.stringConversionLocalDateTimehhMM("23:59");
//        LocalTime date4 =DateUtils.stringConversionLocalDateTimehhMM("15:20");
//        System.out.println(date);
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(date3);
//        System.out.println(date4);
//        System.out.println("date compare date1 ="+ date.compareTo(date1));
//        System.out.println("date compare date2 ="+ date.compareTo(date2));
//
//        System.out.println("date3 compare date1 ="+ date3.compareTo(date1));
//        System.out.println("date3 compare date2 ="+ date3.compareTo(date2));
//
//        System.out.println("date compare date4 ="+ date.compareTo(date4));


    }
}
