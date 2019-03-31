package com.foxfound.log.event;

import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class EventList {
    private List<AbstractEventChainBase> eventList;

    public List<AbstractEventChainBase> getEventList() {
        return eventList;
    }

    public void setEventList(List<AbstractEventChainBase> eventList) {
        this.eventList = eventList;
    }

    public EventList append(AbstractEventChainBase abstractEventChainBase) {
        int lastIndex = eventList.size() - 1;
        if (lastIndex >= 0) {
            AbstractEventChainBase lastNode = eventList.get(lastIndex);
            lastNode.setNextNode(abstractEventChainBase);
        }
        eventList.add(abstractEventChainBase);
        return this;
    }

    public AbstractEventChainBase build() {
        return eventList.get(0);
    }
}
