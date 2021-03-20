package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _150_evalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    Integer a = nums.pollLast();
                    Integer b = nums.pollLast();
                    nums.addLast(a + b);
                    break;
                case "-":
                    a = nums.pollLast();
                    b = nums.pollLast();
                    nums.addLast(b - a);
                    break;
                case "*":
                    a = nums.pollLast();
                    b = nums.pollLast();
                    nums.addLast(a * b);
                    break;
                case "/":
                    a = nums.pollLast();
                    b = nums.pollLast();
                    nums.addLast(b / a);
                    break;
                default:
                    nums.addLast(Integer.parseInt(token));
                    break;
            }
        }
        return nums.pollLast();
    }

//    栈
    public int evalRPN1(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

//    数组模拟栈
    public int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        _150_evalRPN er = new _150_evalRPN();
        System.out.println(er.evalRPN(tokens));
    }
}
