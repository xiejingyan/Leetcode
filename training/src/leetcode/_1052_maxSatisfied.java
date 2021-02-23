package leetcode;

public class _1052_maxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0, tmp = 0, start = -1, sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                if (start == -1) {
                    start = i;
                }
                sum += customers[i];
            }
            else {
                res += customers[i];
            }
            if (start != -1 && i - start == X - 1) {
                tmp = Math.max(tmp, sum);
                sum -= customers[start];
                start++;
                while (start < grumpy.length && grumpy[start] == 0) {
                    start++;
                }
            }
        }
        return res + Math.max(tmp, sum);
    }

//    滑动窗口
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }

    public static void main(String[] args) {
        int[] c = {10, 4};
        int[] g = {0, 1};
        _1052_maxSatisfied ms = new _1052_maxSatisfied();
        System.out.println(ms.maxSatisfied(c, g, 2));
    }
}
