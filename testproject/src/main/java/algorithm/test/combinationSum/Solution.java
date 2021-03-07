package algorithm.test.combinationSum;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumSub(candidates, target, new ArrayList<>());
        return res;

    }

    private void combinationSumSub(int[] candidates, int target, ArrayList<Integer> sub) {

        int nums = 0;
        for (int i = 0; i < sub.size(); i++) {
            nums += sub.get(i);
        }
        if (nums > target) {
            return;
        }
        if (nums == target) {
            Collections.sort(sub);
            if(res.contains(sub)){
                return;
            }else {
                res.add(sub);
                return;
            }

        }
        for (int i = 0; i < candidates.length; i++) {
            ArrayList<Integer> sub1 = new ArrayList<>(sub.size() +1);
            sub1.addAll(sub);
            sub1.add(candidates[i]);
            combinationSumSub(candidates, target, sub1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(nums, target);
        System.out.println(JSON.toJSONString(res));
        System.out.println(res.size());
    }
}
