package leetcode;

import java.util.*;

public class _56_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        Map<Integer, Integer> nums = new HashMap<>();
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > e) {
                nums.put(s, e);
                s = intervals[i][0];
                e = intervals[i][1];
            }
            else if (intervals[i][0] <= e && intervals[i][1] >= e) {
                e = intervals[i][1];
            }
        }
        nums.put(s, e);
        int[][] res = new int[nums.size()][2];
        s = 0;
        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            res[s][0] = entry.getKey();
            res[s][1] = entry.getValue();
            s++;
        }
        return res;
    }

//    排序
    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
