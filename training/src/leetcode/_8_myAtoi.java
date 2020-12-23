package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _8_myAtoi {
    public int myAtoi(String s) {
        StringBuilder tmp = new StringBuilder(s);
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') {
                tmp.deleteCharAt(i);
                i--;
            }
            else {
                break;
            }
        }
        if (tmp.length() < 1) {
            return 0;
        }
        if (tmp.charAt(0) != '+' && tmp.charAt(0) != '-' && (tmp.charAt(0) < '0' || tmp.charAt(0) > '9')) {
            return 0;
        }
        else {
            for (int i = 1; i < tmp.length(); i++) {
                if (tmp.charAt(i) < '0' || tmp.charAt(i) > '9') {
                    tmp.delete(i, tmp.length());
                }
            }
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    tmp.deleteCharAt(i);
                    i--;
                }
                else if (tmp.charAt(i) != '+' && tmp.charAt(i) != '-') {
                    break;
                }
            }
            if (tmp.length() < 1) {
                return 0;
            }
            if (tmp.length() == 1 && (tmp.charAt(0) == '+' || tmp.charAt(0) == '-')) {
                return 0;
            }
            if (tmp.length() > 11 && tmp.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            else if (tmp.length() > 11 && tmp.charAt(0) != '-') {
                return Integer.MAX_VALUE;
            }
            long res = Long.parseLong(tmp.toString());
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            else if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else {
                return Integer.parseInt(tmp.toString());
            }
        }
    }

//    自动机（确定有限状态机DFA）
    public int myAtoi1(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }

    }

    public static void main(String[] args) {
        _8_myAtoi ma = new _8_myAtoi();
        System.out.println(ma.myAtoi("  0000000000012345678"));
    }
}
