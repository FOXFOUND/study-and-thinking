package com.foxfound.log.sechanddetail;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class UtilClass {
    public static void main(String[] args) throws IOException {
        //buildOutsideSecHandInfo();
        //buildMap();
        //buildSecHandInfo();
        //buildTableRow();
    }

    private static void buildOutsideSecHandInfo() throws IOException {
        String readFilePath = "/Users/foxFound/Desktop/CompanyIn.txt";
        List<String> stringList = FileUtils.readLines(new File(readFilePath));
        List<String> rowList = new ArrayList<>();
        stringList.stream().forEach(line -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("inSideSecHandInfoIdSet.add(");
            stringBuilder.append(line);
            stringBuilder.append("L");
            stringBuilder.append(");");
            rowList.add(stringBuilder.toString());
        });

    }

    private static void buildMap() throws IOException {
        String logPath = "/Users/foxFound/Desktop/requestLog";
        String readFilePath = "/Users/foxFound/Desktop/old_request/old_request_result.txt";
        String saveFilePath = "/Users/foxFound/Desktop/SecHandInfoVisited.txt";
        String tempPath = "/Users/foxFound/Desktop/temp.txt";
        File fileDir = new File(logPath);
        List<String> fileList = new ArrayList<>();
        String[] fileArray = fileDir.list();
        Map<Long, Long> secHandInfoVisitedMap = new HashMap<>();
        for (int i = 0; i < fileArray.length; i++) {
            fileList.add(logPath + "/" + fileArray[i]);
        }
        List<String> secHandInfoVisitedMapInitList = FileUtils.readLines(new File(readFilePath));
        List<String> stringList = new ArrayList<>();
        secHandInfoVisitedMapInitList.forEach(line -> {
            String[] lineArray = line.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("recordRequestAndResponseMap.put(");
            stringBuilder.append(lineArray[0]);
            stringBuilder.append("L");
            stringBuilder.append(",");
            stringBuilder.append(lineArray[1]);
            stringBuilder.append("L");
            stringBuilder.append(");");
            stringList.add(stringBuilder.toString());
            //  secHandInfoVisitedMap.put(Long.parseLong(lineArray[0]), Long.parseLong(lineArray[1]));
        });
        FileUtils.writeLines(new File(tempPath), stringList);
    }

    public static void buildSecHandInfo() throws IOException {
        String readFilePath = "/Users/foxFound/Desktop/SecHandInfoVisited.txt";
        List<String> linesList = FileUtils.readLines(new File(readFilePath));
        buildSecHandInfoByList(linesList);
    }

    public static void buildSecHandInfoByList(List<String> linesList) throws IOException {
        Map<Long, String> secHandInfoMap = new HashMap<>();
        linesList.forEach(line -> {
            String[] lineArray = line.split(" ");
            secHandInfoMap.put(Long.parseLong(lineArray[0]), lineArray[1]);
        });
        String readCommentPath = "/Users/foxFound/Desktop/comment.txt";
        List<String> commentLineList = FileUtils.readLines(new File(readCommentPath));
        commentLineList.forEach(commentLine -> {
            String[] lineArray = commentLine.split(" ");
            Long key = Long.parseLong(lineArray[0].replace("\"", ""));
            String value = secHandInfoMap.get(key);
            String newValue = null;
            if (StringUtils.isBlank(value)) {
                newValue = 0 + " " + lineArray[1] + " " + lineArray[2].replace("\"", "");
            } else {
                newValue = value + " " + lineArray[1] + " " + lineArray[2].replace("\"", "");
            }
            secHandInfoMap.put(key, newValue);
        });
        //FileUtil.saveMapConcatWithEqual(saveFilePath, secHandInfoMap, " ");
        List<String> linesResultList = new ArrayList<>();
        for (Map.Entry entry : secHandInfoMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" ");
            stringBuilder.append(entry.getValue());
            linesResultList.add(stringBuilder.toString());
        }
        buildRowByList(linesResultList);
    }

    public static void buildTableRow() throws IOException {
        String readFilePath = "/Users/foxFound/Desktop/SecHandInfoVisitedWithComment.txt";
        List<String> lineList = FileUtils.readLines(new File(readFilePath));
        buildRowByList(lineList);
        return;
    }

    private static void buildRowByList(List<String> lineList) throws IOException {
        String savePath = "/Users/foxFound/Desktop/SecHandInfoVisitedWithCommentTable.txt";
        List<String> stringList = new ArrayList<>();
        lineList.forEach(line -> {
            String[] lineArray = line.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            if (lineArray.length == 3) {
                stringBuilder.append("<tr><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[0]);
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[2].replace("\"", ""));
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[1]);
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(0);
                stringBuilder.append("</td></tr>");
                stringList.add(stringBuilder.toString());
            } else {
                stringBuilder.append("<tr><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[0]);
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[2].replace("\"", ""));
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[1]);
                stringBuilder.append("</td><td class=\"confluenceTd\">");
                stringBuilder.append(lineArray[3]);
                stringBuilder.append("</td></tr>");
                stringList.add(stringBuilder.toString());
            }

        });
        FileUtils.writeLines(new File(savePath), stringList);
    }
}
