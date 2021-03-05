package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _232_MyQueue {
    Deque<Integer> queue1;
    Deque<Integer> queue2;
    /** Initialize your data structure here. */
    public _232_MyQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res;
        while (!queue1.isEmpty()) {
            queue2.addLast(queue1.pollLast());
        }
        res = queue2.pollLast();
        while (!queue2.isEmpty()) {
            queue1.addLast(queue2.pollLast());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        int res;
        while (!queue1.isEmpty()) {
            queue2.addLast(queue1.pollLast());
        }
        res = queue2.peekLast();
        while (!queue2.isEmpty()) {
            queue1.addLast(queue2.pollLast());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

//    双栈
    Deque<Integer> inStack;
    Deque<Integer> outStack;
//    public MyQueue() {
//        inStack = new LinkedList<Integer>();
//        outStack = new LinkedList<Integer>();
//    }

    public void push1(int x) {
        inStack.push(x);
    }

    public int pop1() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek1() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty1() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
