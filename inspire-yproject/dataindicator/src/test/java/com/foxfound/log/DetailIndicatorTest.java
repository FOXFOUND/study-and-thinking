package com.foxfound.log;

import com.foxfound.log.event.AbstractEventChainBase;
import com.foxfound.log.util.BuildEventUtil;
import com.foxfound.log.util.EventLogDataUtil;
import com.foxfound.log.util.LogProcessUtil;
import com.foxfound.log.vo.EventVO;

import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class DetailIndicatorTest {
    //enterFriendSay  ,  clickAuthBtn ,  agreeAuth , exitFriendSay
    public static void main(String[] args) {
        String logPath = "/Users/Desktop/logs";
        String logPattern = "event";
        AbstractEventChainBase.LastDay = "2019-03-13";
        List<EventVO> eventVOList = LogProcessUtil.getEventVOListByPathAndPattern(logPath, logPattern);
        AbstractEventChainBase chainHead = BuildEventUtil.buildProcessChain();
        eventVOList.parallelStream().forEach(eventVO -> {
            chainHead.process(eventVO);
        });
        chainHead.printSelf();
        EventLogDataUtil.getDetailUserActionData();
    }

}
