package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _290_wordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> num = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (num.containsKey(pattern.charAt(i)) && !num.get(pattern.charAt(i)).equals(strs[i])) {
                return false;
            }
            else if (!num.containsKey(pattern.charAt(i)) && num.containsValue(strs[i])) {
                return false;
            }
            else {
                num.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

    public static void main(String[] args) {
        _290_wordPattern wp = new _290_wordPattern();
        String s = "dog cat cat dog";
        String pattern ="abba";
        wp.wordPattern(pattern, s);
    }
}
