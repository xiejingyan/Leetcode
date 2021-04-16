package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _227_calculate {
    public int calculate(String s) {
        String s1 = s.replaceAll(" ", "");
        Deque<Long> nums = new LinkedList<>();
        Deque<Character> mack = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < s1.length() + 1; i++) {
            if (i == s1.length() || s1.charAt(i) == '+' || s1.charAt(i) == '-' || s1.charAt(i) == '*' || s1.charAt(i) == '/') {
                nums.addLast(Long.parseLong(s1.substring(start, i)));
                start = i + 1;
                if (!mack.isEmpty() && mack.peekLast() == '*') {
                    mack.pollLast();
                    Long a = nums.pollLast();
                    Long b = nums.pollLast();
                    nums.addLast(a * b);
                }
                if (!mack.isEmpty() && mack.peekLast() == '/') {
                    mack.pollLast();
                    Long a = nums.pollLast();
                    Long b = nums.pollLast();
                    nums.addLast(b / a);
                }
                if (i < s1.length()) {
                    mack.addLast(s1.charAt(i));
                }
            }
        }
        while (!mack.isEmpty()) {
            char m = mack.pollFirst();
            Long a = nums.pollFirst();
            Long b = nums.pollFirst();
            if (m == '+') {
                nums.addFirst(a + b);
            }
            else if (m == '-') {
                nums.addFirst(a - b);
            }
            else if (m == '*') {
                nums.addFirst(a * b);
            }
            else {
                nums.addFirst(a / b);
            }
        }
        long res = nums.pollLast();
        return (int) res;
    }

//    栈
    public int calculate1(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "2*3+4";
        _227_calculate c = new _227_calculate();
        System.out.println(c.calculate(s));
    }
}
