package leetcode;

public class _61_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int nums = 1;
        ListNode p = head, q = head;
        while (p.next != null) {
            nums++;
            p = p.next;
        }
        if (k % nums == 0) {
            return head;
        }
        if (nums < k) {
            k %= nums;
        }
        p = head;
        nums = 0;
        while (p.next != null) {
            if (nums == k) {
                q = q.next;
                nums--;
            }
            p = p.next;
            nums++;
        }
        p.next = head;
        p = q.next;
        q.next = null;
        return p;
    }

//    闭合为环
    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
