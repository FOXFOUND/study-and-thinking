package date.test;

public class HitchCommonConst {
    /**
     * 分表的最低月份
     */
    public static final String TABLE_MIN_DATE = "202002";
    
    public static class TableNameModule {
        /***
         * 用户行程表
         */
        public static final String HITCH_RENTER_JOURNEY = "hitch_renter_journey_";
        /***
         * 司机行程表
         */
        public static final String HITCH_DRIVER_JOURNEY = "hitch_driver_journey_";
        /***
         * 顺风车订单表
         */
        public static final String HITCH_ORDER_INFO = "hitch_order_info_";
        /**
         * 顺风车费用明细
         */
        public static final String HITCH_CHARGE_DETAIL = "hitch_charge_detail_";
    }
    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : CancelRedisPrefix
     * @Description : 取消计数Redis前缀
     * @author : maxinmin
     * @CreateDate : 2020-02-17 17:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static class CancelRedisPrefix{
        // 取消计数-乘客
        public static final String HITCH_RENTER_JOURNEY_PREFIX = "HITCH_RENTER_";
        // 取消计数-车主
        public static final String HITCH_DRIVER_JOURNEY_PREFIX = "HITCH_DRIVER_";
    }

    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : JourneyBusinessType
     * @Description : 行程归属常量类
     * @author : maxinmin
     * @CreateDate : 2020-02-17 17:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static class JourneyBusinessType{
        // 乘客
        public static final Integer RENTER_JOURNEY = 0;
        // 车主
        public static final Integer DRIVER_JOURNEY = 1;
    }


    /***
     *
     * @Project : DHCServ
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : HitchCommonConst
     * @Description : 用户行程单类型
     * @author : LinBoWen
     * @CreateDate : 2020-02-17 19:02:19
     * @version : V1.0.0
     * @Copyright : 2019 DFCX Inc. All rights reserved.
     * @Reviewed : 
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    **** 
     * 
     */
    
    public static class RenterJourneyType{
        // 市内
        public static final int IN_CITY = 1;
        // 城际
        public static final int OUT_CITY = 2;
    }



    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : DriverJourneyState
     * @Description : 车主行程状态常量类
     * @author : maxinmin
     * @CreateDate : 2020-02-13 17:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static final class DriverJourneyState {
        /***
         * 已发布
         */
        public static final Integer STATE_PUBLISHED = 1;
        /***
         * 行程中
         */
        public static final Integer STATE_GOING = 2;
        /***
         * 已结束
         */
        public static final Integer STATE_FINISHED = 3;
        /***
         * 已取消
         */
        public static final Integer STATE_CANCELED = 4;

    }

    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : RenterJourneyState
     * @Description : 乘客行程状态常量类
     * @author : maxinmin
     * @CreateDate : 2020-02-15 15:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static final class RenterJourneyState {
        /***
         * 已发布
         */
        public static final Integer STATE_PUBLISHED = 1;
        /***
         * 行程中
         */
        public static final Integer STATE_GOING = 2;
        /***
         * 已结束
         */
        public static final Integer STATE_FINISHED = 3;
        /***
         * 已取消
         */
        public static final Integer STATE_CANCELED = 4;

    }

    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : DriverJourneyCancelType
     * @Description : 车主行程取消类型
     * @author : maxinmin
     * @CreateDate : 2020-02-13 17:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static final class DriverJourneyCancelType {
        /***
         * 车主取消
         */
        public static final Integer DRIVER_CANCEL = 1;
        /***
         * 系统自动取消
         */
        public static final Integer SYSTEM_CANCEL = 2;
        /***
         * 其他
         */
        public static final Integer OTHER_CANCEL = 3;

    }

    /**
     *
     * @Project : hitch
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : ourneySource
     * @Description : 行程发布来源
     * @author : maxinmin
     * @CreateDate : 2020-02-14 15:45
     * @version : V 2.0.1
     * @Copyright : 2020 dfcx.com Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */
    public static final class PublishSource {
        /***
         * 东风出行APP
         */
        public static final Integer DFCX_APP = 1;

    }

    /***
     *
     * @Project : DHCServ
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : HitchCommonConst
     * @Description : HitchCommonConst 订单流转状态
     * @author : LinBoWen
     * @CreateDate : 2020-02-14 14:44:42
     * @version : V1.0.0
     * @Copyright : 2019 DFCX Inc. All rights reserved.
     * @Reviewed : 
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    **** 
     * 
     */
    
    public static final class OrderState {
        //订单流转状态：1-待乘客支付确认，车主已接单、2-待出发接乘客，乘客已支付、3-车主待到达约定地点，乘客待上车、
        // 4-车主待乘客上车，乘客待确认上车、5-行程中、6-车主到达目的地，乘客待确认到达、7-乘客确认到达，订单结束
        public static final int TO_BE_CONFIRMED = 1;

        public static final int TO_BE_START_OFF = 2;

        public static final int HAS_SET_OFF = 3;

        public static final int TO_BE_GET_ON = 4;

        public static final int DURING_TRIP = 5;

        public static final int DRIVER_ARRIVE = 6;

        public static final int TO_BE_RENTER_CONFIRMED = 7;

        public static final int CANCEL = 8;

    }

    public static final class OrderCancelState {

        public static final int NO_CANCEL = 0;

        public static final int RENTER_CANCEL = 1;

        public static final int DRIVER_CANCEL = 2;

        public static final int OTHER_CANCEL = 3;
    }

    public static final class OrderShareResult {
        // 订单拼座结果 0-未拼成，1-已拼成
        public static final int SHARE_FAIL = 0;

        public static final int SHARE_SUCCESS = 1;
    }

    public static final class RenterJourneyCancelType {
        // 订单取消 1.用户取消 2.车主取消 3.系统取消
        /***
         * 用户取消
         */
        public static final Integer RENTER_CANCEL = 1;
        /***
         * 车主取消
         */
        public static final Integer DRIVER_CANCEL = 2;
        /***
         * 系统取消
         */
        public static final Integer SYSTEM_CANCEL = 3;
        /**
         * 其他取消
         */
        public static final Integer OTHER_CANCEL = 4;

    }

    public static final class JourneyType {

        //1.市内  2城际
        public static final Integer IN_CITY = 1;

        public static final Integer INTER_CITY = 2;
    }

    /***
     *
     * @Project : DHCServ
     * @Package : cn.dfcx.hitchcommon.constants
     * @Class : HitchCommonConst
     * @Description : HitchCommonConst 个人中心类型
     * @author : LinBoWen
     * @CreateDate : 2020-02-16 14:42:55
     * @version : V1.0.0
     * @Copyright : 2019 DFCX Inc. All rights reserved.
     * @Reviewed :
     * @UpateLog :    Name    Date    Reason/Contents
     *             ---------------------------------------
     *                ****    ****    ****
     *
     */

    public static final class PersonType{
        //1.市内  2城际
        public static final int RENTER = 1;

        public static final int DRIVER = 2;
    }

    /**
     * 订单是否是退款订单
     */
    public static class OrderRefundState{
        /**
         * 未退款
         */
        public static final int NOT_REFUND = 0;
        /**
         * 已退款
         */
        public static final int REFUND = 1;
    }
}
