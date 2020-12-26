package algorithm.test.brucks;

import com.alibaba.fastjson.JSON;

public class Solution3 {

    private static int lengthX;
    private static int widthY;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] arrHit = new int[hits.length];
        lengthX = grid.length - 1;
        widthY = grid[0].length - 1;

        for (int i = 0; i < hits.length; i++) {
            int drawCount = initDirection(grid, hits[i]);
            int x = hits[i][0];
            int y = hits[i][1];
            grid[x][y] = 0;
            arrHit[i] = drawCount;
        }
        return arrHit;
    }

    private int initDirection(int[][] grid, int[] hit) {
        int[][] directionArr = new int[4][5];
        int x = hit[0];
        int y = hit[1];

        if (hit.length != 2 && hit[3] == 0) {
            return 0;
        }

        //已经引用到了顶级子节点
        if (hit.length != 2 && hit[4] == 1) {
            return 0;
        }

        //已经是最顶层子节点,节点不会下落
        if (x == 0 && hit.length != 2) {
            //标记父节点,表示已经连到顶级节点
            hit[4] = 1;
            return 0;
        }
        //节点为空节点,节点不会下落
        if (hit.length == 2 && grid[x][y] == 0) {
            return 0;
        }
        int xPlus = x + 1;
        int xSub = x - 1;
        int yPlus = y + 1;
        int ySub = y - 1;
        int hasNode = 0;
        //上
        if (ySub >= 0 && grid[x][ySub] == 1) {
            directionArr[0][0] = x;
            directionArr[0][1] = ySub;
            directionArr[0][3] = 1;
            hasNode++;
        }
        //右
        if (xPlus <= lengthX && grid[xPlus][y] == 1) {
            directionArr[1][0] = xPlus;
            directionArr[1][1] = y;
            directionArr[1][3] = 1;
            hasNode++;
        }
        //下
        if (yPlus <= widthY && grid[x][yPlus] == 1) {
            directionArr[2][0] = x;
            directionArr[2][1] = yPlus;
            directionArr[2][3] = 1;
            hasNode++;

        }
        //左
        if (xSub >= 0 && grid[xSub][y] == 1) {
            directionArr[3][0] = xSub;
            directionArr[3][1] = y;
            directionArr[3][3] = 1;
            hasNode++;
        }

        //无法搜索到其他的节点了,当前节点是否掉落取决于父节点
        if (hasNode == 1) {
            return 1;
        }

        directionArr[0][2] = initDirection(grid, directionArr[0]);
        directionArr[1][2] = initDirection(grid, directionArr[1]);
        directionArr[2][2] = initDirection(grid, directionArr[2]);
        directionArr[3][2] = initDirection(grid, directionArr[3]);
        int drawCount = 0;

        int rootCount = 0;
        for (int i = 0; i < directionArr.length; i++) {
            //只有是存在的方向节点,才会进行统计
            if (directionArr[i][3] == 1) {
                //已经可以追溯到顶部不需要累加
                if (directionArr[i][4] == 1) {
                    //回溯标记父节点
                    if (hit.length != 2) {
                        hit[4] = 1;
                    }
                    rootCount++;
                    continue;
                }
                drawCount += directionArr[i][2];
            }


        }

        if (rootCount > 0) {
            drawCount = 0;
        }

        //没有节点落下,当前节点恢复
        if (drawCount == 0) {
            grid[x][y] = 1;
        }


        //子节点下落了,那么当前节点也应该下落
        if (drawCount != 0 && hit.length != 2) {
            drawCount++;
        }

        return drawCount;

    }

    public static void main(String[] args) {
//        extracted1();
//        extracted2();
//            extracted3();
//            extracted4();

        extracted5();

    }

    private static void extracted5() {
        int[][] grid = {{0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] hits = {{1, 3}, {3, 5}, {0, 3}, {3, 3}, {1, 1}, {4, 2}, {1, 0}, {3, 0}, {4, 5}, {2, 1}, {4, 4}, {4, 0}, {2, 4}, {2, 5}, {3, 4}, {0, 5}, {0, 4}, {3, 2}, {1, 5}, {4, 1}, {2, 2}, {0, 2}};
        Solution3 solution = new Solution3();
        int[] res = solution.hitBricks(grid, hits);
        //[0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,1]
        System.out.println(JSON.toJSONString(res));
    }

    private static void extracted1() {
        int[] l1 = new int[]{1, 0, 0, 0};
        int[] l2 = new int[]{1, 1, 1, 0};
        int[] hitL1 = new int[]{1, 0};
        int[][] grid = new int[][]{l1, l2};
        int[][] hits = new int[][]{hitL1};
        Solution3 solution = new Solution3();
        //  [2]
        int[] res = solution.hitBricks(grid, hits);
        System.out.println(JSON.toJSONString(res));
    }


    private static void extracted2() {
        int[] l1 = new int[]{1};
        int[] l2 = new int[]{1};
        int[] l3 = new int[]{1};
        int[] l4 = new int[]{1};
        int[] l5 = new int[]{1};
        int[] hitL1 = new int[]{3, 0};
        int[] hitL2 = new int[]{4, 0};
        int[] hitL3 = new int[]{1, 0};
        int[] hitL4 = new int[]{2, 0};
        int[] hitL5 = new int[]{0, 0};
        int[][] grid = new int[][]{l1, l2, l3, l4, l5};
        int[][] hits = new int[][]{hitL1, hitL2, hitL3, hitL4, hitL5};
        Solution3 solution = new Solution3();
        int[] res = solution.hitBricks(grid, hits);
        // [1,0,1,0,0]
        System.out.println(JSON.toJSONString(res));
    }


    private static void extracted3() {
        int[] l1 = new int[]{1, 1, 1};
        int[] l2 = new int[]{0, 1, 0};
        int[] l3 = new int[]{0, 0, 0};
        int[] hitL1 = new int[]{0, 2};
        int[] hitL2 = new int[]{2, 0};
        int[] hitL3 = new int[]{0, 1};
        int[] hitL4 = new int[]{1, 2};
        int[][] grid = new int[][]{l1, l2, l3};
        int[][] hits = new int[][]{hitL1, hitL2, hitL3, hitL4};
        Solution3 solution = new Solution3();
        int[] res = solution.hitBricks(grid, hits);
        //[0,0,1,0]
        System.out.println(JSON.toJSONString(res));
    }


    private static void extracted4() {
        int[][] grid = {{0, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] hits = {{6, 0}, {1, 0}, {4, 3}, {1, 2}, {7, 1}, {6, 3}, {5, 2}, {5, 1}, {2, 4}, {4, 4}, {7, 3}};
        Solution3 solution = new Solution3();
        int[] res = solution.hitBricks(grid, hits);
        //[0,0,0,0,0,0,0,0,0,0,0]
        System.out.println(JSON.toJSONString(res));
    }
}
