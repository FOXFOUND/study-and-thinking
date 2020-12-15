package localDate.test;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalTImeStampTest {
    public static void main(String[] args) {
        //1605494204
        //1605062335738L
//        LocalDateTime localDateTime =LocalDateTimeUtil.getDateTimeOfTimestamp(1605062335738L);
//        System.out.println(localDateTime);
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dtf2.format(localDateTime));

        Date date = new Date();
        System.out.println(JSON.toJSONString(date));
        //1605083735726
    }
}
