package date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHourTest {
    private static final SimpleDateFormat sdfHH = new SimpleDateFormat("HH:mm");
    public static void main(String[] args) throws ParseException {
        Date date = sdfHH.parse("05:00");
        System.out.println(date.getTime());
        Date date1 = sdfHH.parse("23:00");
        System.out.println(date1.getTime());
//        Date date1 = sdfHH.parse( sdfHH.format("23:00"));
//        System.out.println(date1.getTime());
    }
}
