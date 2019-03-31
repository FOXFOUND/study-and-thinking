package com.foxfound.log.event;

import com.foxfound.log.constant.CompanyUserId;
import com.foxfound.log.vo.EventResultVO;
import com.foxfound.log.vo.EventVO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public abstract class AbstractEventChainBase {
    public static List<EventResultVO> eventResultVOList = new ArrayList<>();
    public static String LastDay;
    public static Long startCountDay = 20190313L;
    private String page;
    private String event;
    private AbstractEventChainBase nextNode;
    private AtomicInteger totalCount = new AtomicInteger(0);
    private AtomicInteger currentDayCount = new AtomicInteger(0);
    private AtomicInteger totalUserIdIsNullCount = new AtomicInteger(0);
    private AtomicInteger currentUserIdIsNullCount = new AtomicInteger(0);

    public boolean process(EventVO eventVO) {
        if (CompanyUserId.userIdSet.contains(eventVO.getUserId())) {
            return true;
        }
        if (eventVO.getPage().equals(page) && eventVO.getEventName().equals(event)) {
            processEventVO(eventVO);
            return true;
        }
        if (nextNode != null) {
            return nextNode.process(eventVO);
        } else {
            return false;
        }
    }

    private void processEventVO(EventVO eventVO) {
        Long eventVODayLong = Long.parseLong(eventVO.getDate().replace("-", ""));
        if (eventVODayLong < startCountDay) {
            return;
        }
        if (eventVO.getDate().equals(LastDay)) {
            currentDayCount.addAndGet(1);
            if (eventVO.getUserId().equals(0L)) {
                currentUserIdIsNullCount.addAndGet(1);
            }
            processEventVOWhenCurrentDay(eventVO);
        }
        if (eventVO.getUserId().equals(0L)) {
            totalUserIdIsNullCount.addAndGet(1);
        }
        totalCount.addAndGet(1);
        processEventVONotCurrentDay(eventVO);
    }

    protected abstract void processEventVONotCurrentDay(EventVO eventVO);

    protected abstract void processEventVOWhenCurrentDay(EventVO eventVO);

    public void printSelf() {
        String className = this.getClass().getName();
        EventResultVO eventResultVO = getEventResultVO(className);
        eventResultVOList.add(eventResultVO);
        printSelfCustom();
        if (nextNode != null) {
            nextNode.printSelf();
        }

    }

    private EventResultVO getEventResultVO(String className) {
        String[] classNameSplitNameArray = className.split("\\.");
        String subClassName = classNameSplitNameArray[classNameSplitNameArray.length - 1];
        EventResultVO eventResultVO = new EventResultVO();
        eventResultVO.setClassName(subClassName);
        eventResultVO.setPage(page);
        eventResultVO.setEvent(event);
        eventResultVO.setTotalCount(totalCount);
        eventResultVO.setCurrentDayCount(currentDayCount);
        eventResultVO.setTotalUserIdIsNullCount(totalUserIdIsNullCount);
        eventResultVO.setCurrentUserIdIsNullCount(currentUserIdIsNullCount);
        return eventResultVO;
    }

    protected abstract void printSelfCustom();

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public AbstractEventChainBase getNextNode() {
        return nextNode;
    }

    public void setNextNode(AbstractEventChainBase nextNode) {
        this.nextNode = nextNode;
    }
}
