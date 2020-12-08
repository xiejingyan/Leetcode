package leetcode;

import java.util.Stack;

public class _19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> st = new Stack<>();
        ListNode tmp = new ListNode(0);
        int m = 0;
        tmp = head;
        while (tmp != null) {
            st.push(tmp);
            tmp = tmp.next;
            m++;
        }
        if (m == n) return head.next;
        else {
            for (int i = 1; i <= n; i++) {
                if (i == n) {
                    ListNode a = st.pop();
                    ListNode b = st.pop();
                    b.next = a.next;
                } else st.pop();
            }
            return head;
        }
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode first = tmp;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return tmp.next;
    }
}
