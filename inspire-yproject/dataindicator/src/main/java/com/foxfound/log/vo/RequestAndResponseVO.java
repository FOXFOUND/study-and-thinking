package com.foxfound.log.vo;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class RequestAndResponseVO {
    private UserVO userVO;
    private SecHandInfoDetailVO secHandInfoDetailVO;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public SecHandInfoDetailVO getSecHandInfoDetailVO() {
        return secHandInfoDetailVO;
    }

    public void setSecHandInfoDetailVO(SecHandInfoDetailVO secHandInfoDetailVO) {
        this.secHandInfoDetailVO = secHandInfoDetailVO;
    }
}
