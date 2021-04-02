package hashmap.test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class HashMapTest {
    public static void main(String[] args) {

        Map treeMap =new TreeMap();
        treeMap.put("1","1");

        Map linkHashMap =new  LinkedHashMap();

        Map map = new HashMap<>();
        map.put("1", 1);
        map.remove("1", 1);
        System.out.println("1");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", 1);
        concurrentHashMap.size();
        concurrentHashMap.remove("1");

        CopyOnWriteArrayList copyOnWriteArrayList;
        ArrayBlockingQueue arrayBlockingQueue;
        ArrayList arrayList;
        /**
         * linkedHashMap可以实现insert和remove,select实现O(1)的时间复杂度
         * 相比于直接使用链表的时间复杂度O(n)
         */
        Map map1 = new LinkedHashMap();
        map1.put("1","1");
        map1.remove("1");


    }

    public static int finallyTest() {

        /**
         *  // access flags 0x9
         *   public static finallyTest()I
         *     TRYCATCHBLOCK L0 L1 L2 null
         *    L0
         *     LINENUMBER 27 L0
         *     ICONST_1
         *     ISTORE 0
         *    L3
         *     LINENUMBER 28 L3
         *     ILOAD 0
         *     ISTORE 1
         *    L1
         *     LINENUMBER 30 L1
         *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
         *     LDC "ok"
         *     INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
         *    L4
         *     LINENUMBER 28 L4
         *     ILOAD 1
         *     IRETURN
         *    L2
         *     LINENUMBER 30 L2
         *    FRAME SAME1 java/lang/Throwable
         *     ASTORE 2
         *     GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
         *     LDC "ok"
         *     INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
         *    L5
         *     LINENUMBER 31 L5
         *     ALOAD 2
         *     ATHROW
         *     LOCALVARIABLE a I L3 L2 0
         *     MAXSTACK = 2
         *     MAXLOCALS = 3
         * }
         */


        /**
         *   public static int finallyTest();
         *     Code:
         *        0: iconst_1
         *        1: istore_0
         *        2: iload_0
         *        3: istore_1
         *        4: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *        7: ldc           #12                 // String ok
         *        9: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         *       12: iload_1
         *       13: ireturn
         *       14: astore_2
         *       15: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *       18: ldc           #12                 // String ok
         *       20: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         *       23: aload_2
         *       24: athrow
         *     Exception table:
         *        from    to  target type
         *            0     4    14   any
         * }
         */
        try {
            int a = 1;
            return a;
        } finally {
            System.out.println("ok");
        }
    }
}
