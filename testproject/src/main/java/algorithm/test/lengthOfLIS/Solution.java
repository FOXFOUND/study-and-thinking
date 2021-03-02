package algorithm.test.lengthOfLIS;

public class Solution {
    //连续递增子序列长度
    public int lengthOfLIS(int[] nums) {
        int maxSubLength = 1;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            right = i;
            int count = 1;
            while (++right < nums.length && nums[right] > nums[right - 1]) {
                count++;
            }
            maxSubLength = Math.max(maxSubLength, count);
        }
        return maxSubLength;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{10,9,2,5,3,7,101,18};
        Solution solution = new Solution();
        int res = solution.lengthOfLIS(arr);
        System.out.println(res);


    }
}
