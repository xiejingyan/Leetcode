package leetcode;

public class _1047_removeDuplicates {
    public String removeDuplicates(String S) {
        StringBuffer res = new StringBuffer(S);
        int l = 0, r = 1;
        while (r < res.length()) {
            if (res.charAt(l) != res.charAt(r)) {
                l++;
                r++;
            }
            else {
                res.deleteCharAt(r);
                res.deleteCharAt(l);
                if (l != 0) {
                    l--;
                    r--;
                }
            }
        }
        return res.toString();
    }

//    栈
    public String removeDuplicates1(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
