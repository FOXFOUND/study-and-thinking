package algorithm.test.convertBiNode;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    TreeNode head = new TreeNode(-1);   // 为了返回单向链表的头节点而多设的一个节点
    TreeNode perv = null;               // 指向当前节点的前一个节点
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    /**
     * 中序遍历
     * @param root
     */
    public void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);

        if (perv == null) {     // 第一个节点
            perv = root;        // 记录第一个节点
            head.right = root;  // 记录它，它将作为单链表的表头
        } else {                // 第一个节点之后的节点
            perv.right = root;  // 前一个节点的右指针指向当前节点
            perv = root;        // 更新perv指向
        }

        root.left = null;       // 当前节点的左指针设为null

        helper(root.right);
    }


}
