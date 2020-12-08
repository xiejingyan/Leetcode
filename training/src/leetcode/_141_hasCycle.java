package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _141_hasCycle {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.contains(head)) {
                nodes.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode a = head;
        ListNode b = head.next;
        while (a != b) {
            if (a == null || b == null) return false;
            a = a.next;
            b = b.next.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}