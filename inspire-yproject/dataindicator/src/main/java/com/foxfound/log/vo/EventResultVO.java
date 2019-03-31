package com.foxfound.log.vo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class EventResultVO {
    private String className;
    private String page;
    private String event;
    private AtomicInteger totalCount;
    private AtomicInteger currentDayCount;
    private AtomicInteger totalUserIdIsNullCount;
    private AtomicInteger currentUserIdIsNullCount;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

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

    public AtomicInteger getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(AtomicInteger totalCount) {
        this.totalCount = totalCount;
    }

    public AtomicInteger getCurrentDayCount() {
        return currentDayCount;
    }

    public void setCurrentDayCount(AtomicInteger currentDayCount) {
        this.currentDayCount = currentDayCount;
    }

    public AtomicInteger getTotalUserIdIsNullCount() {
        return totalUserIdIsNullCount;
    }

    public void setTotalUserIdIsNullCount(AtomicInteger totalUserIdIsNullCount) {
        this.totalUserIdIsNullCount = totalUserIdIsNullCount;
    }

    public AtomicInteger getCurrentUserIdIsNullCount() {
        return currentUserIdIsNullCount;
    }

    public void setCurrentUserIdIsNullCount(AtomicInteger currentUserIdIsNullCount) {
        this.currentUserIdIsNullCount = currentUserIdIsNullCount;
    }
}
