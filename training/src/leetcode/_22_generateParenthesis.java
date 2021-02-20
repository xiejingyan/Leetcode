package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n > 1) {
            List<String> list = generateParenthesis(n - 1);
            for (String s : list) {
                res.add("(" + s + ")");
            }
            for (String s : list) {
                if (!res.contains(s + "()")) {
                    res.add(s + "()");
                }
                if (!res.contains("()" + s)) {
                    res.add("()" + s);
                }
            }
            for (int tmp = 2; tmp <= n / 2; tmp++) {
                List<String> list1 = generateParenthesis(tmp);
                List<String> list2 = generateParenthesis(n - tmp);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        if (!res.contains(s1 + s2)) {
                            res.add(s1 + s2);
                        }
                        if (!res.contains(s2 + s1)) {
                            res.add(s2 + s1);
                        }
                    }
                }
            }
        }
        else {
            res.add("()");
        }
        return res;
    }

//    暴力
    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

//    回溯
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

//    递归
    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
    public List<String> generateParenthesis3(int n) {
        return generate(n);
    }
}
