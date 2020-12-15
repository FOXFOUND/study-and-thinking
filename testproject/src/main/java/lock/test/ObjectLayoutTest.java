package lock.test;

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayoutTest {
    public static void main(String[] args) {
        /**
         *
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */

//        Object obj = new Object();
//        String layout = ClassLayout.parseInstance(obj).toPrintable();
//        System.out.println(layout);


        /**
         *
         * java.lang.Integer object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           ae 22 00 20 (10101110 00100010 00000000 00100000) (536879790)
         *      12     4    int Integer.value                             0
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */
//        int i = 0;
//        String layout = ClassLayout.parseInstance(i).toPrintable();
//        System.out.println(layout);


        /**
         * lock.test.IplusTest object internals:
         *  OFFSET  SIZE             TYPE DESCRIPTION                               VALUE
         *       0     4                  (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4                  (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4                  (object header)                           43 c1 00 20 (01000011 11000001 00000000 00100000) (536920387)
         *      12     4              int IplusTest.i                               12
         *      16     4    java.util.Map IplusTest.map                             (object)
         *      20     4   java.util.List IplusTest.list                            (object)
         * Instance size: 24 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */

//        IplusTest iplusTest = new IplusTest();
//        String layout = ClassLayout.parseInstance(iplusTest).toPrintable();
//        System.out.println(layout);


        /**
         * java.util.ArrayList object internals:
         *  OFFSET  SIZE                 TYPE DESCRIPTION                               VALUE
         *       0     4                      (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4                      (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4                      (object header)                           6b 2f 00 20 (01101011 00101111 00000000 00100000) (536883051)
         *      12     4                  int AbstractList.modCount                     0
         *      16     4                  int ArrayList.size                            0
         *      20     4   java.lang.Object[] ArrayList.elementData                     []
         * Instance size: 24 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */
//        ArrayList arrayList = new ArrayList();
//        String layout = ClassLayout.parseInstance(arrayList).toPrintable();
//        System.out.println(layout);


        /**
         * [I object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           6d 01 00 20 (01101101 00000001 00000000 00100000) (536871277)
         *      12     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *      16     4    int [I.<elements>                             N/A
         *      20     4        (loss due to the next object alignment)
         * Instance size: 24 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
//        int [] arr =new int[1];
//        String layout = ClassLayout.parseInstance(arr).toPrintable();
//        System.out.println(layout);


        /**
         * [D object internals:
         *  OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
         *       0     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4          (object header)                           b9 00 00 20 (10111001 00000000 00000000 00100000) (536871097)
         *      12     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *      16     8   double [D.<elements>                             N/A
         * Instance size: 24 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */
        double [] arr = new double[1];
        String layout = ClassLayout.parseInstance(arr).toPrintable();
        System.out.println(layout);
    }
}
