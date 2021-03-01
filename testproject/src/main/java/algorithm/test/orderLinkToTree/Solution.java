package algorithm.test.orderLinkToTree;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //1. 特例处理
        if (head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }
        //2. 利用快慢指针找链表中间节点
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while( fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //3. 创建树的根节点，并断开相应连接
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;

        //4. 递归链表中间节点左右两边的子链表
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}