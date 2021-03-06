package algorithm.test.keyboard;

/**
 * 小扣在秋日市集购买了一个古董键盘。由于古董键盘年久失修，键盘上只有 26 个字母 a~z 可以按下，且每个字母最多仅能被按 k 次。
 *
 * 小扣随机按了 n 次按键，请返回小扣总共有可能按出多少种内容。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
 *
 * 示例 1：
 *
 * 输入：k = 1, n = 1
 *
 * 输出：26
 *
 * 解释：由于只能按一次按键，所有可能的字符串为 "a", "b", ... "z"
 *
 * 示例 2：
 *
 * 输入：k = 1, n = 2
 *
 * 输出：650
 *
 * 解释：由于只能按两次按键，且每个键最多只能按一次，所有可能的字符串（按字典序排序）为 "ab", "ac", ... "zy"
 *
 * 提示：
 *
 * 1 <= k <= 5
 * 1 <= n <= 26*k
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Uh984O
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 动态规划首先要列转移方程
 */


/**
 * dp[i][j]表示总长度为ii，用了前jj种字母可能出现的字符串的数量，可以得到如下转移方程。
 *
 * i 表示总的按键次数
 * j 表示26个字母
 * dp[i][j]=\sum_{x=0}^kdp[i-x][j-1]·C_i^x
 * dp[i][j]=
 * x=0
 * ∑
 * k
 * ​
 *  dp[i−x][j−1]⋅C
 * i
 * x
 * ​
 *
 *
 * 其中，xx表示第jj种字母出现的次数，其值可以为0,1,..k0,1,..k，对于每一个xx，都有C_i^xC
 * i
 * x
 * ​
 *  种位置可以选择。
 * 例如，x=2x=2，表示第jj种字符出现了22次，他可能出现在前ii个位置中的任意两个，是一个组合问题，其结果是C_i^2C
 * i
 * 2
 * ​
 *  。
 *
 * 作者：DavidFFFan
 * 链接：https://leetcode-cn.com/problems/Uh984O/solution/dong-tai-gui-hua-by-davidfffan-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {

    private final int MOD = 1000000007;

    public int keyboard(int m, int n) {
        // 预处理组合数
        long[][] comb = new long[n + 1][n + 1];
        comb[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
        // 分组背包
        long[] dp = new long[n + 1];
        dp[0] = 1;
        //为什么先26个字母循环
        //1.因为对于每个字母来说发生的情况,都是同一个类型的问题,所以只要解决一个
        //字母,剩余的字母进行循环就好了
        //2.随着i的增加dp[]数据的内容就代表,在i个字母的情况下,随机出现的情况
        for (int i = 0; i < 26; i++) {
            //为什么要倒着循环 , j代表按键次数
            //1.这个是由下边的dp[]数据的行驶决定的,因为下边的k是正向循环
            //为了初始化dp[j-k]的内容
            //2.如果j是正着循环会导致是输出的值比正确的值大,因为
            //dp[]数组是从底向上累加的,dp[]的某些位置提前进行了初始化
            //比如第一次循环只初始 2,4,6位置的值
            //但是第一次却初始化了2,3,5,6,7的值,在下一次的循环种就导致了偏差,导致结果变大
            for (int j = n; j >= 1; j--) {
                // k代表,每一个字母重复的次数
                for (int k = 1; k <= m; k++) {
                    //如果重复次数大于按键次数,说明当前按键已经超过最大按的计数,这个按键
                    //已经不能再按了
                    if (k > j) break;
                    // comb[j][k] 表示一共有j次,其中 k次,发生的可能的组合数
                    // dp[j-k] 表示 j-k 次的可能次数
                    // dp[j-k] * comb[j][k] 表示 , 剩余j-k次的组合可能的次数
                    // dp[j-k]ABC a=,Adp[j-k]BC  ....
                    //dp[j] = dp[j] + dp[j - k] * comb[j][k];
                    // 当前字母重复 j次,或者当前字母重复k次剩余的字母j-k次
                    dp[j] += dp[j - k] * comb[j][k];
                    dp[j] %= MOD;
                }
            }
        }
        return (int) dp[n];
    }
}