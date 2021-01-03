package leetcode;

public class _86_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode tmp = head;
        ListNode min = new ListNode();
        ListNode s = min;
        ListNode max = new ListNode();
        ListNode b = max;
        while (tmp != null) {
            if (tmp.val < x) {
                s.next = tmp;
                tmp = tmp.next;
                s = s.next;
                s.next = null;
            }
            else {
                b.next = tmp;
                tmp = tmp.next;
                b = b.next;
                b.next = null;
            }

        }
        s.next = max.next;
        return min.next;
    }

//    模拟
    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

}
