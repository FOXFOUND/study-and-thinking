package algorithm.test.minSubString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //目标子字符的每个字符次数
    Map<Character, Integer> ori = new HashMap<Character, Integer>();

    //大字符串的每个字符的出现次数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        //子字符串的长度
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        //窗口左右指针
        int l = 0, r = -1;
        //窗口长度 ,  区域最优解的左指针,右指针
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        //目标字符串的长度
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            //初始化窗口,最大满足的窗口
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                //计算每个字符出现的次数
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            //是否需要搜索,check() == true 进行收缩
            while (check() && l <= r) {
                //可以进行收紧
                if (r - l + 1 < len) {
                    //目前的窗口区间
                    len = r - l + 1;
                    //返回值的左指针
                    ansL = l;
                    //返回值的右指针
                    ansR = l + len;
                }
                //窗口左指针指向的当前字符属于目标字符
                if (ori.containsKey(s.charAt(l))) {
                    //目标窗口对应的字符位置 -1
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                //窗口左指针前移,判断时候可以收缩
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    //判断是否每一个子字符串的字符都在当前窗口内
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}

