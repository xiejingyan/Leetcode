package leetcode;

public class _206_reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp1 = new ListNode();
        ListNode tmp2 = new ListNode();
        tmp1.next = head;
        while (head.next != null) {
            tmp2.next = head.next;
            head.next = tmp2.next.next;
            tmp2.next.next = tmp1.next;
            tmp1.next = tmp2.next;
        }
        return tmp1.next;
    }

//    迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

//    递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
