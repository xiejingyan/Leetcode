package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _131_partition {
    int[][] g;
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;
//    回溯 + 动态规划预处理
    public List<List<String>> partition1(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs1(s, 0);
        return ret;
    }
    public void dfs1(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs1(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

//    回溯 + 记忆化搜索
    public List<List<String>> partition2(String s) {
        n = s.length();
        g = new int[n][n];

        dfs2(s, 0);
        return ret;
    }
    public void dfs2(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs2(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (g[i][j] != 0) {
            return g[i][j];
        }
        if (i >= j) {
            g[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            g[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            g[i][j] = -1;
        }
        return g[i][j];
    }
}
