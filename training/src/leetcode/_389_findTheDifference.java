package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _389_findTheDifference {
    public char _1_findTheDifference(String s, String t) {
        Map<Character, Integer> nums = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            nums.put(s.charAt(i), nums.getOrDefault(s.charAt(i), 0) + 1);
        }
        char res = ' ';
        for (int i = 0; i < t.length(); i++) {
            if (nums.containsKey(t.charAt(i))) {
                nums.put(t.charAt(i), nums.get(t.charAt(i)) - 1);
                if (nums.get(t.charAt(i)) == 0) {
                    nums.remove(t.charAt(i));
                }
            }
            else {
                res = t.charAt(i);
                break;
            }
        }
        return res;
    }

    public char _2_findTheDifference(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int key = t.charAt(i) - 'a';
            if (nums[key] > 0) {
                nums[key] -= 1;
            }
            else {
                return t.charAt(i);
            }
        }
        return ' ';
    }

//    计数
    public char findTheDifference1(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

//    求和
    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

//    位运算
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
