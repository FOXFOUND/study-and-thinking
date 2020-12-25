package algorithm.test.brucks;

import com.alibaba.fastjson.JSON;

/**
 * 我们有一组包含1和0的网格；其中1表示砖块。 当且仅当一块砖直接连接到网格的顶部，或者它至少有一块相邻（4 个方向之一）砖块不会掉落时，它才不会落下。
 * <p>
 * 我们会依次消除一些砖块。每当我们消除 (i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。一旦砖块掉落，它会立即从网格中消除（即，它不会落在其他稳定的砖块上）。
 * <p>
 * 返回一个数组表示每次消除操作对应落下的砖块数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] arrHit = new int[hits.length];
        int lengthX = grid.length - 1;
        int widthY = grid[0].length - 1;
        for (int i = 0; i < hits.length; i++) {
            int drawCount = 0;
            //上,右,下,左  顺时针方向
            int[][] directionArr = new int[4][2];
            initDirection(grid, hits[i], lengthX, widthY, directionArr);
            //遍历4个方向进行,判断是否掉落
            for (int j = 0; j < directionArr.length; j++) {
                int x = directionArr[j][0];
                int y = directionArr[j][1];
                //在顶部的不会掉落
                if (x == 0) {
                    continue;
                }
                drawCount = getDrawCount(grid, lengthX, widthY, drawCount, x, y);


            }
            arrHit[i] = drawCount;
        }
        return arrHit;
    }

    private int getDrawCount(int[][] grid, int lengthX, int widthY, int drawCount, int x, int y) {
        int xPlus = x + 1;
        int xSub = x - 1;
        int yPlus = y + 1;
        int ySub = y - 1;
        int nearBruckCount = 0;
        //上
        if (ySub >= 0 && grid[x][ySub] == 1) {
            nearBruckCount++;
        }
        //右
        if (xPlus <= lengthX && grid[xPlus][y] == 1) {
            nearBruckCount++;
        }
        //下
        if (yPlus <= widthY && grid[x][yPlus] == 1) {
            nearBruckCount++;
        }
        //左
        if (xSub >= 0 && grid[xSub][y] == 1) {
            nearBruckCount++;
        }
        if (nearBruckCount == 0) {
            drawCount++;
        }
        return drawCount;
    }

    private void initDirection(int[][] grid, int[] hit, int lengthX, int widthY, int[][] directionArr) {
        int x = hit[0];
        int y = hit[1];
        int xPlus = x + 1;
        int xSub = x - 1;
        int yPlus = y + 1;
        int ySub = y - 1;
        //上
        if (ySub >= 0 && grid[x][ySub] == 1) {
            directionArr[0][0] = x;
            directionArr[0][1] = ySub;

        }
        //右
        if (xPlus <= lengthX && grid[xPlus][y] == 1) {
            directionArr[1][0] = xPlus;
            directionArr[1][1] = y;

        }
        //下
        if (yPlus <= widthY && grid[x][yPlus] == 1) {
            directionArr[2][0] = x;
            directionArr[2][1] = yPlus;


        }
        //左
        if (xSub >= 0 && grid[xSub][y] == 1) {
            directionArr[3][0] = xSub;
            directionArr[3][1] = y;

        }

        //标记清除
        grid[x][y] = 0;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{1, 0, 0, 0};
        int[] l2 = new int[]{1, 1, 1, 0};
        int[] hitL1 = new int[]{1, 0};
        int [][] grid = new int [][]{l1,l2};
        int [][] hits = new int [][]{hitL1};
        Solution solution = new Solution();
        int [] res = solution.hitBricks(grid,hits);
        System.out.println(JSON.toJSONString(res));

    }


}