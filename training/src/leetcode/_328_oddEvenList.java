package leetcode;

public class _328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode hd = head.next;
        ListNode hd1 = head;
        ListNode hd2 = head.next;
        ListNode tmp = hd.next;
        hd.next = null;
        boolean flag = true;
        while (tmp != null) {
            if (flag) {
                hd1.next = tmp;
                hd1 = hd1.next;
                tmp = tmp.next;
                hd1.next = null;
                flag = false;
            }
            else {
                hd2.next = tmp;
                hd2 = hd2.next;
                tmp = tmp.next;
                hd2.next = null;
                flag = true;
            }
        }
        hd1.next = hd;
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
