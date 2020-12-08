package leetcode;

public class _463_islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        if (grid.length == 1 && grid[0].length == 1) {
            if (grid[0][0] == 1) return 4;
            else return 0;
        }
        else if (grid.length == 1) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[0][i] == 1) {
                    if (i == 0) {
                        result += 3;
                        if (grid[0][i + 1] == 0) result++;
                    }
                    else if (i == grid[0].length - 1) {
                        result += 3;
                        if (grid[0][i - 1] == 0) result++;
                    }
                    else {
                        result += 2;
                        if (grid[0][i + 1] == 0) result++;
                        if (grid[0][i - 1] == 0) result++;
                    }
                }
            }
            return result;
        }
        else if (grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][0] == 1) {
                    if (i == 0) {
                        result += 3;
                        if (grid[i + 1][0] == 0) result++;
                    }
                    else if (i == grid.length - 1) {
                        result += 3;
                        if (grid[i - 1][0] == 0) result++;
                    }
                    else {
                        result += 2;
                        if (grid[i + 1][0] == 0) result++;
                        if (grid[i - 1][0] == 0) result++;
                    }
                }
            }
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        result++;
                        if (j == 0) {
                            result++;
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                        else if (j == grid[0].length - 1) {
                            result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                        else {
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                    }
                    else if (i == grid.length - 1) {
                        result++;
                        if (j == 0) {
                            result++;
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                        }
                        else if (j == grid[0].length - 1) {
                            result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                        }
                        else {
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                        }
                    }
                    else {
                        if (j == 0) {
                            result++;
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                        else if (j == grid[0].length - 1) {
                            result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                        else {
                            if (grid[i][j + 1] == 0) result++;
                            if (grid[i][j - 1] == 0) result++;
                            if (grid[i - 1][j] == 0) result++;
                            if (grid[i + 1][j] == 0) result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int islandPerimeter1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }

    public int islandPerimeter2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }
    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }
}
