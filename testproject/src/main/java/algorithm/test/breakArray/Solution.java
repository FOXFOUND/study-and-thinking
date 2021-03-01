package algorithm.test.breakArray;

import java.util.Arrays;

/**
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 *
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2vYnGI
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        final int mod = 1000000007;
        int ans = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int j = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            //对于排序好的drink, 小于当前的都满足
            while (j >= 0 && staple[i] + drinks[j] > x) j--;
            if (j == -1) break;
            //加一是因为数组的索引是从0开始的
            ans += j + 1;
        }
        ans %= mod;
        return ans;
    }


}
