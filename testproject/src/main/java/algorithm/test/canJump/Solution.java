package algorithm.test.canJump;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean canJump(int[] nums) {
        Set set = new HashSet<Integer>();
        set.add(0);
        boolean res = canJumpSub(nums, 0, set);
        return res;
    }

    private boolean canJumpSub(int[] nums, int index, Set set) {
        if (index < 0 || index >= nums.length) {
            return false;
        }

        if (index == nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        int step = nums[index];
        boolean res = false;
        for (int i = -step; i <= step; i++) {
            int nextStep = index + i;
            if (i == 0) {
                continue;
            }
            if (nextStep <= 0 || nextStep >= nums.length) {
                continue;
            }
            if (set.contains(nextStep)) {
                continue;
            }
            if (nums[nextStep] == 0) {
                continue;
            }
            Set newSet = new HashSet();
            newSet.addAll(set);
            newSet.add(nextStep);
            res = res || canJumpSub(nums, nextStep, newSet);
            if (res) {
                break;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
//        for (int i = 30; i < 40; i++) {
//            System.out.println(i + "-->" + nums[i]);
//        }
//        System.out.println(nums.length);
        boolean res = solution.canJump(nums);
        System.out.println(res);
    }
}
