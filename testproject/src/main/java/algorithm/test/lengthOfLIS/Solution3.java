package algorithm.test.lengthOfLIS;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    /**
     * 动态规划
     * 子序列的问题->动态规划。
     * <p>
     * 使用数组 cell 保存每步子问题的最优解。
     * cell[i] 代表含第 i 个元素的最长上升子序列的长度。
     * 求解 cell[i] 时，向前遍历找出比 i 元素小的元素 j，令 cell[i] 为 max（cell[i],cell[j]+1)
     * <p>
     * <p>
     * <p>
     * 从后向前推
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            //从后向前寻找小于j的值,看看到j的最大子序列的长度是多少
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = solution3.lengthOfLIS(arr);
        System.out.println(res);
    }
}
