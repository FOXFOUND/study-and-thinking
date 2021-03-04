package algorithm.test.diameterOfBinaryTree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 经过根节点的最大长度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = root.left == null ? 0 : dio(root.left, 0);
        int rightLength = root.right == null ? 0 : dio(root.right, 0);
        return leftLength + rightLength;
    }

    private int dio(TreeNode root, int length) {
        if (root == null) {
            return length;
        }
        int leftLength = dio(root.left, length + 1);
        int rightLength = dio(root.right, length + 1);
        return leftLength > rightLength ? leftLength : rightLength;

    }
}
