package algorithm.test.buildTree;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeSub(preorder,inorder);
        return  root;

    }

    private TreeNode buildTreeSub(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length ==0){
            return null;
        }
        if(inorder ==null || inorder.length == 0){
            return null;
        }
        int rootValue = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }
        int [] leftNode = Arrays.copyOfRange(inorder,0 ,index );
        int [] rightNode = Arrays.copyOfRange(inorder,index+1,inorder.length);
        return null;
    }
}
