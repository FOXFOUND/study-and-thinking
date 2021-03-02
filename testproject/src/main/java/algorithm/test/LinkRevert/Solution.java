package algorithm.test.LinkRevert;


/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode m;
        ListNode current = head;
        while (--left > 0) {
            --right;
            current = current.next;
        }
        m = current;
        ListNode n;
        while (--right > 0) {
            current = current.next;
        }
        n = current;
        ListNode mn = m;
        ListNode pre = null;
        ListNode mnHead, mnTail;
        mnTail = m.next;
        while (mn != null && mn != n) {
            ListNode next = mn.next;
            mn.next = pre;
            pre = current;
            current = next;
        }
        mnHead = pre;
        m.next = mnHead;
        mnTail.next = n;
        return head;

    }



}