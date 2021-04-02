package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {


    public static void main(String[] args) throws IllegalAccessException {
        /**
         *   //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
         *         objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
         *   通过设置改变FastJSON序列化的逻辑,将date类型设置成字符串
         */
        Person person = new Person();
        person.setCreateOn(new Date());
      //  System.out.println(JSON.toJSONString(person));
        Map<String, Object> res = objectToMap(person);
        System.out.println(JSON.toJSONString(res, SerializerFeature.PrettyFormat));
    }
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
