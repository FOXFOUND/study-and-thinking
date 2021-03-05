package algorithm.test.removeNthFromEnd;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode res = head;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (n > list.size()) {
            return null;
        }
        int index = list.size() - n;
        if (index == 0) {
            res = res.next;
        } else {
            ListNode pre = list.get(index - 1);
            ListNode current = list.get(index);
            pre.next = current.next;
        }

        return res;
    }
}
