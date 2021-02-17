package leetcode;

public class _566_matrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int i = 0, j = 0;
        for (int[] num : nums) {
            for (int n : num) {
                res[i][j] = n;
                if (j == c - 1) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

//    二维数组映射一维
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
