package com.foxfound.log.sechanddetail;

import com.alibaba.fastjson.JSON;
import com.foxfound.log.constant.InsideSecHandInfoId;
import com.foxfound.log.constant.RecordRequestAndResponseMap;
import com.foxfound.log.vo.RequestAndResponseVO;
import com.foxfound.log.vo.SecHandInfoDetailVO;
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
public class SecHandDetailTestForNew {
    public static void main(String[] args) throws IOException {
        String logPath = "/Users/Desktop/requestLog";
        File fileDir = new File(logPath);
        List<String> fileList = new ArrayList<>();
        String[] fileArray = fileDir.list();
        Map<Long, Long> secHandInfoVisitedMap = RecordRequestAndResponseMap.recordRequestAndResponseMap;
        for (int i = 0; i < fileArray.length; i++) {
            fileList.add(logPath + "/" + fileArray[i]);
        }
        fileList.forEach(filePath -> {
            List<String> lineList = null;
            try {
                lineList = FileUtils.readLines(new File(filePath), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            lineList.forEach(line -> {
                String[] lineArray = line.split("\t");
                if (!lineArray[2].equals("detail") || !lineArray[1].equals("SecHandInfoController")) {
                    return;
                }
                RequestAndResponseVO requestAndResponseVO = new RequestAndResponseVO();
                Map argMap = JSON.parseObject(lineArray[3], Map.class);
                List<SecHandInfoDetailVO> secHandInfoDetailVOList = JSON.parseArray(String.valueOf(argMap.get("args")), SecHandInfoDetailVO.class);
                if (secHandInfoDetailVOList == null) {
                    return;
                }
                SecHandInfoDetailVO secHandInfoDetailVO = secHandInfoDetailVOList.get(0);
                Long key = secHandInfoDetailVO.getSecHandInfoId();
                if (InsideSecHandInfoId.inSideSecHandInfoIdSet.contains(key)) {
                    return;
                }
                Long visitedCount = secHandInfoVisitedMap.get(key);
                if (visitedCount == null) {
                    visitedCount = 0L;
                }
                visitedCount = visitedCount + 1;
                secHandInfoVisitedMap.put(key, visitedCount);
            });

        });
        //统计结果
        //String saveFilePath = "/Users/foxFound/Desktop/SecHandInfoVisited.txt";
        //FileUtil.saveMapConcatWithEqual(saveFilePath, secHandInfoVisitedMap," ");
        List<String> linesList = new ArrayList<>();
        for (Map.Entry entry : secHandInfoVisitedMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" ");
            stringBuilder.append(entry.getValue());
            linesList.add(stringBuilder.toString());
        }
        UtilClass.buildSecHandInfoByList(linesList);
    }
}