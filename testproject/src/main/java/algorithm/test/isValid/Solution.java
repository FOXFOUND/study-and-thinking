package algorithm.test.isValid;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (character.equals('(') || character.equals('{') || character.equals('[')) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();

                if (character.equals(')')) {
                    if (!pop.equals('(')) {
                        return false;
                    }
                } else if (character.equals('}')) {
                    if (!pop.equals('{')) {
                        return false;
                    }
                } else if (character.equals(']')) {
                    if (!pop.equals('[')) {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";  //true
        boolean res = solution.isValid(s);
        System.out.println(res);
    }
}
