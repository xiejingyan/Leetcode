package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _454_fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> ab = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                if (ab.containsKey(i + j)) {
                    ab.put(i + j, ab.get(i + j) + 1);
                }
                else {
                    ab.put(i + j, 1);
                }
            }
        }
        for (int i : C) {
            for (int j : D) {
                if (ab.containsKey(-(i + j))) {
                    res += ab.get(-(i + j));
                }
            }
        }
        return res;
    }

    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
