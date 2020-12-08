package leetcode;

public class _24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode tmp;
        if (head != null && head.next != null) {
            tmp = new ListNode(head.val, head.next);
            head.next = tmp.next.next;
            tmp.next.next = head;
            head.next = swapPairs(head.next);
            return tmp.next;
        } else return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
