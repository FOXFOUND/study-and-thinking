package algorithm.test.isSymmetric;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        boolean res = isSymmetricSub(root,root);
        return res;
    }

    private boolean isSymmetricSub(TreeNode root, TreeNode root1) {
        if(root == null && root1 ==null){
            return true;
        }
        if(root ==null && root1!=null){
            return false;
        }
        if(root !=null && root1 ==null){
            return false;
        }
        return root.val == root1.val && isSymmetricSub(root.left,root1.right) && isSymmetricSub(root.right,root1.left);
    }
}
