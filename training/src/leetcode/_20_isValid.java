package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _20_isValid {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                deque.addLast(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.pollLast();
                }
                else return false;
            }
            else if (s.charAt(i) == ']') {
                if (!deque.isEmpty() && deque.peekLast() == '[') {
                    deque.pollLast();
                }
                else return false;
            }
            else if (s.charAt(i) == '}') {
                if (!deque.isEmpty() && deque.peekLast() == '{') {
                    deque.pollLast();
                }
                else return false;
            }
        }
        return deque.isEmpty();
    }

//    栈
    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
