package statcclass.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


public class StaticOne {

    private static class MyHandler extends Handler {

        public void test(){

        }
        //WeakReference<MainActivity> weakReference;
        SoftReference<MainActivity> weakReference;

//        MyHandler(MainActivity activity) {
//            weakReference = new WeakReference<>(activity);
//        }
        MyHandler(MainActivity activity) {
            /**
             * hello
             * world
             * statcclass.test.StaticClassTest@2ff4acd0
             * statcclass.test.StaticClassTest@2ff4acd0
             */
            weakReference = new SoftReference<>(activity);
        }
    }

    private MyHandler handler = new MyHandler(new StaticClassTest()) {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("world");
            System.out.println(weakReference.get());
            System.gc();
            System.out.println(weakReference.get());

            super.handleMessage(msg);
        }
    };

    public void say() {
        System.out.println("hello");
        handler.handleMessage(new Message());
    }
    StaticOne() {

    }
}
