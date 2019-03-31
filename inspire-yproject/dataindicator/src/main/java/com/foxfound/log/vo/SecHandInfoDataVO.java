package com.foxfound.log.vo;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class SecHandInfoDataVO {
    private Long secHandInfoId;
    private long visitedCount;
    private String detail;
    private long commentCount;

    public Long getSecHandInfoId() {
        return secHandInfoId;
    }

    public void setSecHandInfoId(Long secHandInfoId) {
        this.secHandInfoId = secHandInfoId;
    }

    public long getVisitedCount() {
        return visitedCount;
    }

    public void setVisitedCount(long visitedCount) {
        this.visitedCount = visitedCount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
}
