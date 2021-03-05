package algorithm.test.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && word.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
