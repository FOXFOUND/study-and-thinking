package algorithm.test.lowestCommonAncestor;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }




    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        /**
         * 1. p和q一定是一个父节点的左右子节点或者左右子树中的节点
         * 2. 如果左右子树节点不为空,那么说明当前节点是公共祖先
         * 3. 因为当前的祖先节点的子树,已经包含了p和q,所以其他的子树中不可能出现
         *    leftNode!=null && rightNode!=null的情况
         * 4. 对于当前节点的父节点只会出现 leftNode !=null ? leftNode : rightNode
         *    父节点的父节点同理
         * 5. if(root == null || root.val == p.val || root.val == q.val) 用来验证节点存在
         * 6. leftNode!=null && rightNode!=null 用来判断公共祖先
         * 7. leftNode !=null ? leftNode : rightNode 用来将结果递归向上返回
         */


        //当前的root节点就是 p或者q节点中的一个节点
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode leftNode = lca(root.left,p,q);
        TreeNode rightNode = lca(root.right,p,q);
        if((leftNode!=null && rightNode!=null)){
            return root;
        }
        return leftNode !=null ? leftNode : rightNode;
    }


}
