package algorithm.test.lengthOfLIS;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
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
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    // 连续递增,中间存在间隔,数组是单调的
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int leftPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            leftPoint = i;
            int nextPoint = leftPoint;
            while (nextPoint < nums.length) {
                if (nums[nextPoint] > nums[leftPoint]) {
                    count++;
                    leftPoint = nextPoint;
                } else {
                    nextPoint++;
                }

            }
            res = Math.max(res, count);


        }
        return res;

    }

    public static void main(String[] args) {
        //int[] arr =new int[]{10,9,2,5,3,7,101,18};
        int[] arr = new int[]{0, 1, 0, 3, 2, 3};
        Solution2 solution2 = new Solution2();
        int res = solution2.lengthOfLIS(arr);
        System.out.println(res);
        System.out.println(res == 4);
    }
}
