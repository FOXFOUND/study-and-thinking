package com.foxfound.log.util;

import com.foxfound.log.event.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class BuildEventUtil {
    public static AbstractEventChainBase buildProcessChain() {
        List<AbstractEventChainBase> abstractEventChainBaseList = new ArrayList<>();
        addEnterFriendSayEvent(abstractEventChainBaseList);
        addClickAuthBtnEvent(abstractEventChainBaseList);
        addAgreeAuthEvent(abstractEventChainBaseList);
        addExitFriendSayEvent(abstractEventChainBaseList);
        EventList eventList = EventChainBuilder.custom();
        abstractEventChainBaseList.forEach(abstractEventChainBase -> {
            eventList.append(abstractEventChainBase);
        });
        return eventList.build();
    }

    private static void addExitFriendSayEvent(List<AbstractEventChainBase> abstractEventChainBaseList) {
        ExitFriendSayEvent exitFriendSayEvent = new ExitFriendSayEvent();
        exitFriendSayEvent.setPage("pages/detail/detail");
        exitFriendSayEvent.setEvent("exitFriendSay");
        abstractEventChainBaseList.add(exitFriendSayEvent);
    }

    private static void addAgreeAuthEvent(List<AbstractEventChainBase> abstractEventChainBaseList) {
        AgreeAuthEvent agreeAuthEvent = new AgreeAuthEvent();
        agreeAuthEvent.setPage("pages/detail/detail");
        agreeAuthEvent.setEvent("agreeAuth");
        abstractEventChainBaseList.add(agreeAuthEvent);
    }

    private static void addClickAuthBtnEvent(List<AbstractEventChainBase> abstractEventChainBaseList) {
        ClickAuthBtnEvent clickAuthBtnEvent = new ClickAuthBtnEvent();
        clickAuthBtnEvent.setPage("pages/detail/detail");
        clickAuthBtnEvent.setEvent("clickAuthBtn");
        abstractEventChainBaseList.add(clickAuthBtnEvent);
    }

    private static void addEnterFriendSayEvent(List<AbstractEventChainBase> abstractEventChainBaseList) {
        EnterFriendSayEvent enterFriendSayEvent = new EnterFriendSayEvent();
        enterFriendSayEvent.setPage("pages/detail/detail");
        enterFriendSayEvent.setEvent("enterFriendSay");
        abstractEventChainBaseList.add(enterFriendSayEvent);
    }
}
