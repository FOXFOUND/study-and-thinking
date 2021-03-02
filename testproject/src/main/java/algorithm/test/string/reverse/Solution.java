package algorithm.test.string.reverse;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean validPalindrome(String s) {

        boolean res = validPalindromeSub(s, 0, s.length() - 1, 0);
        return res;

    }

    private boolean validPalindromeSub(String s, int left, int right, int deleteCount) {
        if (deleteCount > 1 ) {
            return false;
        }
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            boolean res = validPalindromeSub(s, left + 1, right, deleteCount + 1) || validPalindromeSub(s, left, right - 1, deleteCount + 1);
            return res;

        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abbca"));
    }
}
