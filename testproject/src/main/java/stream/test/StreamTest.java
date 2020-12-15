package stream.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.stream().map(x->x+1).forEach(System.out::println);
//        Stream.of()
        List<List<Integer>> lists = new ArrayList<>();
        lists.stream().flatMap(pList -> pList.stream()).count();

        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(22);
                add(22);
                add(23);
                add(159);
                add(12);
            }
        };


        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
