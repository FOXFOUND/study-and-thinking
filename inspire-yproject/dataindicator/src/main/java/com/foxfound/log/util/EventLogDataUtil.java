package com.foxfound.log.util;

import com.alibaba.fastjson.JSON;
import com.foxfound.log.constant.EventCLassNameEnum;
import com.foxfound.log.constant.SqlConstant;
import com.foxfound.log.event.AbstractEventChainBase;
import com.foxfound.log.vo.DetailUserActionVO;
import com.foxfound.log.vo.EventResultVO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-14
 */
public class EventLogDataUtil {
    private static DetailUserActionVO detailUserActionVO;

    public static DetailUserActionVO getDetailUserActionVO() {
        return detailUserActionVO;
    }

    public static void setDetailUserActionVO(DetailUserActionVO detailUserActionVO) {
        EventLogDataUtil.detailUserActionVO = detailUserActionVO;
    }

    public static void recordDetailUserActionData(String saveFilePath) {
        DetailUserActionVO detailUserActionVO = EventLogDataUtil.getDetailUserActionData();
        String fileName = saveFilePath + "/" + "detailUserAction-" + detailUserActionVO.getDate() + ".txt";
        List<String> linesList = new ArrayList<>();
        linesList.add(JSON.toJSONString(detailUserActionVO));
        try {
            FileUtils.writeLines(new File(fileName), linesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DetailUserActionVO getDetailUserActionData() {
        detailUserActionVO = new DetailUserActionVO();
        detailUserActionVO.setDate(AbstractEventChainBase.LastDay);
        List<EventResultVO> eventResultVOList = AbstractEventChainBase.eventResultVOList;
        EventResultVO eventResultVOAgreeAuthEvent = EventResultVOUtil.getEventResultVOByName(eventResultVOList, EventCLassNameEnum.AgreeAuthEvent.getClassName());
        EventResultVO eventResultVOClickAuthBtnEvent = EventResultVOUtil.getEventResultVOByName(eventResultVOList, EventCLassNameEnum.ClickAuthBtnEvent.getClassName());
        EventResultVO eventResultVOEnterFriendSayEvent = EventResultVOUtil.getEventResultVOByName(eventResultVOList, EventCLassNameEnum.EnterFriendSayEvent.getClassName());
        EventResultVO eventResultVOExitFriendSayEvent = EventResultVOUtil.getEventResultVOByName(eventResultVOList, EventCLassNameEnum.ExitFriendSayEvent.getClassName());
        EventLogDataUtil.getDetailNewUser(eventResultVOEnterFriendSayEvent);
        EventLogDataUtil.getDetailUserUnAuth(eventResultVOEnterFriendSayEvent, eventResultVOClickAuthBtnEvent);
        EventLogDataUtil.getDetailUserFinishedFirstAuth(eventResultVOClickAuthBtnEvent);
        EventLogDataUtil.getDetailUserFinishedAuth(eventResultVOAgreeAuthEvent);
        EventLogDataUtil.getDetailUserFinishedFirstNotSecond(eventResultVOClickAuthBtnEvent, eventResultVOAgreeAuthEvent);
        detailUserActionVO.setLastOutSideSecHandInfoCount(getCountBySql(SqlConstant.selectLastDayOutSideSecHandInfoCount));
        detailUserActionVO.setTotalBuyCount(getCountBySql(SqlConstant.selectTotalBuyCount));
        detailUserActionVO.setTotalSellCount(getCountBySql(SqlConstant.selectTotalSellCount));
        detailUserActionVO.setNotWantBuy(getCountBySql(SqlConstant.selectNotWantBuy));
        detailUserActionVO.setAlreadyOffShelf(getCountBySql(SqlConstant.selectAlreadyOffShelf));
        return detailUserActionVO;
    }

    private static Long getCountBySql(String sql) {
        ResultSet resultSet = DBUtil.executeQuery(sql);
        try {
            if (resultSet.next()) {
                Long lastOutSideSecHandInfoCount = resultSet.getLong(1);
                detailUserActionVO.setLastOutSideSecHandInfoCount(lastOutSideSecHandInfoCount);
                return lastOutSideSecHandInfoCount;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getDetailNewUser(EventResultVO eventResultVOEnterFriendSayEvent) {
        long currentNewUserCount = eventResultVOEnterFriendSayEvent.getCurrentUserIdIsNullCount().get();
        detailUserActionVO.setCurrentNewUserCount(currentNewUserCount);

    }

    private static void getDetailUserUnAuth(EventResultVO eventResultVOEnterFriendSayEvent, EventResultVO eventResultVOClickAuthBtnEvent) {
        long currentUserUnAuthCount = Math.abs(eventResultVOEnterFriendSayEvent.getCurrentUserIdIsNullCount().get() - eventResultVOClickAuthBtnEvent.getCurrentUserIdIsNullCount().get());
        detailUserActionVO.setCurrentUserUnAuthCount(currentUserUnAuthCount);

    }

    private static void getDetailUserFinishedFirstAuth(EventResultVO eventResultVOClickAuthBtnEvent) {
        long currentFinishedFirstUserCount = eventResultVOClickAuthBtnEvent.getCurrentUserIdIsNullCount().get();
        detailUserActionVO.setCurrentFinishedFirstUserCount(currentFinishedFirstUserCount);

    }

    private static void getDetailUserFinishedAuth(EventResultVO eventResultVOAgreeAuthEvent) {
        long currentFinishedAuthCount = eventResultVOAgreeAuthEvent.getCurrentUserIdIsNullCount().get();
        detailUserActionVO.setCurrentFinishedAuthCount(currentFinishedAuthCount);

    }

    private static void getDetailUserFinishedFirstNotSecond(EventResultVO eventResultVOClickAuthBtnEvent, EventResultVO eventResultVOAgreeAuthEvent) {
        long currentUserFinishedFirstNotSecondCount = (eventResultVOClickAuthBtnEvent.getCurrentUserIdIsNullCount().get() - eventResultVOAgreeAuthEvent.getCurrentUserIdIsNullCount().get());
        detailUserActionVO.setCurrentUserFinishedFirstNotSecondCount(currentUserFinishedFirstNotSecondCount);

    }

}
