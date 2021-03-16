package leetcode;

public class _59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        char tmp = 'r';
        int i = 0, j = 0, num = 1;
        while (true) {
            if (tmp == 'r') {
                if (j < matrix[i].length && matrix[i][j] == 0) {
                    matrix[i][j] = num;
                    num++;
                    j++;
                }
                else {
                    j--;
                    i++;
                    if (i >= matrix.length || matrix[i][j] != 0) {
                        break;
                    }
                    tmp = 'd';
                }
            }
            else if (tmp == 'd') {
                if (i < matrix.length && matrix[i][j] == 0) {
                    matrix[i][j] = num;
                    num++;
                    i++;
                }
                else {
                    i--;
                    j--;
                    if (j < 0 || matrix[i][j] != 0) {
                        break;
                    }
                    tmp = 'l';
                }
            }
            else if (tmp == 'l') {
                if (j >= 0 && matrix[i][j] == 0) {
                    matrix[i][j] = num;
                    num++;
                    j--;
                }
                else {
                    j++;
                    i--;
                    if (i < 0 || matrix[i][j] != 0) {
                        break;
                    }
                    tmp = 'u';
                }
            }
            else {
                if (i >= 0 && matrix[i][j] == 0) {
                    matrix[i][j] = num;
                    num++;
                    i--;
                }
                else {
                    i++;
                    j++;
                    if (j >= matrix.length || matrix[i][j] != 0) {
                        break;
                    }
                    tmp = 'r';
                }
            }
        }
        return matrix;
    }

//    模拟
    public int[][] generateMatrix1(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

//    按层模拟
    public int[][] generateMatrix2(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
