package com.foxfound.log.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class SqlConstant {
    public static final String selectLastDayOutSideSecHandInfoCount;
    public static final String selectTotalBuyCount;
    public static final String selectTotalSellCount;
    public static final String selectNotWantBuy;
    public static final String selectAlreadyOffShelf;
    public static final String selectSecHandInfoDetailAndCommentCount;

    static {
        String userIdSetStr = StringUtils.join(CompanyUserId.userIdSet, ",");
        selectLastDayOutSideSecHandInfoCount = "sql" + userIdSetStr + ");";
        selectTotalBuyCount = "sql" + userIdSetStr + ");";
        selectTotalSellCount = "sql" + userIdSetStr + ");";
        selectNotWantBuy = "sql" + userIdSetStr + ");";
        selectAlreadyOffShelf = "sql" + userIdSetStr + " );";
        selectSecHandInfoDetailAndCommentCount = "sql" + userIdSetStr + ") group by s.id";
    }
}
