package algorithm.test.cherry.pickup;

/**
 *
 * 一个N x N的网格(grid)代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 *
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 *
 * 从位置(0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，
 * 并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，
 * 只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cherry-pickup
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

//1.分解子问题
/**
 * 对于采樱桃问题来说,只有两个路径,从0,0到 n-1,n-1 ,或者是从n-1,n-1到0,0
 * 这两个子问题是镜像问题,只有解决了一个,另一个也自动解决了
 * 下边通过 0,0 -> n-1,n-1 这个路径来分析
 * 当前节点只能通过两种方式进行操作,向下或者是向右,也就是当前问题变成了
 * 子问题的向下或者是向右,也就是说当前问题是存在转移方程的,是可以根据动态规划进行解决的
 *
 */

//2.转移方程
/**
 *   dp(i,j) = max(dp[i,j+1],dp[i+1,j]  ) + value(i,j);
 *   其中 dp代表动态规划的记录数组
 *   value代表价值数组
 *
 *   初始化条件,由于数据经过不断递归之后,最后落到了 n-1,n-1上,因此
 *   需要将dp[n-1,n-1]的值初始化为value[n-1,n-1];
 */
//3.限制条件
/**
 *   0<=    i   <=n-1
 *   0<=    j   <=n-1
 *   value[i,j] == -1 直接返回
 */

// 4.基本数据结构

/**
 * dp[][]  动态规划,背包数据
 * value [] 价值数组 -1,0 ,1
 * cherryPickUpNum  采到樱桃数
 */

import java.util.Arrays;




class Solution {
    public int cherryPickup(int[][] grid) {
        int ans = 0;
        int[][] path = bestPath(grid);
        if (path == null) return 0;
        //通过走过的路径,采樱桃
        for (int[] step: path) {
            ans += grid[step[0]][step[1]];
            grid[step[0]][step[1]] = 0;
        }
        //从上往下的最优解,也是从下往上的最优解
        for (int[] step: bestPath(grid))
            ans += grid[step[0]][step[1]];

        return ans;
    }

    public int[][] bestPath(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        for (int[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        dp[N-1][N-1] = grid[N-1][N-1];
        //自底向上,迭代构建花费数组
        for (int i = N-1; i >= 0; --i) {
            for (int j = N-1; j >= 0; --j) {
                if (grid[i][j] >= 0 && (i != N-1 || j != N-1)) {
                    dp[i][j] = Math.max(i+1 < N ? dp[i+1][j] : Integer.MIN_VALUE,
                            j+1 < N ? dp[i][j+1] : Integer.MIN_VALUE);
                    dp[i][j] += grid[i][j];
                }
            }
        }
        //如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
        if (dp[0][0] < 0) return null;
        //记录走过的路径
        int[][] ans = new int[2*N - 1][2];
        int i = 0, j = 0, t = 0;
        while (i != N-1 || j != N-1) {
            if (j+1 == N || i+1 < N && dp[i+1][j] >= dp[i][j+1]) i++;
            else j++;

            ans[t][0] = i;
            ans[t][1] = j;
            t++;
        }
        return ans;
    }
}

