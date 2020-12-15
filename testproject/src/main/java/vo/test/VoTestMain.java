package vo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class VoTestMain {
    public static void main(String[] args) {
        VoTest voTest1 = new VoTest(1,"测试1");
        VoTest voTest3 = new VoTest(3,"测试3");
        VoTest voTest2 = new VoTest(2,"测试2");
        List<VoTest> voTestList = new ArrayList<>();
        voTestList.add(voTest1);
        voTestList.add(voTest3);
        voTestList.add(voTest2);
        System.out.println(JSONObject.toJSONString(voTestList));
        Collections.sort(voTestList,new Comparator<VoTest>(){
            @Override
            public int compare(VoTest arg0, VoTest arg1) {
                return arg0.getId().compareTo(arg1.getId());
            }
        });
        System.out.println(JSONObject.toJSONString(voTestList));
        // 获取司机id集合
//        List<Integer> driverIdList = voTestList.stream().map(VoTest::getId).collect(toList());
//        System.out.println(JSONObject.toJSONString(driverIdList));
    }
}
