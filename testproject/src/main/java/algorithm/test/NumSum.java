package algorithm.test;

import com.alibaba.fastjson.JSON;

import java.sql.SQLOutput;
import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 *a，b，c ，*使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * **注意：**答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class NumSum {

    public  List<List<Integer>>  getNumSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inputList = new ArrayList() ;
        for (int i = 0; i < arr.length; i++) {
            inputList.add(arr[i]);
        }
        Collections.sort(inputList);
        Map<Integer, Integer> inputMap = new HashMap<>();
        for (int i = 0; i < inputList.size(); i++) {
                inputMap.put(inputList.get(i), 1);
        }

        int leftPoint = 0;
        int rightPoint = 0;
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i; j < inputList.size(); j++) {
                int leftValueA = inputList.get(i).intValue();
                int rightValueB = inputList.get(j).intValue();
                int valueC = 0 - leftValueA - rightValueB;
                if (inputMap.get(valueC) != null) {
                    for (int k = 0; k < inputMap.get(valueC); k++) {
                        List<Integer> resReturnSub = new ArrayList<>();
                        resReturnSub.add(leftValueA);
                        resReturnSub.add(rightValueB);
                        resReturnSub.add(valueC);
                        res.add(resReturnSub);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int []  nums =new int[] {-1, 0, 1, 2, -1, -4};
        NumSum numSum = new NumSum();
        List<List<Integer>> lists= numSum.getNumSum(nums);
        System.out.println(JSON.toJSONString(lists));
        System.out.println(lists.size());
    }

}
