package leetcode;

public class ali_faceTest {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode p = head;
        int tmp = (l1.val + l2.val) / 10;
        while (l1 != null || l2 != null || tmp == 1) {
            p.next = new ListNode();
            if (l1 == null && l2 != null) {
                p.next.val = (l2.val + tmp) % 10;
                tmp = (l2.val + tmp) / 10;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                p.next.val = (l1.val + tmp) % 10;
                tmp = (l1.val + tmp) / 10;
                l1 = l1.next;
            } else if (l1 == null) {
                p.next.val = tmp;
                break;
            } else {
                p.next.val = (l1.val + l2.val + tmp) % 10;
                tmp = (l1.val + l2.val + tmp) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            p = p.next;
        }
        return head;
    }
}
