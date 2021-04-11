package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _offer9_CQueue {
    Deque<Integer> append;
    Deque<Integer> delete;
    public _offer9_CQueue() {
        append = new LinkedList<>();
        delete = new LinkedList<>();
    }
    public void appendTail(int value) {
        append.addLast(value);
    }
    public int deleteHead() {
        if (!delete.isEmpty()) {
            return delete.pollLast();
        }
        else {
            if (append.isEmpty()) {
                return -1;
            }
            else {
                while (!append.isEmpty()) {
                    delete.addLast(append.pollLast());
                }
                return delete.pollLast();
            }
        }
    }

//    双栈
    Deque<Integer> stack1;
    Deque<Integer> stack2;
//    public CQueue() {
//        stack1 = new LinkedList<Integer>();
//        stack2 = new LinkedList<Integer>();
//    }
    public void appendTail1(int value) {
        stack1.push(value);
    }
    public int deleteHead1() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
