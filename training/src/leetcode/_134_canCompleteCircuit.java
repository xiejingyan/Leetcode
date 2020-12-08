package leetcode;

public class _134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            int tmp = 0, j = i;
            while (tmp >= 0) {
                tmp = tmp + gas[j] - cost[j];
                if (j == gas.length - 1) {
                    j = 0;
                }
                else {
                    j++;
                }
                if (j == i) {
                    break;
                }
            }
            if (tmp >= 0) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }


}
