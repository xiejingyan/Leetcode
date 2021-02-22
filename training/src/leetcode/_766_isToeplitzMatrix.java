package leetcode;

public class _766_isToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            int tmp = matrix[i / n][i % n];
            for (int j = i; j < m * n; j += n + 1) {
                if (matrix[j / n][j % n] != tmp) {
                    return false;
                }
                if (j % n == n - 1) {
                    break;
                }
            }
            if (i >= n) {
                i += n - 1;
            }
        }
        return true;
    }

//    遍历
    public boolean isToeplitzMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
