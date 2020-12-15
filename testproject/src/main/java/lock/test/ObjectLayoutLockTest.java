package lock.test;

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayoutLockTest {
    public static void main(String[] args) {

        /**
         * 加锁前**********************
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         *
         * ***********加锁时***********
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           98 f3 f8 02 (10011000 11110011 11111000 00000010) (49869720)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         *
         * *********************释放锁后*
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */

        Object lock = new Object();

        System.out.println("加锁前**********************");
        String layout0 = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout0);

        System.out.println("***********加锁时***********");
        synchronized (lock) {
            // -XX:BiasedLockingStartupDelay=0 偏向锁延时
            String layout1 = ClassLayout.parseInstance(lock).toPrintable();
            System.out.println(layout1);
        }

        System.out.println("*********************释放锁后*");
        String layout2 = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout2);
    }

}
