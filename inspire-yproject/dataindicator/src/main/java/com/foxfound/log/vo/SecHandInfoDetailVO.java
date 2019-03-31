package com.foxfound.log.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SecHandInfoDetailVO {
    private long id;
    private String detail;
    private long creatorUserId;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private String publishPosition;
    private String publishLatitude;
    private String publishLongitude;
    private String imgUrls;
    private int type;
    private int status;
    private Date createTime;
    private String portraitUrl;
    private String nickname;
    private int commonFriendsCount;
    private List<CommonFriendVO> commonFriends;
    private List<CommonFriendVO> shareLine;
    private int ifPopup;
    private boolean isFriend;
    private long secHandInfoId;
    private Long chainId;
    private int sceneId;
    private EncryptDataVO encryptData;
    private int isFavorite;
    private long fromUserId;
    private List<VisitedUserVO> visitedUsers;

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public long getSecHandInfoId() {
        return secHandInfoId;
    }

    public void setSecHandInfoId(long secHandInfoId) {
        this.secHandInfoId = secHandInfoId;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public EncryptDataVO getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(EncryptDataVO encryptData) {
        this.encryptData = encryptData;
    }

    public int getIfPopup() {
        return ifPopup;
    }

    public void setIfPopup(int ifPopup) {
        this.ifPopup = ifPopup;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCommonFriendsCount() {
        return commonFriendsCount;
    }

    public void setCommonFriendsCount(int commonFriendsCount) {
        this.commonFriendsCount = commonFriendsCount;
    }

    public List<CommonFriendVO> getCommonFriends() {
        return commonFriends;
    }

    public void setCommonFriends(List<CommonFriendVO> commonFriends) {
        this.commonFriends = commonFriends;
    }

    public List<CommonFriendVO> getShareLine() {
        return shareLine;
    }

    public void setShareLine(List<CommonFriendVO> shareLine) {
        this.shareLine = shareLine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = BigDecimal.valueOf((double) price / 100);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = BigDecimal.valueOf((double) originalPrice / 100);
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPublishPosition() {
        return publishPosition;
    }

    public void setPublishPosition(String publishPosition) {
        this.publishPosition = publishPosition;
    }

    public String getPublishLatitude() {
        return publishLatitude;
    }

    public void setPublishLatitude(String publishLatitude) {
        this.publishLatitude = publishLatitude;
    }

    public String getPublishLongitude() {
        return publishLongitude;
    }

    public void setPublishLongitude(String publishLongitude) {
        this.publishLongitude = publishLongitude;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public List<VisitedUserVO> getVisitedUsers() {
        return visitedUsers;
    }

    public void setVisitedUsers(List<VisitedUserVO> visitedUsers) {
        this.visitedUsers = visitedUsers;
    }
}
