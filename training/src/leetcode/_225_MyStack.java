package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _225_MyStack {
    Deque<Integer> queue;
    /** Initialize your data structure here. */
    public _225_MyStack() {
        queue = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            queue.addLast(queue.pollFirst());
        }
        return queue.pollFirst();
    }
    /** Get the top element. */
    public int top() {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            queue.addLast(queue.pollFirst());
        }
        Integer integer = queue.pollFirst();
        queue.addLast(integer);
        return integer;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

//    两个队列
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
//    public MyStack() {
//        queue1 = new LinkedList<Integer>();
//        queue2 = new LinkedList<Integer>();
//    }
    /** Push element x onto stack. */
    public void push1(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop1() {
        return queue1.poll();
    }
    /** Get the top element. */
    public int top1() {
        return queue1.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty1() {
        return queue1.isEmpty();
    }

//    一个队列
//    Queue<Integer> queue;
    /** Initialize your data structure here. */
//    public MyStack() {
//        queue = new LinkedList<Integer>();
//    }
    /** Push element x onto stack. */
    public void push2(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop2() {
        return queue.poll();
    }
    /** Get the top element. */
    public int top2() {
        return queue.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty2() {
        return queue.isEmpty();
    }
}
