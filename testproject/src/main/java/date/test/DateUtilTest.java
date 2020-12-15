package date.test;


import java.text.ParseException;
import java.util.Date;

public class DateUtilTest {

    /**
     * Exception in thread "Thread-2" Exception in thread "Thread-1" java.lang.NumberFormatException: multiple points
     * 	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
     * 	at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
     * 	at java.lang.Double.parseDouble(Double.java:538)
     * 	at java.text.DigitList.getDouble(DigitList.java:169)
     * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2089)
     * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
     * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
     * 	at java.text.DateFormat.parse(DateFormat.java:364)
     * 	at date.test.DateUtil.parse(DateUtil.java:18)
     * 	at date.test.DateUtilTest$TestSimpleDateFormatThreadSafe.run(DateUtilTest.java:19)
     * java.lang.NumberFormatException: multiple points
     * 	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
     * 	at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
     * 	at java.lang.Double.parseDouble(Double.java:538)
     * 	at java.text.DigitList.getDouble(DigitList.java:169)
     * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2089)
     * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
     * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
     * 	at java.text.DateFormat.parse(DateFormat.java:364)
     * 	at date.test.DateUtil.parse(DateUtil.java:18)
     * 	at date.test.DateUtilTest$TestSimpleDateFormatThreadSafe.run(DateUtilTest.java:19)
     * Thread-0:Sun May 24 06:02:20 CST 2201
     * Thread-0:Fri May 24 06:02:20 CST 2013
     */
    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    System.out.println(this.getName()+":"+DateUtil.parse("2013-05-24 06:02:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            new TestSimpleDateFormatThreadSafe().start();
        }

    }
}