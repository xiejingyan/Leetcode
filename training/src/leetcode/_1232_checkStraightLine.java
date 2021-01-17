package leetcode;

public class _1232_checkStraightLine {
//    无法对含有重复点的数据集判断
    public boolean checkStraightLine(int[][] coordinates) {
        double a = coordinates[1][0] - coordinates[0][0];
        double b = coordinates[1][1] - coordinates[0][1];
        if (b != 0) {
            double flag = a / b;
            for (int i = 1; i < coordinates.length; i++) {
                if (flag != (double) (coordinates[i][0] - coordinates[i - 1][0]) / (coordinates[i][1] - coordinates[i - 1][1])) {
                    return false;
                }
            }
        }
        else {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][1] - coordinates[i - 1][1] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

//    数学方法（可以包含重复的点）
    public boolean checkStraightLine1(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
