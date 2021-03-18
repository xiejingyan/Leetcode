package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _160_getIntersectionNode {
    public ListNode _1_getIntersectionNode(ListNode headA, ListNode headB) {
        Deque<ListNode> a = new LinkedList<>();
        Deque<ListNode> b = new LinkedList<>();
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            a.addLast(p);
            p = p.next;
        }
        while (q != null) {
            b.addLast(q);
            q = q.next;
        }
        while (!a.isEmpty() && !b.isEmpty()) {
            p = a.pollLast();
            q = b.pollLast();
            if (p != q) {
                return p.next;
            }
        }
        if (!a.isEmpty()) {
            return headB;
        }
        else {
            return headA;
        }
    }

    public ListNode _2_getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int num1 = 0, num2 = 0;
        while (p != null) {
            num1++;
            p = p.next;
        }
        while (q != null) {
            num2++;
            q = q.next;
        }
        p = headA;
        q = headB;
        if (num1 > num2) {
            for (int i = 0; i < num1 - num2; i++) {
                p = p.next;
            }
        }
        if (num2 > num1) {
            for (int i = 0; i < num2 - num1; i++) {
                q = q.next;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

//    双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while(p != q){
            p = (p == null) ? headB : p.next;
            q = (q == null) ? headA : q.next;
        }
        return p;
    }
}
