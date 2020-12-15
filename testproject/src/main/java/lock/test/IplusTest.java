package lock.test;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IplusTest implements Runnable {
    volatile int i = 12;
    Map map = new HashMap();
    List list = new ArrayList();

    @Override
    public void run() {
        i++;
        System.out.println(Thread.currentThread().getName() + "___" + i);
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "___" + i);
    }

    public static void main(String[] args) {
        //new IplusTest().run();
//        Object obj = new Object();
//        String layout = ClassLayout.parseInstance(obj).toPrintable();
//        System.out.println(layout);
    }
    /*
    public static void main(String[] args) throws InterruptedException {
        IplusTest iplusTest = new IplusTest();
        ExecutorService executors = Executors.newCachedThreadPool();

        executors.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executors.execute(iplusTest);
                }
            }
        });

        executors.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executors.execute(iplusTest);
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executors.execute(iplusTest);
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executors.execute(iplusTest);
                }
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    executors.execute(iplusTest);
                }
            }
        });
        Thread.sleep(100 * 1000);
    }

*/


}