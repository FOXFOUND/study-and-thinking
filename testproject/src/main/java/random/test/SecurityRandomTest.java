package random.test;

import java.security.SecureRandom;

public class SecurityRandomTest {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i <10 ; i++) {
            int k = secureRandom.nextInt();
            System.out.println(k);
            test(test1());
        }
    }

    private static Object test1() {
        return null;
    }

    private static void test(Object o) {
        int i = 10;
        System.out.println(i);
    }
}
