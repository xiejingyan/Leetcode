package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002_commonChars {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < A[0].length(); i++) {
            boolean tmp = false;
            for (int j = 1; j < A.length; j++) {
                for (int k = 0; k < A[j].length(); k++) {
                    if (A[j].charAt(k) == A[0].charAt(i)) {
                        tmp = true;
                        StringBuilder stringBuilder = new StringBuilder(A[j]);
                        stringBuilder.setCharAt(k, 'A');
                        A[j] = stringBuilder.toString();
                        break;
                    }
                }
                if (!tmp) {
                    break;
                } else {
                    if (j != A.length - 1) tmp = false;
                }
            }
            if (tmp) {
                StringBuilder stringBuilder = new StringBuilder(A[0]);
                if (i != 0){
                    stringBuilder.delete(0, i);
                }
                stringBuilder.delete(1, stringBuilder.length());
                result.add(stringBuilder.toString());
            }
        }
        return result;
    }

    public List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
