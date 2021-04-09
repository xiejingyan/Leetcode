package leetcode;

public class _64_minPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int i = 0, j = 0;
        for (; i < grid.length; i++) {
            j = 0;
            for (; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[i - 1][j - 1];
    }

//    动态规划
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] g = {{1, 2, 3}, {4, 5, 6}};
        _64_minPathSum mps = new _64_minPathSum();
        System.out.println(mps.minPathSum(g));;
    }
}
