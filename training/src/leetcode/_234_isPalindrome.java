package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int num = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = new ListNode(head.val, head.next);
        while (tmp != null) {
            num++;
            tmp = tmp.next;
        }
        tmp = head;
        if (num % 2 == 0) num = num / 2;
        else num = num / 2 + 2;
        for (int i = 1; i < num; i++) {
            tmp = tmp.next;
        }
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (true) {
            if (head.val != stack.pop().val) return false;
            else head = head.next;
            if (stack.empty()) return true;
        }
    }

    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    private ListNode frontPointer;
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
