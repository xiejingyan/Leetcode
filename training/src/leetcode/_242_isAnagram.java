package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _242_isAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> S = new HashMap<>();
        Map<Character, Integer> T = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (S.containsKey(s.charAt(i))) {
                Integer integer = S.get(s.charAt(i));
                integer++;
                S.put(s.charAt(i), integer);
            }
            else {
                S.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (T.containsKey(t.charAt(i))) {
                Integer integer = T.get(t.charAt(i));
                integer++;
                T.put(t.charAt(i), integer);
            }
            else {
                T.put(t.charAt(i), 1);
            }
        }
        return S.equals(T);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
