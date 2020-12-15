package jsontest;

import com.alibaba.fastjson.JSON;

public class NullObjectTest {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(null));
    }
}
