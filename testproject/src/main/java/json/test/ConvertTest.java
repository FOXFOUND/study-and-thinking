package json.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertTest {
    public static void main(String[] args) {
        String r ="{\"resultCode\":0,\"encryp\":false,\"content\":{\"failImportDeviceIdList\":\"[1111,2222]\"},\"resultMsg\":\"操作成功\"}";
        String s ="{\"resultCode\":0,\"resultMsg\":\"操作成功\",\"content\":{\"failImportDeviceIdList\":\"[]\"},\"encryp\":false}";
        JSONObject obj = JSONObject.parseObject(r);
        JSONObject content = obj.getObject("content",JSONObject.class);
        System.out.println(obj);
        System.out.println(content);
        String failImportDeviceIdListStr = "";
        if (content != null) {
            failImportDeviceIdListStr =  content.getString("failImportDeviceIdList");
        }
        System.out.println(failImportDeviceIdListStr);
        List<String> resFailImportDeviceIdList = JSON.parseArray(failImportDeviceIdListStr, String.class);
        System.out.println(JSON.toJSONString(resFailImportDeviceIdList));

    }
}
