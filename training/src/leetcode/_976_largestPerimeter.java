package leetcode;

import java.util.Arrays;

public class _976_largestPerimeter {
    public int largestPerimeter(int[] A) {
        int res = 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                res = res + A[i] + A[i - 1] + A[i - 2];
                break;
            }
        }
        return res;
    }

    public int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
