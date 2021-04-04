package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _781_numRabbits {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int answer : answers) {
            nums.put(answer, nums.getOrDefault(answer, 0) + 1);
        }
        int res = 0;
        for (Integer integer : nums.keySet()) {
            if (integer == 0) {
                res += nums.get(0);
            }
            else {
                int tmp = nums.get(integer);
                if (tmp % (integer + 1) > 0) {
                    tmp = tmp - tmp % (integer + 1) + integer + 1;
                }
                res += tmp;
            }
        }
        return res;
    }

//    贪心
    public int numRabbits1(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1};
        _781_numRabbits nr = new _781_numRabbits();
        System.out.println(nr.numRabbits(a));
    }
}
