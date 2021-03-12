package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _331_isValidSerialization {
    public boolean isValidSerialization(String preorder) {
        char[] chars = preorder.toCharArray();
        int num = 1;
        for (int i = 0; i < chars.length; i += 2) {
            if (chars[i] == '#') {
                num--;
            }
            else {
                num++;
            }
            if (i != chars.length - 1 && num <= 0) {
                return false;
            }
            while (i + 1 < chars.length && chars[i + 1] != ',') {
                i++;
            }
        }
        return num == 0;
    }

//    栈
    public boolean isValidSerialization1(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

//    计数
    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }
}
