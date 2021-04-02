package simpleDateFormat.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.parse(""));
    }
}
