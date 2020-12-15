package statcclass.test;

import java.time.LocalDateTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.MAX;
        System.out.println(localDateTime.isAfter(localDateTime1));
    }
}
