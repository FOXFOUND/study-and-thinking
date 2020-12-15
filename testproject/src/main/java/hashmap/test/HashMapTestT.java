package hashmap.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTestT {
    public static void main(String[] args) {
        Map map = new HashMap<String,String>();
        map.put("1","1");
        System.out.println(map.get("2"));
    }
}
