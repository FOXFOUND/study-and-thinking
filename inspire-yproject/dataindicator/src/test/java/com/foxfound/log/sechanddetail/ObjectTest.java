package com.foxfound.log.sechanddetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class ObjectTest {
    public static void main(String[] args) {
        Object o = new Object();
        List<String> stringList = new ArrayList(10);
        stringList.add("11");
        stringList.add("11");
        stringList.parallelStream().forEach(string -> {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        ExecutorService executorService = new ThreadPoolExecutor(10, 1000,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//        executorService.execute(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        executorService.execute(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
