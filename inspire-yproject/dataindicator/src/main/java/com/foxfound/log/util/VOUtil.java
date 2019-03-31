package com.foxfound.log.util;

import com.foxfound.log.vo.EventVO;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class VOUtil {
    public static EventVO convertColumnArrayToEventVO(String[] fileLineArray) {
        if (fileLineArray == null || fileLineArray.length == 0) {
            return null;
        }
        EventVO eventVO = new EventVO();
        return eventVO;
    }
}
