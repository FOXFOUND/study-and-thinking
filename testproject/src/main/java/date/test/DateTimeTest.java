package date.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime afterLocalDateTime  = localDateTime.plusMinutes(5);
        LocalDateTime beforeLocalDateTime = localDateTime.plusMinutes(-5);
        String afterTime = afterLocalDateTime.format(dateTimeFormatter);
        String beforeTime = beforeLocalDateTime.format(dateTimeFormatter);
        System.out.println(afterTime);
        System.out.println(beforeTime);
    }
}
