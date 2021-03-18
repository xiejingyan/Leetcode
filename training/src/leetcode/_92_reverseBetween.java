package leetcode;

public class _92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = new ListNode();
        p.next = head;
        ListNode m, n;
        for (int i = 1; i < left; i++) {
            p = p.next;
        }
        m = p.next;
        for (int i = 0; i < right - left; i++) {
            n = m.next;
            m.next = n.next;
            n.next = p.next;
            p.next = n;
        }
        return left == 1 ? p.next : head;
    }

//    一次遍历
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
