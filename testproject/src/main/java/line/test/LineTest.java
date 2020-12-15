package line.test;

import java.util.Arrays;
import java.util.List;

public class LineTest {
    private String a;
    public static void main(String[] args) {
        int a = 0;
        tryADD:
        if (a != 10){

            System.out.println(a++);
            break tryADD;

        }

        System.out.println("ok");
        LineTest lineTest = new LineTest();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(System.out::println);
    }
}
