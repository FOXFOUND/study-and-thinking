package algorithm.test.smallestK;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || arr.length < k) {
            return res;
        }
        sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int temp = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= temp) right--;
            while (left < right && arr[left] <= temp) left++;
            swap(arr, left, right);
        }
        arr[start] = arr[left];
        arr[left] = temp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
