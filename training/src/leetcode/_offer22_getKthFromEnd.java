package leetcode;

public class _offer22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        int tmp = 0;
        while (p != null) {
            p = p.next;
            if (tmp < k) {
                tmp++;
            }
            else {
                q = q.next;
            }
        }
        return q;
    }
}
