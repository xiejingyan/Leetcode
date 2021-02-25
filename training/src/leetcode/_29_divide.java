package leetcode;

public class _29_divide {
    public int divide(int dividend, int divisor) {
        long m = dividend, n = divisor, tmp, res = 0;
        m = Math.abs(m);
        n = Math.abs(n);
        while (m >= n) {
            long flag = 1;
            tmp = n;
            while (tmp + tmp <= m) {
                tmp += tmp;
                flag += flag;
            }
            res += flag;
            m -= tmp;
        }
        if (dividend < 0 && divisor < 0 || dividend >= 0 && divisor > 0) {
            if (res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
            }
            return (int) res;
        }
        else {
            if (-res < Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE + 1;
            }
            return (int) -res;
        }
    }
}
