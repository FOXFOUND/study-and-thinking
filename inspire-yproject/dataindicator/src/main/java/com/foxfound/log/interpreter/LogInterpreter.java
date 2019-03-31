package com.foxfound.log.interpreter;

import com.foxfound.log.constant.LogTypeEnum;
import com.foxfound.log.event.AbstractEventChainBase;
import com.foxfound.log.util.*;
import com.foxfound.log.vo.EventVO;
import com.foxfound.log.vo.SecHandInfoDataVO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class LogInterpreter {
    public static void interpreter(String[] args) {
        if (args == null || args.length != 4) {
            return;
        }
        String logPath = args[0];
        String logPattern = args[1];
        String saveEventResultFilePath = args[2];
        int logType = Integer.parseInt(args[3]);
        switch (LogTypeEnum.getByValue(logType)) {
            case EVENT_LOG:
                parseEventLog(logPath, logPattern, saveEventResultFilePath);
                break;
            case REQUEST_RESPONSE_LOG:
                parseRequestAndResponseLog(logPath, logPattern, saveEventResultFilePath);
                break;

        }
    }

    private static void parseRequestAndResponseLog(String logPath, String logPattern, String saveFilePath) {
        List<SecHandInfoDataVO> secHandInfoDataVOList = LogProcessUtil.getSecHandInfoDataVOListByPathAndPattern(logPath, logPattern);
        List<String> lineList = RequestAndResponseLogDataUtil.getSecHandInfoDetailByRequestAndResponse(secHandInfoDataVOList);
        String savePath = saveFilePath + "/" + "secHandInfo-" + DateUtil.getCurrentDate() + ".txt";
        try {
            FileUtils.writeLines(new File(savePath), lineList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void parseEventLog(String logPath, String logPattern, String saveFilePath) {
        AbstractEventChainBase.LastDay = DateUtil.getLastDate();
        List<EventVO> eventVOList = LogProcessUtil.getEventVOListByPathAndPattern(logPath, logPattern);
        AbstractEventChainBase chainHead = BuildEventUtil.buildProcessChain();
        eventVOList.parallelStream().forEach(eventVO -> {
            chainHead.process(eventVO);
        });
        chainHead.printSelf();
        EventLogDataUtil.recordDetailUserActionData(saveFilePath);
    }
}
