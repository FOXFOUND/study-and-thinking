package algorithm.test.shortestSeq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        int[] big = new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = new int[]{1, 5, 9};
        Solution solution = new Solution();
        int[] res = solution.shortestSeq(big, small);
        System.out.println(Arrays.toString(res));
    }

    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> smallCharMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> bigCharMap = new HashMap<>();
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (int i = 0; i < small.length; i++) {
            int value = smallCharMap.getOrDefault(small[i], 0);
            smallCharMap.put(small[i], value + 1);
        }
        int left = 0, right = 0;
        while (right < big.length) {
            int value = bigCharMap.getOrDefault(big[right], 0);
            bigCharMap.put(big[right], value + 1);
            while (checkSpan(smallCharMap, bigCharMap)) {
                if (res[0] == -1 || (res[1] - res[0] + 1) > (right - left + 1)) {
                    res[0] = left;
                    res[1] = right;
                }

                int valueCheck = bigCharMap.getOrDefault(big[left], 0);
                bigCharMap.put(big[left], valueCheck - 1);
                left++;
            }
            right++;
        }
        if (res[0] == -1) {
            return new int[]{};
        }
        return res;

    }

    private boolean checkSpan(Map<Integer, Integer> smallCharMap, Map<Integer, Integer> bigCharMap) {

        for (Map.Entry<Integer, Integer> entry : smallCharMap.entrySet()) {
            if (bigCharMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
