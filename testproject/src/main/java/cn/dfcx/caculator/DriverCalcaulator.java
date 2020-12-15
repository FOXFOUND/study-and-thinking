package cn.dfcx.caculator;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DriverCalcaulator {
    public static Integer  calculatorRewardAmount(DriverActivityRewardRecordParam driverActivityRewardRecordParam  ) {

        Integer rewardAmounts = 0;
        //防止数据不符合规范报错
        RewardActivityStrategy rewardActivityStrategy = driverActivityRewardRecordParam.getRewardActivityStrategyList().get(0);
        //解析高峰时段 和 奖励节点
        List<RewardStrategyJsonDTO> rewardStrategyJsonDTOList = JSON.parseArray(rewardActivityStrategy.getRewardStrategyJson(), RewardStrategyJsonDTO.class);
        //固定金额奖励
        if (rewardActivityStrategy.getStrategyType().equals(DriverActivityRewardRecordConst.StrategyType.FIXED_REWARD_TYPE)) {
            //多个目标节点
            for (RewardStrategyJsonDTO rewardStrategyJsonDTO : rewardStrategyJsonDTOList) {
                //等号在左边
                if (driverActivityRewardRecordParam.getOrderNums().intValue() >= rewardStrategyJsonDTO.getNodeOrderCount().intValue()) {
                    rewardAmounts += rewardStrategyJsonDTO.getNodeRewardMoney();
                    if (rewardAmounts.intValue() >= rewardActivityStrategy.getMaxRewardMoney().intValue()) {
                        rewardAmounts = rewardActivityStrategy.getMaxRewardMoney();
                        break;
                    }
                } else {
                    break;
                }
            }
            driverActivityRewardRecordParam.setRewardAmounts(rewardAmounts);
        }
        //每单奖励
        if (rewardActivityStrategy.getStrategyType().equals(DriverActivityRewardRecordConst.StrategyType.EACH_REWARD)) {
            //倒排确定奖励金额
            int driverOrderNums = driverActivityRewardRecordParam.getOrderNums().intValue();
            Collections.reverse(rewardStrategyJsonDTOList);
            for (RewardStrategyJsonDTO rewardStrategyJsonDTO : rewardStrategyJsonDTOList) {
                // 等号在右边
                if (driverOrderNums >= rewardStrategyJsonDTO.getNodeOrderCount().intValue() + 1) {
                    rewardAmounts += (driverOrderNums - rewardStrategyJsonDTO.getNodeOrderCount().intValue()) * rewardStrategyJsonDTO.getNodeRewardMoney();
                    driverOrderNums = rewardStrategyJsonDTO.getNodeOrderCount().intValue();
                    if (rewardAmounts.intValue() >= rewardActivityStrategy.getMaxRewardMoney().intValue()) {
                        rewardAmounts = rewardActivityStrategy.getMaxRewardMoney();
                        break;
                    }
                } else {
                    continue;
                }
            }
            driverActivityRewardRecordParam.setRewardAmounts(rewardAmounts);
        }
        return rewardAmounts;

    }

}
