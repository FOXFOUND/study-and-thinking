package com.foxfound.log.constant;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public enum EventCLassNameEnum {
    AgreeAuthEvent("AgreeAuthEvent"),
    ClickAuthBtnEvent("ClickAuthBtnEvent"),
    EnterFriendSayEvent("EnterFriendSayEvent"),
    ExitFriendSayEvent("ExitFriendSayEvent");
    private String className;

    EventCLassNameEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
