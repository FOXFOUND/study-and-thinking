package string.test;

import org.apache.commons.lang.ArrayUtils;

public class ArrayTest {
    public static void main(String[] args) {
        String systemRoleId = "";
        String[] roles = systemRoleId.split(";");
        if (ArrayUtils.isEmpty(roles)) {
            System.out.println("false");
        }
        System.out.println("ok");
    }
}
