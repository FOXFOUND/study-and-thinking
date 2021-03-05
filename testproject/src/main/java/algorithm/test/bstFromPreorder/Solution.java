package algorithm.test.bstFromPreorder;

import com.alibaba.fastjson.JSON;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (i + 1 < preorder.length && preorder[i + 1] > root) {
                rootIndex = i;
                break;
            }
        }
        int leftStart = 0;
        int leftEnd = rootIndex;
        int rightStart = rootIndex + 1;
        int rightEnd = preorder.length - 1;
        TreeNode rootNode = bstFromPreorderSub(preorder, leftStart, leftEnd, rightStart, rightEnd);
        return rootNode;
    }

    private TreeNode bstFromPreorderSub(int[] preorder, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        if (leftStart > leftEnd || rightStart > rightEnd || leftEnd > rightStart) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[leftStart]);
        int rootIndex = 0;
        for (int i = leftStart; i < leftEnd; i++) {
            if (i + 1 <= leftEnd && preorder[i + 1] > preorder[leftStart]) {
                rootIndex = i;
                break;
            }
        }
        treeNode.left = bstFromPreorderSub(preorder, leftStart + 1, rootIndex, rootIndex + 1, leftEnd);

        int right = 0;
        for (int i = rightStart; i < rightEnd; i++) {
            if (i + 1 <= rightEnd && preorder[i + 1] > preorder[leftStart]) {
                right = i;
                break;
            }
        }
        treeNode.right = bstFromPreorderSub(preorder, rightStart + 1, right, right + 1, rightEnd);
        return treeNode;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{8,5,1,7,10,12};
        Solution solution = new Solution();
        TreeNode root = solution.bstFromPreorder(nums);
        System.out.println(JSON.toJSONString(root));
    }
}
