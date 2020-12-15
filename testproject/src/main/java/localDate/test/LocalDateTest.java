package localDate.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
        //LocalDateTime miniDate = LocalDateTimeUtil.getLocalDateFromStr("202011", LocalDateTimeUtil.DateTimeFormatterConst.dateTimeFormatterYYYYMM);
        //System.out.println(miniDate);
//        LocalDateTime localDateTime = miniDate.minusMonths(1);
//        System.out.println(localDateTime);
//        System.out.println(miniDate);
        LocalDate localDate = LocalDate.parse("20201101", DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.parse("00:00:00"));
        System.out.println(localDateTime);
        LocalDateTime localDateTime1= localDateTime.minusMonths(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        System.out.println(formatter.format(localDateTime1));
       // System.out.println(LocalDateTime.from(formatter.parse("202011")));
    }

}
