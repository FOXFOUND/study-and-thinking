package time.test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //timer.schedule(new TimerTask() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
                // 只有当前线程执行完才会执行下一个线程
//                while (true){
//
//                }
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        }, 0,1000);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                timer.scheduleAtFixedRate();
//            }
//        });

    }
}
