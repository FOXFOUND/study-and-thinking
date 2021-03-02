package algorithm.test.multiSearch;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例：
 *
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] multiSearch(String big, String[] smalls) {

        int[][] arr = new int[smalls.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[]{};
        }
        if (big == null || smalls == null || smalls.length == 0) {
            return arr;
        }
        Map hashMap = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < big.length(); i++) {
            ArrayList indexList = (ArrayList) hashMap.getOrDefault(big.charAt(i), new ArrayList<Integer>());
            indexList.add(i);

            hashMap.put(big.charAt(i), indexList);
        }

        for (int i = 0; i < smalls.length; i++) {
            if (smalls[i] == null || smalls[i].length() == 0) {
                continue;
            }
            ArrayList indexList = (ArrayList) hashMap.getOrDefault(smalls[i].charAt(0), new ArrayList<Integer>());
            List position = new ArrayList<Integer>();
            for (int j = 0; j < indexList.size(); j++) {
                int count = 0;
                int indexBig = Integer.parseInt(String.valueOf(indexList.get(j)));
                int current = indexBig;
                for (int k = 0; k < smalls[i].length(); k++) {
                    if (indexBig <= big.length() - 1) {
                        if (smalls[i].charAt(k) != big.charAt(indexBig++)) {
                            break;
                        } else {
                            count++;
                        }
                    }
                }
                if (count == smalls[i].length()) {
                    position.add(current);
                }

            }
            int[] arri = new int[position.size()];
            for (int j = 0; j < arri.length; j++) {
                arri[j] = Integer.parseInt(String.valueOf(position.get(j)));
            }
            arr[i] = arri;

        }
        return arr;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String big = "mississippi";
        String[] smalls = new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] res = solution.multiSearch(big, smalls);
        System.out.println(JSON.toJSONString(res));
    }
}
