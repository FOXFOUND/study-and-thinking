//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.dfcx.caculator;

import java.io.Serializable;

public class RewardStrategyJsonDTO implements Serializable {
    private Integer nodeOrderCount;
    private Integer nodeRewardMoney;

    public RewardStrategyJsonDTO() {
    }

    public Integer getNodeOrderCount() {
        return this.nodeOrderCount;
    }

    public Integer getNodeRewardMoney() {
        return this.nodeRewardMoney;
    }

    public void setNodeOrderCount(Integer nodeOrderCount) {
        this.nodeOrderCount = nodeOrderCount;
    }

    public void setNodeRewardMoney(Integer nodeRewardMoney) {
        this.nodeRewardMoney = nodeRewardMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RewardStrategyJsonDTO)) {
            return false;
        } else {
            RewardStrategyJsonDTO other = (RewardStrategyJsonDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$nodeOrderCount = this.getNodeOrderCount();
                Object other$nodeOrderCount = other.getNodeOrderCount();
                if (this$nodeOrderCount == null) {
                    if (other$nodeOrderCount != null) {
                        return false;
                    }
                } else if (!this$nodeOrderCount.equals(other$nodeOrderCount)) {
                    return false;
                }

                Object this$nodeRewardMoney = this.getNodeRewardMoney();
                Object other$nodeRewardMoney = other.getNodeRewardMoney();
                if (this$nodeRewardMoney == null) {
                    if (other$nodeRewardMoney != null) {
                        return false;
                    }
                } else if (!this$nodeRewardMoney.equals(other$nodeRewardMoney)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof RewardStrategyJsonDTO;
    }

    @Override
    public int hashCode() {
    return 0;
    }

    @Override
    public String toString() {
        return "RewardStrategyJsonDTO(nodeOrderCount=" + this.getNodeOrderCount() + ", nodeRewardMoney=" + this.getNodeRewardMoney() + ")";
    }
}
