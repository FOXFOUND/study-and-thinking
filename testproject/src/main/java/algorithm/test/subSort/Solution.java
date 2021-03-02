package algorithm.test.subSort;

import java.util.Arrays;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] subSort(int[] array) {
        int[] res = new int[]{-1, -1};
        if (array == null || array.length == 0) {
            return res;
        }
        subSortSub(array, res);
        return res;
    }

    private void subSortSub(int[] array, int[] res) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if ((left + 1) <= right && array[left] <= array[left + 1]) {
                left++;
            } else {
                break;
            }
        }
        while (left < right) {
            if ((right - 1) >= left && array[right - 1] <= array[right]) {
                right--;
            } else {
                break;
            }
        }

        if (left != right) {
            Arrays.sort(array, left, right + 1);
            if (res[0] > left || res[0] == -1) {
                res[0] = left;
            }
            if (res[1] < right || res[1] == -1) {
                res[1] = right;
            }
            subSortSub(array, res);


        } else {
            return;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        //int[] arr = new int[]{};
        Solution solution = new Solution();
        int[] res = solution.subSort(arr);
        System.out.println(Arrays.toString(res));
    }
}
