package algorithm.test.threeSum;

import com.alibaba.fastjson.JSON;

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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inputList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            inputList.add(nums[i]);
        }
        Collections.sort(inputList);
        Map<Integer, List<Integer>> inputMap = new HashMap<>();
        for (int i = 0; i < inputList.size(); i++) {
            List<Integer> integerList = inputMap.getOrDefault(inputList.get(i), new ArrayList<>());
            integerList.add(i);
            inputMap.put(inputList.get(i), integerList);
        }
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i; j < inputList.size(); j++) {
                int leftValueA = inputList.get(i).intValue();
                int rightValueB = inputList.get(j).intValue();
                int valueC = 0 - leftValueA - rightValueB;
                List currentList = inputMap.get(valueC);

                if(valueC == leftValueA && currentList != null ){
                    currentList.remove(new Integer(i));
                }
                if(valueC == rightValueB && currentList != null ){
                    currentList .remove(new Integer(j));
                }
                if (currentList != null ) {
                    for (int k = 0; k < currentList.size(); k++) {
                        List<Integer> resReturnSub = new ArrayList<>();
                        resReturnSub.add(leftValueA);
                        resReturnSub.add(rightValueB);
                        resReturnSub.add(valueC);
                        res.add(resReturnSub);
                    }
                }
                if(valueC == leftValueA && currentList != null ){
                    currentList .add(i);
                }
                if(valueC == rightValueB && currentList != null ){
                    currentList .add(j);
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        NumSum numSum = new NumSum();
        List<List<Integer>> lists = numSum.threeSum(nums);
        System.out.println(JSON.toJSONString(lists));
        System.out.println(lists.size());  // 2
    }

}
