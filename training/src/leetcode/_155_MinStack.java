package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _155_MinStack {
    int min;
    List<Integer> stack;
    /** initialize your data structure here. */
    public _155_MinStack() {
        min = Integer.MAX_VALUE;
        stack = new ArrayList<>();
    }
    public void push(int val) {
        min = Math.min(min, val);
        stack.add(val);
    }
    public void pop() {
        int p = stack.remove(stack.size() - 1);
        if (p == min) {
            min = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                min = Math.min(min, integer);
            }
        }
    }
    public int top() {
        return stack.get(stack.size() - 1);
    }
    public int getMin() {
        return min;
    }

//    最小值栈
    Deque<Integer> xStack;
    Deque<Integer> minStack;
//    public MinStack() {
//        xStack = new LinkedList<Integer>();
//        minStack = new LinkedList<Integer>();
//        minStack.push(Integer.MAX_VALUE);
//    }
    public void push1(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    public void pop1() {
        xStack.pop();
        minStack.pop();
    }
    public int top1() {
        return xStack.peek();
    }
    public int getMin1() {
        return minStack.peek();
    }
}

/*
  Your MinStack object will be instantiated and called as such:
  MinStack obj = new MinStack();
  obj.push(val);
  obj.pop();
  int param_3 = obj.top();
  int param_4 = obj.getMin();
 */

