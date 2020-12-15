package time.test;

import java.util.TimerTask;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
       // Future f1 = executor.submit(new Runnable() {
         executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
//                while (true){
//
//                }
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
               // System.out.println("world");
            Thread.currentThread().interrupt();
            }
        });
//        try {
//           // Object o = f1.get(1, TimeUnit.SECONDS);
//           // System.out.println(o);
//           //  executor.
//           // executor.shutdown();
//           // System.exit(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            //f1.cancel(true);
//            e.printStackTrace();
//        }

    }
}
