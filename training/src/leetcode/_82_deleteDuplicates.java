package leetcode;

public class _82_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode t = head;
        while (q.next != null) {
            if (q.next.val == q.val) {
                q = q.next;
            }
            else {
                if (p != q) {
                    if (p == head) {
                        head = q.next;
                        p = head;
                        q = head;
                        t = head;
                    }
                    else {
                        t.next = q.next;
                        p = q.next;
                        q = q.next;
                    }
                }
                else {
                    t = p;
                    p = p.next;
                    q = q.next;
                }
            }
        }
        if (p != q) {
            if (p == head) {
                return null;
            }
            else {
                t.next = null;
                return head;
            }
        }
        return head;
    }

//    遍历
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
