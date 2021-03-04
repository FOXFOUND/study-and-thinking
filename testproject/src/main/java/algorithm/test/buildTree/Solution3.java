package algorithm.test.buildTree;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeSub(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeSub(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[preorderLeft];
        int index = map.get(root.val);
        int leftRange = index - inorderLeft;
        root.left = buildTreeSub(preorder, inorder, preorderLeft + 1, preorderLeft + leftRange, inorderLeft, index -1);
        root.right = buildTreeSub(preorder, inorder, preorderLeft + leftRange + 1, preorderRight, index + 1, inorderRight);
        return root;
    }
}
