package algorithm.test.longestConsecutive;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 *  
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        Arrays.sort(nums);
        int leftPoint = 0;
        int count = 1;
        while (leftPoint < nums.length) {

            if (leftPoint + 1 < nums.length
                    && (nums[leftPoint + 1] - nums[leftPoint] == 1
            )) {
                count++;
                res = Math.max(res, count);
            } else if (leftPoint + 1 < nums.length && nums[leftPoint + 1] != nums[leftPoint]) {
                count = 1;
            }
            leftPoint++;
        }
        return res;
    }

    public static void main(String[] args) {

        //int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};   // 9
        // int[] nums = new int[]{100, 4, 200, 1, 3, 2};  //4
        int[] nums = new int[]{1, 2, 0, 1};  //3
        Solution solution = new Solution();
        int res = solution.longestConsecutive(nums);
        System.out.println(res);
    }
}
