package leetcode;

public class _2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        int flag = 0;
        while (l1 != null || l2 != null || flag == 1) {
            int num;
            if (l1 == null && l2 == null) {
                num = 1;
            }
            else if (l1 != null && l2 == null) {
                num = l1.val + flag;
                l1 = l1.next;
            }
            else if (l1 == null) {
                num = l2.val + flag;
                l2 = l2.next;
            }
            else {
                num = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (num > 9) {
                num -= 10;
                flag = 1;
            }
            else {
                flag = 0;
            }
            tmp.val = num;
            if (l1 != null || l2 != null || flag == 1) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }
        return res;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
