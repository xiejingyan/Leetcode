package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int j = 1;
                while (j < nums[i]) {
                    res.add(j);
                    j++;
                }
            }
            else {
                if (nums[i] - nums[i - 1] > 1) {
                    int j = nums[i - 1] + 1;
                    while (j < nums[i]) {
                        res.add(j);
                        j++;
                    }
                }
            }
        }
        if (nums.length > 0 && nums[nums.length - 1] < nums.length) {
            int j = nums[nums.length - 1] + 1;
            while (j <= nums.length) {
                res.add(j);
                j++;
            }
        }
        return res;
    }

//    原地修改
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
