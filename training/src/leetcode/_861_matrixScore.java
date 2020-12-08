package leetcode;

public class _861_matrixScore {
    public int matrixScore(int[][] A) {
        int res = (int) (A.length * Math.pow(2, A[0].length - 1));
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    }
                    else {
                        A[i][j] = 0;
                    }
                }
            }
        }
        for (int j = 1; j < A[0].length; j++) {
            int one = 0, zero = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    zero++;
                }
                else {
                    one++;
                }
            }
            res += Math.max(one, zero) * Math.pow(2, A[0].length - 1 - j);
        }
        return res;
    }

    public int matrixScore1(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        _861_matrixScore ms = new _861_matrixScore();
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int score = ms.matrixScore(A);
        System.out.println(score);
    }
}
