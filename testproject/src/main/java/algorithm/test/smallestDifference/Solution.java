package algorithm.test.smallestDifference;

import java.util.Arrays;

/**
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 *  
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 *  
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int smallestDifference(int[] a, int[] b) {
        long ans = Long.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return 0;
            else if (a[i] > b[j]) {
                ans = Math.min((long) a[i] - (long) b[j], ans);
                j++;
            } else {
                ans = Math.min((long) b[j] - (long) a[i], ans);
                i++;
            }
        }

        return  (int)ans;
    }
}
