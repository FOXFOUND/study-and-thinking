package algorithm.test.strong.password;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A password is considered strong if the below conditions are all met:
 *
 * It has at least 6 characters and at most 20 characters.
 * It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
 *
 * In one step, you can:
 *
 * Insert one character to password,
 * Delete one character from password, or
 * Replace one character of password with another character.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Queue<Integer> que;
    public int strongPasswordChecker(String s) {
        int len = s.length();
        if (len == 0) return 6;
        int need1 = 1;
        int need2 = 1;
        int need3 = 1;
        que = new PriorityQueue<Integer>((a, b) -> a % 3 - b % 3);
        int cnt = 1;
        if (Character.isLowerCase(s.charAt(0))) need1 = 0;
        if (Character.isUpperCase(s.charAt(0))) need2 = 0;
        if (Character.isDigit(s.charAt(0))) need3 = 0;
        for (int i = 1; i < len; ++i) {
            if (Character.isLowerCase(s.charAt(i))) need1 = 0;
            if (Character.isUpperCase(s.charAt(i))) need2 = 0;
            if (Character.isDigit(s.charAt(i))) need3 = 0;
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (cnt >= 3)
                    que.add(cnt);
                cnt = 1;
            } else {
                ++cnt;
            }
        }
        if (cnt >= 3)
            que.add(cnt);
        int need = need1 + need2 + need3;
        int ans = 0;
        if (len < 6) {
            if (len == 5) {
                if (need >= 2 || cnt == 5) return need;
                return 1;
            } else {
                return 6 - len;
            }
        }

        while (!que.isEmpty() && len > 20) {
            int now = que.poll();
            ++ans;--len;
            if (--now >= 3) que.add(now);
        }
        if (len > 20) ans += len - 20 + Math.max(0, need);
        else {
            int cunt = 0;
            while (!que.isEmpty()) {
                int now = que.poll();
                //三个连续的字符,主要替换中间的字符就不会连续了
                cunt += now / 3;
            }
            //如果替换操作的步骤比need多,则可以在替换操作中包含need操作
            ans += Math.max(cunt, need);
        }
        return ans;
    }
}

