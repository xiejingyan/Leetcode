package leetcode;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class _567_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> num = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (num.containsKey(s1.charAt(i))) {
                num.put(s1.charAt(i), num.get(s1.charAt(i)) + 1);
            }
            else {
                num.put(s1.charAt(i), 1);
            }
        }
        Map<Character, Integer> num2 = new HashMap<>(num);
        int j = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (num.containsKey(s2.charAt(i))) {
                num.put(s2.charAt(i), num.get(s2.charAt(i)) - 1);
                if (num.get(s2.charAt(i)) == 0) {
                    num.remove(s2.charAt(i));
                }
                if (num.size() == 0) {
                    return true;
                }
            }
            else {
                num.putAll(num2);
                i = j;
                j++;
            }
        }
        return false;
    }

//    滑动窗口
    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

//    双指针
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
