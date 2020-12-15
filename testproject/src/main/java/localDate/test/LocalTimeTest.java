package localDate.test;

import java.time.LocalDateTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getNano());
        System.out.println(LocalDateTimeUtil.getTimestampOfDateTime(localDateTime));
    }
}
