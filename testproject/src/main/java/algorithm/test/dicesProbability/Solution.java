package algorithm.test.dicesProbability;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[0];
        }

        double[][] dp = new double[n + 1][6 * n + 1];   // dp[i][j]表示：当有i个骰子时，掷出和为j的几率

        /*
            初始化 一颗骰子的情况
        */
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = (double) 1 / 6;
        }

        /*
            动态规划，计算 其他情况
        */
        for (int i = 2; i <= n; i++) {
            int curMaxValue = 6 * i;    // 当前最大值 = 6 * 骰子个数
            for (int j = i; j <= curMaxValue; j++) {
                /*
                    我们可以这样推导：有i个骰子，掷出和为j的可能性 == (有1个骰子，掷出和为1~6的可能性) *= (有i-1个骰子，掷出和为j-(1~6)的可能性)
                    根据推导，我们能够知道：
                        dp[i][j] += dp[1][k] * dp[i - 1][j - k];
                        k为 合理情况下 的 1～6
                */
                for (int k = 1; k <= 6; k++) {

                    // k >= j的话,其他的骰子就多余了,不符合题意
                    if (j - k <= 0) {   // k不能比j大
                        continue;
                    }
                    dp[i][j] += dp[1][k] * dp[i - 1][j - k];
                }
            }
        }

        // 将 计算结果 录入 结果数组
        double[] result = new double[5 * n + 1];
        int value = n;
        for (int i = 0; i < result.length; i++) {
            result[i] = dp[n][value++];
        }

        return result;
    }
}

