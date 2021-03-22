package leetcode;

public class _191_hammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        int tmp = n;
        int flag = 0;
        while (n != 0) {
            if (n % 2 == 1 || n % 2 == -1) {
                res++;
            }
            else {
                if (res == 0) {
                    flag++;
                }
            }
            n /= 2;
        }
        return tmp < 0 ? 33 - res - flag : res;
    }

//    循环检查二进制位
    public int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

//    位运算优化
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        _191_hammingWeight hw = new _191_hammingWeight();
        System.out.println(hw.hammingWeight(Integer.MIN_VALUE));
    }
}
