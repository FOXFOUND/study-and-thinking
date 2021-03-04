package algorithm.test.findUnsortedSubarray;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = 0;
        int left = 0, right = nums.length - 1;
        int leftReal = 0, rightReal = nums.length - 1;
        while (true) {
            while (left < right &&
                    left + 1 < nums.length &&
                    nums[left + 1] >= nums[left]) {
                if (left - 1 >= 0 &&
                        nums[left + 1] == nums[left] &&
                        nums[left - 1] < nums[left]) {
                    leftReal = left;
                }
                left++;
            }
            if (nums[left] != nums[leftReal]) {
                leftReal = left;
            }


            while (left < right &&
                    right - 1 >= 0 &&
                    nums[right - 1] <= nums[right]) {
                if (right + 1 < nums.length &&
                        nums[right - 1] == nums[right] &&
                        nums[right] < nums[right + 1]) {
                    rightReal = right;
                }
                right--;
            }
            if (nums[right] != nums[rightReal]) {
                rightReal = right;
            }

            if (left != right) {
                max = Math.max(max, rightReal - leftReal + 1);
                Arrays.sort(nums, leftReal, rightReal + 1);
            } else {
                break;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};  //5
        // int[] nums = new int[]{1, 3, 2, 2, 2};  //4
        int[] nums = new int[]{1, 2, 4, 5, 3};
        int res = solution.findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
