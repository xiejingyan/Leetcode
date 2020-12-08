package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int[] tmp1 = new int[2];
        int[] tmp2 = new int[2];
        int[] tmp = new int[2];
        for (; i < intervals.length; i++) {
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                tmp1[0] = i;
                tmp1[1] = 1;
                break;
            }
            else if (newInterval[0] > intervals[i][1]) {
                tmp1[0] = i + 1;
            }
            else break;
        }
        tmp2[0] = tmp1[0];
        if (i != intervals.length) {
            for (; i < intervals.length; i++) {
                if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                    tmp2[0] = i;
                    tmp2[1] = 1;
                    break;
                }
                else if (newInterval[1] > intervals[i][1]) {
                    tmp2[0] = i + 1;
                }
                else break;
            }
            if (tmp1[1] == 1) tmp[0] = intervals[tmp1[0]][0];
            else tmp[0] = newInterval[0];
            if (tmp2[1] == 1) tmp[1] = intervals[tmp2[0]][1];
            else tmp[1] = newInterval[1];
        }
        else {
            tmp[0] = newInterval[0];
            tmp[1] = newInterval[1];
        }
        for (; j < intervals.length; j++) {
            if (j < tmp1[0]) res.add(intervals[j]);
            else break;
        }
        res.add(tmp);
        if (tmp2[1] == 0) j = tmp2[0];
        else j = tmp2[0] + 1;
        for (; j < intervals.length; j++) {
            res.add(intervals[j]);
        }
        int[][] result = new int[res.size()][2];
        for (int i1 = 0; i1 < res.size(); i1++) {
            result[i1] = res.get(i1);
        }
        return result;
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
