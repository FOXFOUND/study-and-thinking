package thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        //ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor();
        //ExecutorService threadPoolExecutor =  Executors.newFixedThreadPool(4);
        ExecutorService threadPoolExecutor =  Executors.newScheduledThreadPool(4);
        threadPoolExecutor.execute(()->{

        });
    }
}
