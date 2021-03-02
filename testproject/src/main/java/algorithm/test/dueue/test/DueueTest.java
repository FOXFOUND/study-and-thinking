package algorithm.test.dueue.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DueueTest {
    public static void main(String[] args) {
        Deque queue = new ArrayDeque();
        queue.add(1);
        queue.add(2);
//        System.out.println(queue.getFirst());
//        System.out.println(queue.getFirst());
//        System.out.println(queue.peekFirst());
//        System.out.println(queue.peekFirst());

        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());

    }
}
