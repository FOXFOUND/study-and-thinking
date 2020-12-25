package algorithm.test.fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Q18 水果酥饼日
 * 日本每月的 2222 日是水果酥饼日。因为看日历的时候，2222 日的上方刚好是 1515 日，也就是 “ ‘2222’ 这个数字上面点缀着草莓 ”。
 *
 * 切分酥饼的时候，要求切分后每一块上面的草莓个数都不相同。假设切分出来的 NN 块酥饼上要各有 “ 1~N 个（共 N(N+1)÷2 个草莓）”。
 *
 * 但这里要追加一个条件，那就是 “一定要使相邻的两块酥饼上的数字之和是平方数”。
 *
 * 举个例子，假设 N＝4 时采用如图 11 的切法。这时，虽然 1+3＝4 得到的是平方数，但 “1 和 4” “2 和 3” “2 和 4” 的部分都不满足条件（图 1）。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/circle/discuss/amUE3E/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    // 记录无向图
    List<Integer>[] edges;
    // 记录搜索过程中每个数是否被使用过
    boolean[] used;
    // 记录搜索过程中的序列
    List<Integer> ans = new ArrayList<Integer>();
    // 是否找到答案
    boolean found = false;

    public List<Integer> minimalFruitPie() {
        // 从小到大枚举 n
        for (int n = 2;; ++n) {
            edges = new List[n + 1];
            for (int i = 0; i <= n; ++i) {
                edges[i] = new ArrayList<Integer>();
            }
            // 建立无向图
            for (int i = 1; i <= n; ++i) {
                // 枚举平方数 root^2
                for (int root = 1; root * root <= i + n; ++root) {
                    int j = root * root - i;
                    if (j > i) {
                        edges[i].add(j);
                        edges[j].add(i);
                    }
                }
            }
            used = new boolean[n + 1];
            dfs(0, n);
            if (found) {
                return ans;
            }
        }
    }

    public void dfs(int pos, int n) {
        if (pos == n) {
            // 搜索完成，还需要判断首尾之和是否为完全平方数
            int sum = ans.get(0) + ans.get(ans.size() - 1);
            int root = (int) Math.sqrt(sum);
            if (root * root == sum) {
                found = true;
            }
        } else if (pos == 0) {
            // 由于酥饼是圆形，因此可以指定第一个数选择 1
            used[1] = true;
            ans.add(1);
            dfs(pos + 1, n);
            if (found) {
                return;
            }
            used[1] = false;
            ans.remove(ans.size() - 1);
        } else {
            // 只能选与上一个数形成完全平方数，并且还未被选择的数
            for (int num : edges[ans.get(ans.size() - 1)]) {
                if (!used[num]) {
                    used[num] = true;
                    ans.add(num);
                    dfs(pos + 1, n);
                    if (found) {
                        return;
                    }
                    used[num] = false;
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
}
