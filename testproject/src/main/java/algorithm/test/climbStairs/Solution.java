package algorithm.test.climbStairs;

public class Solution {
    public int climbStairs(int n) {
        return climbStairsSub(n - 1) + climbStairsSub(n - 2);
    }

    private int climbStairsSub(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == -1) {
            return 0;
        }
        return climbStairsSub(i-1) + climbStairsSub(i-2);
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        int res = solution.climbStairs(2);  //2
        System.out.println(res);
    }
}
