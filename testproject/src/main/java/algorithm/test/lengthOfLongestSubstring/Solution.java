package algorithm.test.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        int left = 0;
        while (left < s.length()) {
            String key = String.valueOf(s.charAt(left));
            if (map.containsKey(key)) {
                int pre = map.get(key);
                for (int i = pre; i < left; i++) {
                    key = String.valueOf(s.charAt(i));
                    map.remove(key);
                }
                left = pre + 1;
                count = 0;

            } else {
                count++;
                map.put(key, left);
                left++;
            }
            maxLength = Math.max(maxLength, count);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String s = "abcabcbb";    //3
        //String s = "";  //0
        //String s = "bbbbb";   // 1
        //String s = "pwwkew";  //3
        String s = "dvdf";  // 3
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
