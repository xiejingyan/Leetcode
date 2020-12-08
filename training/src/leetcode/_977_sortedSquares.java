package leetcode;

public class _977_sortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int i, j, tmp;
        for (i = 0; i < A.length; i++) {
            if (A[i] >= 0) break;
        }
        j = i - 1;
        tmp = 0;
        while (i < A.length || j >= 0) {
            if (i == A.length) {
                B[tmp] = A[j] * A[j];
                j--;
            }
            else if (j == -1) {
                B[tmp] = A[i] * A[i];
                i++;
            }
            else if (A[i] >= A[j]) {
                B[tmp] = A[j] * A[j];
                j--;
            } else {
                B[tmp] = A[i] * A[i];
                i++;
            }
            tmp++;
        }
        return B;
    }

    public int[] sortedSquares2(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
