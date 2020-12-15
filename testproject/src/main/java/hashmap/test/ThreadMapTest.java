package hashmap.test;

import com.alibaba.fastjson.JSON;
import com.test.pakcage.C;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadMapTest {

    /**
     *
     * Exception in thread "Thread-6" java.lang.ClassCastException: java.util.HashMap$Node cannot be cast to java.util.HashMap$TreeNode
     * 	at java.util.HashMap$TreeNode.moveRootToFront(HashMap.java:1835)
     * 	at java.util.HashMap$TreeNode.treeify(HashMap.java:1951)
     * 	at java.util.HashMap.treeifyBin(HashMap.java:772)
     * 	at java.util.HashMap.putVal(HashMap.java:644)
     * 	at java.util.HashMap.put(HashMap.java:612)
     * 	at hashmap.test.ThreadMapTest.lambda$main$0(ThreadMapTest.java:18)
     * 	at java.lang.Thread.run(Thread.java:748)
     * @param args
     */

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
         Map map = new HashMap<Integer, Integer>();
        AtomicInteger atomicInt = new  AtomicInteger(0);
        AtomicInteger errorThread = new  AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                while (atomicInt.get() < 1000000) {
                    try {

                        map.put(atomicInt.get(),atomicInt.get());
                    }catch (Exception e){
                        errorThread.incrementAndGet();
                        throw e;
                    }
                    atomicInt.incrementAndGet();
                }

            }).start();
        }

        /**
         * 10
         * 183
         */

        Thread.sleep(10*1000);
        System.out.println(errorThread);
        System.out.println(map.size());
    }


}
