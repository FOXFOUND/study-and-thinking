package com.foxfound.log.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class FileUtil {
    public static <K, V> void saveMapConcatWithEqual(String saveFilePath, Map<K, V> secHandInfoVisitedMap, String split) throws IOException {
        if (split == null) {
            split = "=";
        }
        List<String> linesList = new ArrayList<>();
        for (Map.Entry entry : secHandInfoVisitedMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(split);
            stringBuilder.append(entry.getValue());
            linesList.add(stringBuilder.toString());
        }
        FileUtils.writeLines(new File(saveFilePath), linesList);
    }

}
