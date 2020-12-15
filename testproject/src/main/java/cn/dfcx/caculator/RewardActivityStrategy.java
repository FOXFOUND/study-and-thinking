//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.dfcx.caculator;

import java.io.Serializable;

public class RewardActivityStrategy implements Serializable {
    private Integer id;
    private Integer activityId;
    private Integer weeklyDate;
    private Integer strategyType;
    private Integer strategyGroupNumber;
    private Integer maxRewardMoney;
    private Float minDriverScore;
    private String peakHoursStrategyJson;
    private String rewardStrategyJson;
    private Integer delState;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public RewardActivityStrategy() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getWeeklyDate() {
        return this.weeklyDate;
    }

    public void setWeeklyDate(Integer weeklyDate) {
        this.weeklyDate = weeklyDate;
    }

    public Integer getStrategyType() {
        return this.strategyType;
    }

    public void setStrategyType(Integer strategyType) {
        this.strategyType = strategyType;
    }

    public Integer getStrategyGroupNumber() {
        return this.strategyGroupNumber;
    }

    public void setStrategyGroupNumber(Integer strategyGroupNumber) {
        this.strategyGroupNumber = strategyGroupNumber;
    }

    public Integer getMaxRewardMoney() {
        return this.maxRewardMoney;
    }

    public void setMaxRewardMoney(Integer maxRewardMoney) {
        this.maxRewardMoney = maxRewardMoney;
    }

    public Float getMinDriverScore() {
        return this.minDriverScore;
    }

    public void setMinDriverScore(Float minDriverScore) {
        this.minDriverScore = minDriverScore;
    }

    public Integer getDelState() {
        return this.delState;
    }

    public void setDelState(Integer delState) {
        this.delState = delState;
    }

    public String getField1() {
        return this.field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return this.field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getField3() {
        return this.field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

    public String getField4() {
        return this.field4;
    }

    public void setField4(String field4) {
        this.field4 = field4 == null ? null : field4.trim();
    }

    public String getField5() {
        return this.field5;
    }

    public void setField5(String field5) {
        this.field5 = field5 == null ? null : field5.trim();
    }

    public String getPeakHoursStrategyJson() {
        return this.peakHoursStrategyJson;
    }

    public void setPeakHoursStrategyJson(String peakHoursStrategyJson) {
        this.peakHoursStrategyJson = peakHoursStrategyJson;
    }

    public String getRewardStrategyJson() {
        return this.rewardStrategyJson;
    }

    public void setRewardStrategyJson(String rewardStrategyJson) {
        this.rewardStrategyJson = rewardStrategyJson;
    }
}
