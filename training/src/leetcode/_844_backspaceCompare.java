package leetcode;

import java.util.Stack;

public class _844_backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') s.push(S.charAt(i));
            else {
                if (!s.empty()) s.pop();
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') t.push(T.charAt(i));
            else {
                if (!t.empty()) t.pop();
            }
        }
        while (!s.empty() && !t.empty()) {
            if (s.pop() != t.pop()) return false;
        }
        return s.empty() && t.empty();
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
