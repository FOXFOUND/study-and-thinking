package com.foxfound.log.sechanddetail;

import com.alibaba.fastjson.JSON;
import com.foxfound.log.constant.InsideSecHandInfoId;
import com.foxfound.log.util.FileUtil;
import com.foxfound.log.vo.RequestAndResponseVO;
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
 * @Date 2019-03-14
 */
public class SecHandDetailTestForOld {
    public static void main(String[] args) throws IOException {
        String logPath = "/Users/foxFound/Desktop/old_request";
        String saveFilePath = "/Users/foxFound/Desktop/old_request_result.txt";
        File fileDir = new File(logPath);
        List<String> fileList = new ArrayList<>();
        String[] fileArray = fileDir.list();
        Map<Long, Long> secHandInfoVisitedMap = new HashMap<>();
        //初始化文件 handler
        for (int i = 0; i < fileArray.length; i++) {
            fileList.add(logPath + "/" + fileArray[i]);
        }
        //遍历文件统计结果
        fileList.forEach(filePath -> {
            List<String> lineList = null;
            try {
                lineList = FileUtils.readLines(new File(filePath), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            lineList.forEach(line -> {
                String[] lineArray = line.split("\t");
                if (!lineArray[6].equals("detail") || !lineArray[5].equals("cc.linkedme.friendsay.controller.SecHandInfoController")) {
                    return;
                }
                RequestAndResponseVO requestAndResponseVO = new RequestAndResponseVO();
                List<SecHandInfoDetailVO> secHandInfoDetailVOList = null;
                try {
                    secHandInfoDetailVOList = JSON.parseArray(lineArray[8], SecHandInfoDetailVO.class);
                } catch (Exception e) {
                }
                if (secHandInfoDetailVOList == null) {
                    return;
                }
                SecHandInfoDetailVO secHandInfoDetailVO = secHandInfoDetailVOList.get(0);
                long secHandInfoId = secHandInfoDetailVO.getSecHandInfoId();
                if (InsideSecHandInfoId.inSideSecHandInfoIdSet.contains(secHandInfoId)) {
                    return;
                }
                Long key = secHandInfoDetailVO.getSecHandInfoId();
                Long visitedCount = secHandInfoVisitedMap.get(key);
                if (visitedCount == null) {
                    visitedCount = 0L;
                }
                visitedCount = visitedCount + 1;
                secHandInfoVisitedMap.put(key, visitedCount);
            });

        });
        //统计结果
        FileUtil.saveMapConcatWithEqual(saveFilePath, secHandInfoVisitedMap, " ");

    }

}
