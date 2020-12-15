package date.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {

    private static final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final  SimpleDateFormat sdfHH = new SimpleDateFormat("HH:mm:ss");

    public static  String formatDate(Date date)throws ParseException{
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException{

        return sdf.parse(strDate);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(new Date().getTime());

        Date date = sdfHH.parse( sdfHH.format(new Date()));
        System.out.println(date.getTime());
        String strDate = sdf.format(date);
        System.out.println(strDate);
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
        Date  date1 = new Date(0);
        System.out.println(date1.toLocaleString());
        System.out.println(date1.getTime());
        //
        // LocalDate.now().atTime()
    }
}
