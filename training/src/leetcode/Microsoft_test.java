package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Microsoft_test {
    public int task1(int[] A) {
        Arrays.sort(A);
        int tmp = A[A.length / 2], res = 0;
        for (int i : A) {
            if (i < tmp) {
                res += tmp - i;
            }
            else if (i > tmp) {
                res += i - tmp;
            }
        }
        return res;
    }

    public int[] task2(String[] cars) {
        int[] res = new int[cars.length];
        int[] dp = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i].length(); j++) {
                if (cars[i].charAt(j) == '1') {
                    dp[i]++;
                }
            }
        }

        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (Math.abs(dp[i] - dp[j]) <= 1) {
                    int tmp = 0;
                    for (int t = 0; t < cars[i].length(); t++) {
                        if (cars[i].charAt(t) != cars[j].charAt(t)) {
                            tmp++;
                        }
                        if (tmp > 1) {
                            break;
                        }
                    }
                    if (tmp <= 1) {
                        res[i]++;
                        res[j]++;
                    }
                }
            }
        }
        return res;
    }

    public int task3(int[] A) {
        Map<Integer, Integer> nums = new HashMap<>();
        int res = 0;
        for (int i : A) {
            nums.put(i, nums.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < 10017; i++) {
            if (nums.containsKey(i)) {
                int num = nums.get(i);
                if (num % 2 == 1) {
                    res++;
                }
                nums.put(i + 1, nums.getOrDefault(i + 1, 0) + num / 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Microsoft_test m = new Microsoft_test();
        int[] a = {1,2};
        System.out.println(m.task3(a));
    }
}
