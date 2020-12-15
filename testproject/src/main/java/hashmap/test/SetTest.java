package hashmap.test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");
        System.out.println(strings.size());
        strings.remove("1");
        System.out.println(strings.size());
    }
}
