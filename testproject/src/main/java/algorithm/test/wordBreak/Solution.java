package algorithm.test.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //通过 set 进行结果去重
        Set<String> wordDictSet = new HashSet(wordDict);
        //创建结果数组 dp[i] 代表,i个字符是否能被单词分解
        boolean[] dp = new boolean[s.length() + 1];
        // 0可以字符,可以分解
        dp[0] = true;
        //由于subString是左闭右开,所以i = s.length
        for (int i = 1; i <= s.length(); i++) {
            //j是区域字符串的左指针 ,i是区域字符串的右指针
            for (int j = 0; j < i; j++) {
                //将字符串 0-i ,分解成 0-j 和 [j,i)
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    //可以分解,直接break,进行i+1位置的查找
                    dp[i] = true;
                    break;
                }
            }
        }
        //判断结果
        return dp[s.length()];
    }
}


