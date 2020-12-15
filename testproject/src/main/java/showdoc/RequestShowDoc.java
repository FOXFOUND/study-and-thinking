package showdoc;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestShowDoc {

//    public static String getStr(){
//        return "";
//    }

    public static String getStr() {
        return "{\n" +
                "\t\"cmd\": \"segTrackData\",\n" +
                "\t\"params\": {\n" +
                "\t\t\"objId\": \"20030510590410633\",\n" +
                "\t\t\"beginTime\": \"2020-03-07 18:27:26\",\n" +
                "\t\t\"endTime\": \"2020-03-07 20:27:26\",\n" +
                "\t\t\"alarmType\": \"6\",\n" +
                "\t\t\"compressType\": \"0\",\n" +
                "\t\t\"showZeroLngLat\": \"0\",\n" +
                "\t\t\"operUserId\": \"a9de55e05511421f91b656499b782e15\"\n" +
                "\t}\n" +
                "}";
    }
    public static void main(String[] args) {
        String jsonStr = getStr();
        StringBuilder sb = new StringBuilder();
        Gson gson = new Gson();
        JsonObject jo = (JsonObject) gson.fromJson(jsonStr, JsonObject.class);
        jo.entrySet().forEach(entry -> removeArrayEle(entry.getValue()));
        analysisJsonStr(sb, jo);
        // sb.append("**\n\n```\n").append(formatJson(jsonStr.toString())).append("\n```\n\n**\n\n|\n|:-----|:-----|-----| |\n");
        System.out.println(sb.toString());
    }
    public static void removeArrayEle(Object val) {
        if (val instanceof JsonArray) {
            JsonArray arr = (JsonArray)val;
            int len = arr.size();
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    arr.remove(1);
                } else {
                    Object v = arr.get(i);
                    removeArrayEle(v);
                }
            }
        } else if (val instanceof JsonObject) {
            JsonObject jo = (JsonObject)val;
            jo.entrySet().forEach(next -> removeArrayEle(next.getValue()));
        }
    }
    public static void analysisJsonStr(StringBuilder sb, Object json) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        Object jo = json;
        if (jo instanceof JsonObject) {
            analysisJson(map, (JsonObject)jo, "");
        } else if (jo instanceof JsonArray) {
            JsonArray ja = (JsonArray)jo;
            Object subjo = ja.get(0);
            if (subjo instanceof JsonObject)
                analysisJson(map, (JsonObject)subjo, "");
        } else {
            sb.append("**result").append(jo);
        }
        analysisMap(map, sb, "");
    }

    private static String getValueType(Object value1) {
        if (value1 instanceof JsonPrimitive) {
            JsonPrimitive jp = (JsonPrimitive)value1;
            if (jp.isNumber() && jp.toString().contains("."))
                return "Double";
            return jp.isBoolean() ? "Boolean" : (jp.isNumber() ? "Integer" : (jp.isString() ? "String" : "String"));
        }
        if (value1 instanceof JsonObject || value1 instanceof LinkedHashMap)
            return "Object[data]";
        return "String";
    }

    private static void analysisMap(LinkedHashMap<Object, Object> map, StringBuilder sb, String key1) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LinkedHashMap) {
                sb.append("|").append(key).append("|").append(getValueType(value)).append("|  |  |\n");
                continue;
            }
            if (!key.equals(key1))
                sb.append("|").append(key).append("|").append(getValueType(value)).append("|  |  |\n");
        }
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals(key1))
                continue;
            if (value instanceof LinkedHashMap) {
                sb.append("\n\n**").append(key).append("  **\n\n").append("\n\n|参数名|类型|说明|必选|\n|:-----|:-----|-----| |\n");
                analysisMap((LinkedHashMap<Object, Object>)value, sb, key.toString());
            }
        }
    }

    public static void analysisJson(LinkedHashMap<Object, Object> treeMap, JsonObject json, String tmp) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        json.entrySet().forEach(t -> {
            Object k = t.getKey();
            Object val = t.getValue();
            if (val instanceof JsonObject) {
                map.put(tmp + k, val);
            } else if (val instanceof JsonArray) {
                JsonArray arr = (JsonArray)val;
                map.put(tmp + k, (arr.size() > 0) ? arr.get(0) : "");
            } else {
                treeMap.put(tmp + k, val);
            }
        });
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            LinkedHashMap<Object, Object> tmpMap = new LinkedHashMap<>();
            tmpMap.put(key, value);
            treeMap.put(key, tmpMap);
        }
        for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (value instanceof LinkedHashMap) {
                LinkedHashMap<Object, Object> v = (LinkedHashMap<Object, Object>)value;
                if (v.get(key) instanceof JsonObject)
                    analysisJson(v, (JsonObject)v.get(key), tmp + "  ");
            }
        }
    }


    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr))
            return "";
        if (jsonStr.startsWith("["))
            return JSONArray.fromObject(jsonStr).toString(2, 2);
        if (jsonStr.startsWith("{"))
            return JSONObject.fromObject(jsonStr).toString(2, 2);
        return jsonStr;
    }
}
