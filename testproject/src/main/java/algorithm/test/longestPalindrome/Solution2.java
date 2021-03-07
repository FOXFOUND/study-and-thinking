package algorithm.test.longestPalindrome;

class Solution2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // l 代表回文子串左右指针的距离
        for (int l = 0; l < n; ++l) {
            // i 代表当前的left指针的位置, j代表right指针的位置
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                //长度为1的字符串是回文串
                if (l == 0) {
                    dp[i][j] = true;
                    //长度为2,只有left == right 才是
                } else if (l == 1) {
                    //跨度为2,但是left起始点可能不同,所以需要多次初始化
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    //如果left == right,只要内部是回文串,那么当前位置就是回文串
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                //当前位置是回文串 ,l = right-left
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}


