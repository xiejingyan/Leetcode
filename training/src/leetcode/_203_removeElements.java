package leetcode;

public class _203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode flag = new ListNode();
        flag = head;
        if (flag != null) {
            while (flag.next != null) {
                if (flag.next.val == val) {
                    flag.next = flag.next.next;
                }
                else {
                    flag = flag.next;
                }
            }
        }
        return head;
    }

//    哨兵节点
    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
