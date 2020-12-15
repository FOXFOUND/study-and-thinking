package string.test;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Objects;

public class SplitTest {
    public static void main(String[] args) {
       // String systemRoleId = " 783657135425589248; 783744918391492608; 784000816330444800;783280519566462976";
        String systemRoleId = " 784000816330444800;784073621633896448";
        String roleId ="784000816330444800";
        String[] roles = systemRoleId.split(";");
        ArrayList<String> strings = new ArrayList<>();
        for (String role : roles) {
            if (!role.trim().equals(roleId)) {
                strings.add(role.trim());
            }
        }
        //清除了当前角色关联后重新拼接成,分开形式
        String userRole = String.join(";", strings);
        System.out.println(userRole);


//        String roleIdTest = " 784000816330444800";
//        System.out.println(roleIdTest.trim().equals(roleId));

    }
}
