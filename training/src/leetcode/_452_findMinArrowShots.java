package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] < o2[0] ? -1 : 1;
                }
            }
        });
        int e = points[0][1], res = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > e) {
                e = points[i][1];
                res++;
            }
            else {
                e = Math.min(e, points[i][1]);
            }
        }
        res++;
        return res;
    }

    public int findMinArrowShots1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
