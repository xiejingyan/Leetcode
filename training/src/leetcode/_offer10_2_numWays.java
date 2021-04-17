package leetcode;

public class _offer10_2_numWays {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        int a = 1, b = 2;
        for (int i = 3; i < n + 1; i++) {
            b += a;
            a = b - a;
            if (a > 1000000007) {
                a %= 1000000007;
            }
            if (b > 1000000007) {
                b %= 1000000007;
            }
        }
        return b;
    }
}
