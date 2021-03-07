package algorithm.test.sortedArrayToBST;

import com.alibaba.fastjson.JSON;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            TreeNode current = root;
            TreeNode pre = null;
            int flag = 0;
            while (current != null) {
                pre = current;
                if (nums[i] < current.val) {
                    current = current.left;
                    flag = 1;
                } else {
                    current = current.right;
                    flag = 0;
                }
            }
            TreeNode treeNode = new TreeNode(nums[i]);
            if (flag == 1) {
                pre.left = treeNode;
            } else {
                pre.right = treeNode;
            }


        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10, -3, 0, 5, 9};
        TreeNode treeNode = solution.sortedArrayToBST(nums);
        System.out.println(JSON.toJSONString(treeNode));
    }
}
