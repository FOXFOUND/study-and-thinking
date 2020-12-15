package lock.optimiter;

public class Demo {
    static volatile int i = 0;
    static volatile int j = 0;

    public static void n() {
        i++;
    }

    public static synchronized void m() {
        j++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100_0000; j++) {
            m();
            n();
        }
        System.out.println(i);
        System.out.println(j);
    }
}
