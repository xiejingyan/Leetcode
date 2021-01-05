package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_largeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num++;
            }
            else {
                if (num >= 3) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i - num);
                    tmp.add(i - 1);
                    res.add(tmp);
                }
                num = 1;
            }
        }
        if (num >= 3) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(s.length() - num);
            tmp.add(s.length() - 1);
            res.add(tmp);
        }
        return res;
    }

//    一次遍历
    public List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
