package date.test;

import java.util.Calendar;
import java.util.Date;

public class CanlanderTest {
    public static void main(String[] args) {
        Date date = new Date();
        //date.getMinutes()
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
    }
}
