package random.test;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i <10 ; i++) {
            int k = r.nextInt();
            System.out.println(k);
        }


    }
}
