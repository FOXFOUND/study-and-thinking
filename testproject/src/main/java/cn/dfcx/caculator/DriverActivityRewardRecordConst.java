package cn.dfcx.caculator;

/***
 *
 * @Project : DHCServ
 * @Package : cn.dfcx.ochserv.driver.mgr.constants
 * @Class : DriverActivityRewardRecordConst
 * @Description : DriverActivityRewardRecordConst 司机奖惩记录常量
 * @author : LinBoWen
 * @CreateDate : 2019-11-06 11:09:49
 * @version : V1.0.0
 * @Copyright : 2019 DFCX Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 *             ---------------------------------------
 *                ****    ****    ****
 *
 */

public class DriverActivityRewardRecordConst {

    public static class OrderState {
        /**
         * 取消
         */
        public static int CANCEL = 2;
        /**
         * 成单
         */
        public static int FINISH = 1;
    }

    public static class StrategyType {
        /**
         * 策略类型（1-固定金额奖励,2-每单奖励）
         */
        public static int FIXED_REWARD_TYPE = 1;
        public static int EACH_REWARD = 2;

        public static String getDriverStrategyTypeDesc(int strategyType) {
            String resMsg = "";
            switch (strategyType) {
                case 1:
                    resMsg = "冲单奖";
                    break;
                case 2:
                    resMsg = "每单奖";
                    break;

                default:

            }
            return resMsg;
        }
    }

    public static class SendState {
        /**
         * 发放状态[1.未发放；2.已发放；3.无需发放]
         */
        public static int NOT_SEND = 1;
        public static int HAS_SEND = 2;
        public static int NOT_NEED_SEND = 3;
    }

    public static class StandInActivityState {
        /**
         * 不参加
         */
        public static int NOT_STAND_IN = 0;
        /**
         * 参加
         */
        public static int STAND_INT = 1;
    }

    public static class StandInActivityConditions{
        /**
         * 不符合
         */
        public static int NOT_STAND_IN = 0;
        /**
         * 符合
         */
        public static int STAND_INT = 1;
    }

    public static class DriverActivityType {
        /**
         * 高峰时段类型（1-全天，2-早高峰，3-午高峰,4-晚高峰）
         */

        public static int HOLE_DAY = 1;
        public static int MORNING_HIGH = 2;
        public static int LUNCH_HIGH = 3;
        public static int NIGHT_HIGH = 4;

        public static String getDriverActivityTypeDesc(int driverActivityType) {
            String resMsg = "";
            switch (driverActivityType) {
                case 1:
                    resMsg = "全天";
                    break;
                case 2:
                    resMsg = "早高峰";
                    break;
                case 3:
                    resMsg = "午高峰";
                    break;
                case 4:
                    resMsg = "晚高峰";
                    break;
                default:

            }
            return resMsg;
        }

    }


    public static class ModifyDriverAccBalance {
        public static int FAIL = 0;
        public static int SUCCESS = 1;
    }

    public static class DeleteState {
        public static int NOT_DELETED = 0;
        public static int HAS_DELETED = 1;
    }


    public static class ActivityStatus {
        /**
         * 待上线
         */
        public static int STATUS_TO_BE_ONLINE = 1;

        /**
         * 已上线
         */
        public  static int STATUS_ONLINE = 2;

        /**
         * 已下线
         */
        public  static int STATUS_OFFLINE = 3;
    }


    public  static  class ActivityListType{
        public  static  int YESTERDAY = 1;
        public  static  int TODAY = 2;
        public  static  int TOMORROW =3;
    }

    public  static  class CalculatorType{
        public  static  int ADD_ORDER =1;
        public static  int SEND_REWARD =2 ;
    }
}
