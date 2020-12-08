package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.contains(head)) {
                nodes.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
