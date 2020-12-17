package lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkBlankingQueueTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        for (int i = 0; i < 11; i++) {
            linkedBlockingQueue.add(i);
            linkedBlockingQueue.offer(i);
            try {
                linkedBlockingQueue.offer(i,10, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /**
             *
             *       linkedBlockingQueue.add(i);
             *
             * Exception in thread "main" java.lang.IllegalStateException: Queue full
             * 	at java.util.AbstractQueue.add(AbstractQueue.java:98)
             * 	at lock.LinkBlankingQueueTest.test(LinkBlankingQueueTest.java:14)
             * 	at lock.LinkBlankingQueueTest.main(LinkBlankingQueueTest.java:7)
             */
            try {
                linkedBlockingQueue.put(i);
                /**
                 * 1
                 * ...
                 * 7
                 * 8
                 * 9
                 *
                 * 处于等待状态
                 */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        try {
            linkedBlockingQueue.take();
            linkedBlockingQueue.poll();
            linkedBlockingQueue.poll(10,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
