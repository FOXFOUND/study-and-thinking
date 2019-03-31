package com.foxfound.log.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class EventChainBuilder {
    public static EventList custom() {
        List<AbstractEventChainBase> abstractEventChainBaseList = new ArrayList<>();
        EventList eventList = new EventList();
        eventList.setEventList(abstractEventChainBaseList);
        return eventList;
    }

}
