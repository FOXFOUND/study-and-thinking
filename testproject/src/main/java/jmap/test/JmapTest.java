package jmap.test;

import java.util.HashMap;
import java.util.Map;

public class JmapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Person> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            Person person = new Person();
            person.setName("" + i);
            person.setAge("" + i);

            map.put(i, person);
            if(i % 100 == 0){
                System.out.println(i);
                Thread.sleep(100);
            }
        }
        System.out.println("done");
    }
}
