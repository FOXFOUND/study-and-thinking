package com.foxfound.log.util;

import com.foxfound.log.vo.EventResultVO;

import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class EventResultVOUtil {
    public static EventResultVO getEventResultVOByName(List<EventResultVO> eventResultVOList, String className) {
        EventResultVO eventResultVOEnterFriendSay = null;
        for (int i = 0; i < eventResultVOList.size(); i++) {
            EventResultVO tempEventResultVO = eventResultVOList.get(i);
            if (tempEventResultVO.getClassName().equals(className)) {
                eventResultVOEnterFriendSay = tempEventResultVO;
                break;
            }
        }
        return eventResultVOEnterFriendSay;
    }
}
