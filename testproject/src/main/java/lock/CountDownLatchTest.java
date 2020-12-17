package lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        countDownLatch.countDown();
        try {
            countDownLatch.await();
            System.out.println("wake up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * wake up
         */

    }
    public  void test() throws InterruptedException {

    }
}
