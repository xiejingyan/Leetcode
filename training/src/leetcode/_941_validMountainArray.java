package leetcode;

public class _941_validMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[0] >= A[1] || A[A.length -1] >= A[A.length - 2]) return false;
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] < A[i - 1]) break;
            else if (A[i] == A[i - 1]) return false;
        }
        for (; i < A.length; i++) {
            if (A[i] >= A[i - 1]) return false;
        }
        return true;
    }

    public boolean validMountainArray1(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }
}
