package leetcode;

import java.util.Arrays;

public class _832_flipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].length % 2 == 1) {
                A[i][A[i].length / 2] ^= 1;
            }
            for (int j = 0; j < A[i].length / 2; j++) {
                if (A[i][j] == A[i][A[i].length - 1 - j]) {
                    A[i][j] ^= 1;
                    A[i][A[i].length - 1 - j] ^= 1;
                }
            }
        }
        return A;
    }

//    双指针
    public int[][] flipAndInvertImage1(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        _832_flipAndInvertImage faii = new _832_flipAndInvertImage();
        System.out.println(Arrays.toString(faii.flipAndInvertImage(A)));
    }
}
