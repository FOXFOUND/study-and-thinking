package date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpileDateTime {
    public  class TestSimpleDateFormatThreadSafe extends Thread {
        /**
         * Exception in thread "Thread-0" Exception in thread "Thread-2" Exception in thread "Thread-1" java.lang.NumberFormatException: For input string: "55.E551E1"
         * 	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2043)
         * 	at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
         * 	at java.lang.Double.parseDouble(Double.java:538)
         * 	at java.text.DigitList.getDouble(DigitList.java:169)
         * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2089)
         * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
         * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
         * 	at java.text.DateFormat.parse(DateFormat.java:364)
         * 	at date.test.DateUtil.parse(DateUtil.java:18)
         * 	at date.test.DateUtilTest$TestSimpleDateFormatThreadSafe.run(DateUtilTest.java:45)
         * java.lang.NumberFormatException: For input string: "55.E551E1"
         * 	at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2043)
         * 	at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
         * 	at java.lang.Double.parseDouble(Double.java:538)
         * 	at java.text.DigitList.getDouble(DigitList.java:169)
         * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2089)
         * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
         * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
         * 	at java.text.DateFormat.parse(DateFormat.java:364)
         * 	at date.test.DateUtil.parse(DateUtil.java:18)
         * 	at date.test.DateUtilTest$TestSimpleDateFormatThreadSafe.run(DateUtilTest.java:45)
         * java.lang.NumberFormatException: For input string: ""
         * 	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
         * 	at java.lang.Long.parseLong(Long.java:601)
         * 	at java.lang.Long.parseLong(Long.java:631)
         * 	at java.text.DigitList.getLong(DigitList.java:195)
         * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2084)
         * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
         * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
         * 	at java.text.DateFormat.parse(DateFormat.java:364)
         * 	at date.test.DateUtil.parse(DateUtil.java:18)
         * 	at date.test.DateUtilTest$TestSimpleDateFormatThreadSafe.run(DateUtilTest.java:45)
         */
        @Override
        public void run() {
            while(true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(this.getName()+":"+sdf.parse("2013-05-24 06:02:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            new DateUtilTest.TestSimpleDateFormatThreadSafe().start();
        }

    }
}
