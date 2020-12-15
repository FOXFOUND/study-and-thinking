package jsontest;

import java.sql.Timestamp;

public class TimeTest {
    public static void main(String[] args) {
        String str = "2020-05-19 23:34:19";
        Timestamp rs = Timestamp.valueOf(str);
        System.out.println(rs);
    }
}
