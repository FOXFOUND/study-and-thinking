package com.foxfound.log.vo;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class UserVO {
    private String nickName;
    private String wxOpenId;
    private Long userId;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
