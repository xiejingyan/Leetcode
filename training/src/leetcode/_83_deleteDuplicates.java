package leetcode;

public class _83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (p.val == q.val) {
                p.next = q.next;
            }
            else {
                p = q;
            }
            q = q.next;
        }
        return head;
    }

//    遍历
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
