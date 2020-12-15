package lock.test;

import java.util.concurrent.locks.ReentrantLock;

public class RerantLockTest {
    public static void main(String[] args) {
        final ReentrantLock  reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
