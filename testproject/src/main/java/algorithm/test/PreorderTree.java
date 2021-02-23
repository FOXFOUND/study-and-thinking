package algorithm.test;

import com.alibaba.fastjson.JSON;

/**
 * 前序遍历的二叉搜索树,构建二叉树
 */
public class PreorderTree {
    class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }

    public TreeNode getRoot(int[] arr) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = new TreeNode();
        root.value = arr[0];
        TreeNode currentNode = root;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                TreeNode leftNode = new TreeNode();
                leftNode.value = arr[i];
                currentNode.left = leftNode;
                currentNode = leftNode;
            }else {
                TreeNode rightNode = new TreeNode();
                rightNode.value = arr[i];
                currentNode.right = rightNode;
                currentNode = rightNode;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 1, 7, 10, 12};
        PreorderTree preorderTree = new PreorderTree();
        TreeNode treeNode =  preorderTree.getRoot(arr);
        System.out.println(JSON.toJSONString(treeNode));

    }
}
