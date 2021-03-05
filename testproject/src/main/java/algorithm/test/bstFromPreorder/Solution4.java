package algorithm.test.bstFromPreorder;

import com.alibaba.fastjson.JSON;

public class Solution4 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = buildBst(preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildBst(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }

        int leftEnd = left;
        while (leftEnd + 1 <= right && preorder[leftEnd + 1] < root.val) leftEnd++;
        TreeNode leftNode = buildBst(preorder, left + 1, leftEnd);
        TreeNode rightNode = buildBst(preorder, leftEnd + 1, right);

        root.left = leftNode;
        root.right = rightNode;
        return root;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 5, 1, 7, 10, 12};
        Solution4 solution = new Solution4();
        TreeNode root = solution.bstFromPreorder(nums);
        System.out.println(JSON.toJSONString(root));
    }
}
