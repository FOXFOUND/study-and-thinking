package algorithm.test;

import java.util.Arrays;

/**
 * 连续子数组和的绝对值的最大值
 * [-1,-4,5,2,-6,1]  7
 * [-1,-4,5,-1,2,-6,1] 6
 */
public class SubArrMax {
    //求子数组的和的绝对值的最大值
//先计算所有sum[0-j] 0<= j <n，然后对sum[0-j]的数组进行排序，那么对于任何i,j段的和等于：sum[i-j]= sum[0-j] - sum[0-i];
//设置数组sum用来存储子数组0-j的和
//因为已经对sum进行了排序，排序后只需要找到sum[sum.size()-1]-sum[0],
// sum[z]  (0<=z<sum.size())的绝对值的最大值即可。z为排序后的索引
//如果是sum[z]情形，z为排序后的索引，则maxAbs = abs(sum[0-i])
//如果是sum[sum.size()-1]-sum[0]情形，则maxAbs = abs(sum[i]-sum[j])
//时间复杂度：o(nlogn) 空间复杂度：o(n)
    public int maxAbsSum2(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return Math.abs(num[0]);
        int max_abs_sum;
        int[] sum = new int[num.length];
        int cur_sum = 0;
        for (int i = 0; i < num.length; i++) {
            cur_sum += num[i];
            if (cur_sum == 0)
                return 0;
            sum[i] = cur_sum;
        }
        Arrays.sort(sum);
        max_abs_sum = Math.abs(sum[sum.length - 1] - sum[0]);
        for (int i = 0; i < sum.length; i++) {
            cur_sum = Math.abs(sum[i]);
            if (cur_sum > max_abs_sum)
                max_abs_sum = cur_sum;
        }
        return max_abs_sum;
    }
}
