package algorithm.test.bstFromPreorder;

import com.alibaba.fastjson.JSON;

/**
 * 根据前序遍历构建二叉树
 */
public class PreorderTreeTwice {
    class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }


    public TreeNode getRoot(int[] arr) {

        TreeNode root = new TreeNode();
        root.value = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            TreeNode current = root;
            while (true){
                if(arr[i]<current.value){
                    if(current.left == null){
                        TreeNode leftNode = new TreeNode();
                        leftNode.value = arr[i];
                        current.left =leftNode;
                        break;
                    }else {
                        current = current.left;
                    }
                }else {
                    if (current.right == null){
                        TreeNode rightNode = new TreeNode();
                        rightNode.value = arr[i];
                        current.right =rightNode;
                        break;
                    }else {
                        current = current.right;
                    }
                }
            }

        }
        return root;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 1, 7, 10, 12};
        PreorderTreeTwice preorderTree = new PreorderTreeTwice();
        TreeNode root = preorderTree.getRoot(arr);
        System.out.println(JSON.toJSONString(root));
        // {"left":{"left":{"value":1},"right":{"value":7},"value":5},"right":{"right":{"value":12},"value":10},"value":8}

    }
}
