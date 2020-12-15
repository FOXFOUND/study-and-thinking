package cn.dfcx.dealall;

import cn.dfcx.caculator.ConstPath;
import cn.dfcx.caculator.DriverActivityRewardRecordParam;
import cn.dfcx.caculator.DriverCalcaulator;
import cn.dfcx.caculator.RewardActivityStrategy;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.ArrayList;
import java.util.List;

public class AllDayDeal {


    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(ConstPath.path+"\\all_day_sti.xlsx");
        List<List<Object>> readAll = reader.read();
        System.out.println(readAll.size());
        System.out.println(readAll.get(1));
        for (int i = 0; i <readAll.get(0).size() ; i++) {
            System.out.println(i+ "-------" + readAll.get(0).get(i));
        }

        for (int i = 1; i <readAll.size() ; i++) {
            DriverActivityRewardRecordParam driverActivityRewardRecordParam  = new DriverActivityRewardRecordParam();
            driverActivityRewardRecordParam.setOrderNums(Integer.valueOf(String.valueOf(readAll.get(i).get(2))));
            List<RewardActivityStrategy> rewardActivityStrategyList = new ArrayList<>();
            RewardActivityStrategy rewardActivityStrategy = new RewardActivityStrategy();
            rewardActivityStrategy.setStrategyType(Integer.valueOf(String.valueOf(readAll.get(i).get(11))));
            rewardActivityStrategy.setMaxRewardMoney(Integer.valueOf(String.valueOf(readAll.get(i).get(13))));
            rewardActivityStrategy.setRewardStrategyJson(String.valueOf(readAll.get(i).get(16)));
            rewardActivityStrategyList.add(rewardActivityStrategy);
            driverActivityRewardRecordParam.setRewardActivityStrategyList(rewardActivityStrategyList);
            DriverCalcaulator.calculatorRewardAmount(driverActivityRewardRecordParam);
            readAll.get(i).add(driverActivityRewardRecordParam.getRewardAmounts());
        }

        ExcelWriter writer = ExcelUtil.getWriter(ConstPath.path+"/all_day_sti_cal.xlsx");

        //一次性写出内容，强制输出标题
        writer.write(readAll, true);
        //关闭writer，释放内存
        writer.close();


        System.out.println("ok");
    }

}
