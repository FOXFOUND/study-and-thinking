package algorithm.test.addTwoNumbers;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        ListNode pre = new ListNode();
        ListNode head = pre;
        //计算
        while (l1 != null || l2 != null) {
            ListNode tail = new ListNode();
            if (l1 != null && l2 != null) {
                tail.val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;

            } else if (l1 != null) {
                tail.val = l1.val;
                l1 = l1.next;

            } else if (l2 != null) {
                tail.val = l2.val;
                l2 = l2.next;

            }
            pre.next = tail;
            pre = tail;


        }
        //指向第一个数字
        head = head.next;
        ListNode res = head;
        //处理进位
        while (head != null) {
            if (head.val >= 10) {
                head.val = head.val - 10;
                if (head.next == null) {
                    ListNode next = new ListNode();
                    next.val = 1;
                    head.next = next;
                } else {
                    head.next.val = head.next.val + 1;
                }
            }
            head = head.next;
        }
        //返回
        return res;
    }

    public static void main(String[] args) {
        int[] arrA = new int[]{2, 4, 3};
        int[] arrB = new int[]{5, 6, 4};
        ListNode listNodeA = null;
        ListNode listNodeB = null;
        ListNode pre = new ListNode();
        ListNode head = pre;
        for (int i = 0; i < arrA.length; i++) {
            listNodeA = new ListNode();
            listNodeA.val = arrA[i];
            pre.next = listNodeA;
            pre = listNodeA;
        }
        head = head.next;
//        while (head !=null){
//            System.out.print(head.val + "-->");
//            head = head.next;
//        }
        System.out.println("");
        ListNode preB = new ListNode();
        ListNode headB = preB;
        for (int i = 0; i < arrB.length; i++) {
            listNodeB = new ListNode();
            listNodeB.val = arrB[i];
            preB.next = listNodeB;
            preB = listNodeB;
        }
        headB = headB.next;
//        while (headB !=null){
//            System.out.print(headB.val + "-->");
//            headB = headB.next;
//        }

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(head, headB);
        while (res != null) {
            System.out.print(res.val + "-->");
            res = res.next;
        }

    }
}
