package leetcode;

public class _62_uniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        else {
            int down, right;
            if (n - 1 < m - 1) {
                down = m - 1;
                right = n - 1;
            }
            else {
                down = n - 1;
                right = m - 1;
            }
            long sum = 1, tmp = 1;
            for (int i = 0; i < right; i++) {
                sum *= down + right - i;
                tmp *= right - i;
            }
            return Math.toIntExact(sum / tmp);
        }
    }

    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        _62_uniquePaths up = new _62_uniquePaths();
        int i = up.uniquePaths(10, 10);
        System.out.println(i);
    }
}