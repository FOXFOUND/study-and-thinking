package com.foxfound.log.vo;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class DetailUserActionVO {
    private String date;
    private Long currentNewUserCount;
    private Long currentUserUnAuthCount;
    private Long currentFinishedFirstUserCount;
    private Long currentFinishedAuthCount;
    private Long currentUserFinishedFirstNotSecondCount;
    private Long lastOutSideSecHandInfoCount;
    private Long totalBuyCount;
    private Long totalSellCount;
    private Long notWantBuy;
    private Long alreadyOffShelf;

    public Long getCurrentNewUserCount() {
        return currentNewUserCount;
    }

    public void setCurrentNewUserCount(Long currentNewUserCount) {
        this.currentNewUserCount = currentNewUserCount;
    }

    public Long getCurrentUserUnAuthCount() {
        return currentUserUnAuthCount;
    }

    public void setCurrentUserUnAuthCount(Long currentUserUnAuthCount) {
        this.currentUserUnAuthCount = currentUserUnAuthCount;
    }

    public Long getCurrentFinishedFirstUserCount() {
        return currentFinishedFirstUserCount;
    }

    public void setCurrentFinishedFirstUserCount(Long currentFinishedFirstUserCount) {
        this.currentFinishedFirstUserCount = currentFinishedFirstUserCount;
    }

    public Long getCurrentFinishedAuthCount() {
        return currentFinishedAuthCount;
    }

    public void setCurrentFinishedAuthCount(Long currentFinishedAuthCount) {
        this.currentFinishedAuthCount = currentFinishedAuthCount;
    }

    public Long getCurrentUserFinishedFirstNotSecondCount() {
        return currentUserFinishedFirstNotSecondCount;
    }

    public void setCurrentUserFinishedFirstNotSecondCount(Long currentUserFinishedFirstNotSecondCount) {
        this.currentUserFinishedFirstNotSecondCount = currentUserFinishedFirstNotSecondCount;
    }

    public Long getLastOutSideSecHandInfoCount() {
        return lastOutSideSecHandInfoCount;
    }

    public void setLastOutSideSecHandInfoCount(Long lastOutSideSecHandInfoCount) {
        this.lastOutSideSecHandInfoCount = lastOutSideSecHandInfoCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotalBuyCount() {
        return totalBuyCount;
    }

    public void setTotalBuyCount(Long totalBuyCount) {
        this.totalBuyCount = totalBuyCount;
    }

    public Long getTotalSellCount() {
        return totalSellCount;
    }

    public void setTotalSellCount(Long totalSellCount) {
        this.totalSellCount = totalSellCount;
    }

    public Long getNotWantBuy() {
        return notWantBuy;
    }

    public void setNotWantBuy(Long notWantBuy) {
        this.notWantBuy = notWantBuy;
    }

    public Long getAlreadyOffShelf() {
        return alreadyOffShelf;
    }

    public void setAlreadyOffShelf(Long alreadyOffShelf) {
        this.alreadyOffShelf = alreadyOffShelf;
    }
}
