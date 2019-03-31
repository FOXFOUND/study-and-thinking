package com.foxfound.log.event;

import com.foxfound.log.vo.EventVO;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-13
 */
public class EnterFriendSayEvent extends AbstractEventChainBase {
    @Override
    protected void processEventVONotCurrentDay(EventVO eventVO) {
    }

    @Override
    protected void processEventVOWhenCurrentDay(EventVO eventVO) {
    }

    @Override
    protected void printSelfCustom() {
    }
}
