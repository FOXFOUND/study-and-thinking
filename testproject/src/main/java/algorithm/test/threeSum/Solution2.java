package algorithm.test.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int k = i + 1; //同一个元素不可以使用2次
            int j = nums.length - 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j - 1] == nums[j]) j--;
                    k++;
                    j--;
                }
                if (sum < 0) k++;
                if (sum > 0) j--;
            }

        }
        return ans;
    }
}
