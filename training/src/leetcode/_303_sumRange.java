package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _303_sumRange {
    List<Integer> sum = new ArrayList<>();
    public _303_sumRange(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
            sum.add(s);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum.get(j);
        }
        else {
            return sum.get(j) - sum.get(i - 1);
        }
    }

//    前缀和
    int[] sums;
//    public NumArray(int[] nums) {
//        int n = nums.length;
//        sums = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
//    }
    public int sumRange1(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
