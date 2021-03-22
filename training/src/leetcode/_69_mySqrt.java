package leetcode;

public class _69_mySqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 1;
        while (true) {
            if (x / res == res) {
                return res;
            }
            else if (x / res < res) {
                return res - 1;
            }
            res++;
        }
    }

//    幂函数+对数函数
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

//    二分查找
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

//    牛顿迭代
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
