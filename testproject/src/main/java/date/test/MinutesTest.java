package date.test;

import java.util.Calendar;
import java.util.Date;

public class MinutesTest {
    public static void main(String[] args) {
        Calendar nowTime = Calendar.getInstance();
        System.out.println(nowTime.getTime());
        nowTime.set(Calendar.MINUTE, 0);
        System.out.println(nowTime.getTime());
        nowTime.set(Calendar.MINUTE, 60);
        System.out.println(nowTime.getTime());
    }
}
