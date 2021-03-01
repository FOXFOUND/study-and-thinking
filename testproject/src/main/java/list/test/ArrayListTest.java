package list.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        System.out.println(integerList.size());
        for (int i = 0; i < 10; i++) {
            integerList.add(new Integer(i));
            System.out.println("i "+ integerList.size());
        }
        String s = "a";

        System.out.println("ok");
    }
}
