package time.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCache {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println("hello");

                            System.out.println(Thread.currentThread().getId());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //System.out.println("world");

                    System.out.println(Thread.currentThread().getId());
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
