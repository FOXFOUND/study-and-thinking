package showdoc;


import com.alibaba.fastjson.JSON;
import com.google.gson.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseShowDoc {

//    public static String getStr(){
//        return "";
//    }

    public static String getStr() {
        return "{\n" +
                "\t\"cmd\": \"vehiclePropertyV1\",\n" +
                "\t\"result\": 0,\n" +
                "\t\"resultNote\": \"SUCCESS\",\n" +
                "\t\"totalRecordNum\": 1,\n" +
                "\t\"pages\": 1,\n" +
                "\t\"pageNo\": 0,\n" +
                "\t\"detail\": {\n" +
                "\t\t\"vehicleId\": \"20030115442680053\",\n" +
                "\t\t\"objType\": 1,\n" +
                "\t\t\"publicStatus\": 1,\n" +
                "\t\t\"productId\": \"913\",\n" +
                "\t\t\"productName\": \"\",\n" +
                "\t\t\"brandId\": \"11\",\n" +
                "\t\t\"brandName\": \"\",\n" +
                "\t\t\"deptId\": \"\",\n" +
                "\t\t\"corpId\": \"dfcx\",\n" +
                "\t\t\"insuraceStartTime\": \"2021-03-20\",\n" +
                "\t\t\"insuraceDueTime\": \"2021-03-20\",\n" +
                "\t\t\"vehicleAuditTime\": \"2021-03-20\",\n" +
                "\t\t\"idName\": \"测试二\",\n" +
                "\t\t\"lpno\": \"测A14515\",\n" +
                "\t\t\"vin\": \"WDDSJ5CBXFN145340\",\n" +
                "\t\t\"engineNumber\": \"4578457457415\",\n" +
                "\t\t\"deptName\": \"东风出行\",\n" +
                "\t\t\"currentMiles\": 51.8,\n" +
                "\t\t\"maintainMile\": 5000,\n" +
                "\t\t\"ownerName\": \"东风出行\",\n" +
                "\t\t\"currentDistance\": \"51.8\",\n" +
                "\t\t\"valueMethod\": \"1\",\n" +
                "\t\t\"storageBatteryVoltage\": \"15.7\",\n" +
                "\t\t\"electricMotorcycleType\": \"\",\n" +
                "\t\t\"electricMotorcyclePhone\": \"\",\n" +
                "\t\t\"electricMotorcycleIcon\": \"\",\n" +
                "\t\t\"realName\": \"\",\n" +
                "\t\t\"mobilePhone\": \"\",\n" +
                "\t\t\"sex\": \"0\",\n" +
                "\t\t\"birthday\": \"\"\n" +
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
                sb.append("\n\n**").append(key).append("  **\n\n").append("\n\n|参数名|类型|说明|备注|\n|:-----|:-----|-----| |\n");
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
