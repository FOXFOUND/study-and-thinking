package com.foxfound.log.util;

import com.alibaba.fastjson.JSON;
import com.foxfound.log.constant.InsideSecHandInfoId;
import com.foxfound.log.vo.EventVO;
import com.foxfound.log.vo.RequestAndResponseVO;
import com.foxfound.log.vo.SecHandInfoDataVO;
import com.foxfound.log.vo.SecHandInfoDetailVO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class LogProcessUtil {
    public static List<EventVO> getEventVOListByPathAndPattern(String logPath, String logPattern) {
        List<String> logFilePathList = getLogFiles(logPath, logPattern);
        //获取日志对象集合
        List<EventVO> eventVOList = new ArrayList<>();
        logFilePathList.forEach(logFilePath -> {
            List<String> linesList = null;
            try {
                linesList = FileUtils.readLines(new File(logFilePath), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();

            }
            if (linesList == null) {
                return;
            }
            linesList.forEach(line -> {
                String[] columnArray = line.split("\t");
                EventVO eventVO = VOUtil.convertColumnArrayToEventVO(columnArray);
                if (eventVO != null) {
                    eventVOList.add(eventVO);
                }
            });

        });
        return eventVOList;
    }

    public static List<String> getLogFiles(String logPath, String logPattern) {
        File fileDir = new File(logPath);
        String[] fileArray = fileDir.list();
        //获取所有相关日志文件
        List<String> logFilePathList = new ArrayList<String>();
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].contains(logPattern)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(logPath);
                stringBuilder.append("/");
                stringBuilder.append(fileArray[i]);
                logFilePathList.add(stringBuilder.toString());
            }
        }
        return logFilePathList;
    }

    public static List<SecHandInfoDataVO> getSecHandInfoDataVOListByPathAndPattern(String logPath, String logPattern) {
        List<String> logFilePathList = getLogFiles(logPath, logPattern);
        List<SecHandInfoDataVO> secHandInfoDataVOList = new ArrayList<>();
        Map<Long, Long> secHandInfoVisitedMap = new HashMap<>();
        initSecHandInfoVisitedMap(logFilePathList, secHandInfoVisitedMap);
        secHandInfoVisitedMap.forEach((key, value) -> {
            SecHandInfoDataVO secHandInfoDataVO = new SecHandInfoDataVO();
            secHandInfoDataVO.setSecHandInfoId(key);
            secHandInfoDataVO.setVisitedCount(value);
            secHandInfoDataVOList.add(secHandInfoDataVO);
        });
        return secHandInfoDataVOList;
    }

    private static void initSecHandInfoVisitedMap(List<String> logFilePathList, Map<Long, Long> secHandInfoVisitedMap) {
        logFilePathList.forEach(logFilePath -> {
            List<String> linesList = null;
            try {
                linesList = FileUtils.readLines(new File(logFilePath), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();

            }
            if (linesList == null) {
                return;
            }
            linesList.forEach(line -> {
                String[] lineArray = line.split("\t");
                if (lineArray.length < 4) {
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
    }
}
