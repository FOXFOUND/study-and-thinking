package object.test;

import java.util.concurrent.CountDownLatch;

public class VolatileTestTwo {


    CountDownLatch countDownLatch = new CountDownLatch(10);
    CountDownLatch countDownLatchTwo = new CountDownLatch(10);

    public void modify() {
        ValidateTest validateTest = new ValidateTest();
        System.out.println(validateTest.msg);
        validateTest.msg++;
        System.out.println(validateTest.msg);
    }

    public void modify2() {
        ValidateTest validateTest = new ValidateTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    //System.out.println(Thread.currentThread().getName() + "await");
                    countDownLatch.await();
                    //System.out.println(Thread.currentThread().getName() + "wake up");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(validateTest.msg + Thread.currentThread().getName());
                validateTest.msg++;
                //System.out.println(validateTest.msg + Thread.currentThread().getName());
                countDownLatchTwo.countDown();
            }).start();
            countDownLatch.countDown();
           // System.out.println("countDownLatch " + i);
        }

        try {
            countDownLatchTwo.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("11 is right =" + validateTest.msg);


    }



    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            VolatileTestTwo testTwo = new VolatileTestTwo();
            testTwo.modify2();
        }
    }

}
