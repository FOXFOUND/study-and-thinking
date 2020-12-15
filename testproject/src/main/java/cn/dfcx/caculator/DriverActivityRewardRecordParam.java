package cn.dfcx.caculator;

import java.io.Serializable;
import java.util.List;

/***
 *
 * @Project : DHCServ
 * @Package : cn.dfcx.ochserv.driver.mgr.entity
 * @Class : DriverActivityRewardRecordParam
 * @Description : DriverActivityRewardRecordParam 司机奖惩记录参数
 * @author : LinBoWen
 * @CreateDate : 2019-11-06 10:12:32
 * @version : V1.0.0
 * @Copyright : 2019 DFCX Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 *             ---------------------------------------
 *                ****    ****    ****
 *
 */

public class DriverActivityRewardRecordParam implements Serializable {

    private Integer driverId;
    private String orderId;
    private Integer orderNums;
    private Integer rewardAmounts;
    private Integer activityId;
    private List<RewardActivityStrategy> rewardActivityStrategyList;
    private Integer calculatorType ;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(Integer orderNums) {
        this.orderNums = orderNums;
    }

    public List<RewardActivityStrategy> getRewardActivityStrategyList() {
        return rewardActivityStrategyList;
    }

    public void setRewardActivityStrategyList(List<RewardActivityStrategy> rewardActivityStrategyList) {
        this.rewardActivityStrategyList = rewardActivityStrategyList;
    }

    public Integer getRewardAmounts() {
        return rewardAmounts;
    }

    public void setRewardAmounts(Integer rewardAmounts) {
        this.rewardAmounts = rewardAmounts;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }


    public Integer getCalculatorType() {
        return calculatorType;
    }

    public void setCalculatorType(Integer calculatorType) {
        this.calculatorType = calculatorType;
    }

    @Override
    public String toString() {
        return "DriverActivityRewardRecordParam{" +
                "driverId=" + driverId +
                ", orderId='" + orderId + '\'' +
                ", orderNums=" + orderNums +
                ", rewardAmounts=" + rewardAmounts +
                ", activityId=" + activityId +
                ", rewardActivityStrategyList=" + rewardActivityStrategyList +
                ", calculatorType=" + calculatorType +
                '}';
    }
}
