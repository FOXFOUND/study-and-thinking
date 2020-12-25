package algorithm.test.brucks;

import com.alibaba.fastjson.JSON;

public class Solution2 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] arrHit = new int[hits.length];
        int lengthX = grid.length - 1;
        int widthY = grid[0].length - 1;
        for (int i = 0; i < hits.length; i++) {
            int drawCount = initDirection(grid, hits[i], lengthX, widthY);
            int x = hits[i][0];
            int y = hits[i][1];
            grid[x][y] = 0;
            arrHit[i] = drawCount;
        }
        return arrHit;
    }

    private int initDirection(int[][] grid, int[] hit, int lengthX, int widthY) {
        int[][] directionArr = new int[4][4];
        int x = hit[0];
        int y = hit[1];

        //用来判断 [0,0]节点还是数组的初始化为[0,0]
        if (hit.length != 2 && hit[3] != 1) {
            return 0;
        }
        //标记清除
        grid[x][y] = 0;
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
        if (hasNode == 0) {
            if (x == 0 || hit.length == 2) {
                return 0;
            }
            return 1;

        }


        directionArr[0][2] = initDirection(grid, directionArr[0], lengthX, widthY);
        directionArr[1][2] = initDirection(grid, directionArr[1], lengthX, widthY);
        directionArr[2][2] = initDirection(grid, directionArr[2], lengthX, widthY);
        directionArr[3][2] = initDirection(grid, directionArr[3], lengthX, widthY);

        int drawCount = 0;

        for (int i = 0; i < directionArr.length; i++) {
            drawCount += directionArr[i][2];
        }

        //子节点下落了,那么当前节点也应该下落
        if (drawCount != 0 && hit.length != 2) {
            drawCount++;
        }
        //没有节点落下,当前节点恢复
        if (drawCount == 0) {
            grid[x][y] = 1;
        }
        return drawCount;

    }

//    public static void main(String[] args) {
//        int[] l1 = new int[]{1, 0, 0, 0};
//        int[] l2 = new int[]{1, 1, 1, 0};
//        int[] hitL1 = new int[]{1, 0};
//        int [][] grid = new int [][]{l1,l2};
//        int [][] hits = new int [][]{hitL1};
//        Solution2 solution = new Solution2();
//        //  [2]
//        int [] res = solution.hitBricks(grid,hits);
//        System.out.println(JSON.toJSONString(res));
//
//    }

//    public static void main(String[] args) {
//        int[] l1 = new int[]{1, 0, 0, 0};
//        int[] l2 = new int[]{1, 1, 0, 0};
//        int[] hitL1 = new int[]{1, 1};
//        int[] hitL2 = new int[]{1, 0};
//        int[][] grid = new int[][]{l1, l2};
//        int[][] hits = new int[][]{hitL1, hitL2};
//        Solution2 solution = new Solution2();
//        // [0,0]
//        int[] res = solution.hitBricks(grid, hits);
//        System.out.println(JSON.toJSONString(res));
//
//    }

    public static void main(String[] args) {
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
        Solution2 solution = new Solution2();
        int[] res = solution.hitBricks(grid, hits);
        // [1,0,1,0,0]
        System.out.println(JSON.toJSONString(res));
    }


}
