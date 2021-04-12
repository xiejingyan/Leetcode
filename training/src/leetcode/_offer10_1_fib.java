package leetcode;

public class _offer10_1_fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            b += a;
            a = b - a;
            if (b > 1000000007) {
                b %= 1000000007;
            }
            if (a > 1000000007) {
                a %= 1000000007;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        _offer10_1_fib f = new _offer10_1_fib();
        System.out.println(f.fib(48));
    }
}
