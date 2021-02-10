package algorithm.test.maximum.average.subarray;

import java.math.BigDecimal;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
class Solution {

    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        double result = 0D;
        if (nums == null || nums.length < k) {
            return 0D;
        }
        int[] calculateArr = new int[k];
        for (int i = 0; i < k; i++) {
            calculateArr[i] = nums[i];
        }
        double maxAverage = calculateAvg(calculateArr);
        for (int i = k; i < nums.length; i++) {
            calculateArr[k - 1] = nums[i];
            double calculateAvgRes = calculateAvg(calculateArr);
            if (calculateAvgRes > maxAverage) {
                maxAverage = calculateAvgRes;
            }
        }

        result = maxAverage;
        return result;
    }

    private double calculateAvg(int[] calculateArr) {
        double sum = 0D;
        double result = 0D;
        for (int i = 0; i < calculateArr.length; i++) {
            sum += calculateArr[i];
        }
        BigDecimal b = new BigDecimal(sum / calculateArr.length);
        result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("calculateAvg,result = " + result);
        for (int i = 0; i < calculateArr.length - 1; i++) {
            calculateArr[i] = calculateArr[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = solution.findMaxAverage(nums, k);
        System.out.println(result);
    }
}
