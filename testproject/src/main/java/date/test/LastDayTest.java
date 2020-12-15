package date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LastDayTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = dateFormat.parse("2020-02-01 13:11:11");
        //Fri Jan 31 13:11:11 CST 2020
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, -1);
        date = calendar.getTime();
        System.out.println(date);
    }
}
