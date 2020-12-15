package lock.test;

public class ViolidateTest {
    volatile int s =  1;

    public int test() {
        new Thread(() -> {
            s = 2;

        }).start();
        new Thread(() -> {
            s = 3;

        }).start();
        return 1;
    }
}
