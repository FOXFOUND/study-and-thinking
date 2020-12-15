package date.test;

import com.test.pakcage.Test;

import java.text.ParseException;

public class DateUtilsTest {
    /**
     * Thread-1:2013-05-24T06:02:20
     * Thread-2:2013-05-24T06:02:20
     * Thread-0:2013-05-24T06:02:20
     * Thread-1:2013-05-24T06:02:20
     * Thread-2:2013-05-24T06:02:20
     * Thread-0:2013-05-24T06:02:20
     * Thread-2:2013-05-24T06:02:20
     * Thread-1:2013-05-24T06:02:20
     * Thread-0:2013-05-24T06:02:20
     * Thread-2:2013-05-24T06:02:20
     * Thread-1:2013-05-24T06:02:20
     * Thread-0:2013-05-24T06:02:20
     */
    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                System.out.println(this.getName() + ":" + DateUtils.stringConversionLocalDateTime("2013-05-24 06:02:20"));

            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new DateUtilsTest.TestSimpleDateFormatThreadSafe().start();
        }

    }
}
