package queue.test;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(10);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        arrayBlockingQueue.offer("1");
        linkedBlockingQueue.offer("1");
        synchronousQueue.offer("1");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

    }
}
