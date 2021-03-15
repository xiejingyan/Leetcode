package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        char tmp = 'r';
        int i = 0, j = 0;
        while (true) {
            if (tmp == 'r') {
                if (j < matrix[i].length && matrix[i][j] != -101) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    j++;
                }
                else {
                    j--;
                    i++;
                    if (i >= matrix.length || matrix[i][j] == -101) {
                        break;
                    }
                    tmp = 'd';
                }
            }
            else if (tmp == 'd') {
                if (i < matrix.length && matrix[i][j] != -101) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    i++;
                }
                else {
                    i--;
                    j--;
                    if (j < 0 || matrix[i][j] == -101) {
                        break;
                    }
                    tmp = 'l';
                }
            }
            else if (tmp == 'l') {
                if (j >= 0 && matrix[i][j] != -101) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    j--;
                }
                else {
                    j++;
                    i--;
                    if (i < 0 || matrix[i][j] == -101) {
                        break;
                    }
                    tmp = 'u';
                }
            }
            else {
                if (i >= 0 && matrix[i][j] != -101) {
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    i--;
                }
                else {
                    i++;
                    j++;
                    if (j >= matrix.length || matrix[i][j] == -101) {
                        break;
                    }
                    tmp = 'r';
                }
            }
        }
        return res;
    }

//    模拟
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

//    按层模拟
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        _54_spiralOrder so = new _54_spiralOrder();
        System.out.println(so.spiralOrder(m));
    }
}
