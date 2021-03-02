package leetcode;

public class _304_sumRegion {
    int[][] sum;
    public _304_sumRegion(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            sum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int tmp = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    tmp += matrix[i][j];
                    if (i == 0) {
                        sum[i][j] = tmp;
                    }
                    else {
                        sum[i][j] = tmp + sum[i - 1][j];
                    }
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sum[row2][col2];
        if (row1 != 0) {
            res -= sum[row1 - 1][col2];
        }
        if (col1 != 0) {
            res -= sum[row2][col1 - 1];
        }
        if (row1 != 0 && col1 != 0) {
            res += sum[row1 - 1][col1 - 1];
        }
        return res;
    }

//    一维前缀和
    int[][] sums;
//    public NumMatrix(int[][] matrix) {
//        int m = matrix.length;
//        if (m > 0) {
//            int n = matrix[0].length;
//            sums = new int[m][n + 1];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
//                }
//            }
//        }
//    }
    public int sumRegion1(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

//    二维前缀和
    int[][] su;
//    public NumMatrix(int[][] matrix) {
//        int m = matrix.length;
//        if (m > 0) {
//            int n = matrix[0].length;
//            su = new int[m + 1][n + 1];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    su[i + 1][j + 1] = su[i][j + 1] + su[i + 1][j] - su[i][j] + matrix[i][j];
//                }
//            }
//        }
//    }
    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return su[row2 + 1][col2 + 1] - su[row1][col2 + 1] - su[row2 + 1][col1] + su[row1][col1];
    }
}
