package leetcode;

import java.util.*;

public class _1207_uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1) return true;
        Arrays.sort(arr);
        Set<Integer> num = new HashSet<>();
        int tmp = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (num.contains(i - 1 - tmp)) return false;
                else {
                    num.add(i - 1 - tmp);
                    tmp = i - 1;
                }
            }
            if (i == arr.length - 1 && num.contains(i - tmp)) return false;
        }
        return true;
    }

    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }
}
