package leetcode;

import java.util.Arrays;

public class _1370_sortString {
    public String sortString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder S = new StringBuilder();
        for (char aChar : chars) {
            S.append(aChar);
        }
        boolean flag = true;
        int i, j = 0;
        while (S.length() != 0) {
            if (flag) {
                i = 0;
                res.append(S.charAt(0));
                S.delete(0, 1);
                j = res.length() - 1;
                while (i < S.length()) {
                    if (S.charAt(i) > res.charAt(j)) {
                        res.append(S.charAt(i));
                        S.delete(i, i + 1);
                        j++;
                    }
                    else {
                        i++;
                    }
                }
                flag = false;
            }
            else {
                res.append(S.charAt(S.length() - 1));
                S.delete(S.length() - 1, S.length());
                i = S.length() - 1;
                j = res.length() - 1;
                while (i >= 0) {
                    if (S.charAt(i) < res.charAt(j)) {
                        res.append(S.charAt(i));
                        S.delete(i, i + 1);
                        j++;
                    }
                    i--;
                }
                flag = true;
            }
        }
        return res.toString();
    }

    public String sortString1(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        _1370_sortString ss = new _1370_sortString();
        String s = "aaaabbbbcccc";
        System.out.println(ss.sortString(s));
    }
}
