package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        while (res.size() > 1 && res.get(0).equals(res.get(1))) {
            res.remove(0);
        }
        if (res.size() <= 2) {
            return res.size();
        }
        boolean flag = true;
        if (res.get(0) < res.get(1)) {
            flag = false;
        }
        for (int i = 1; i < res.size() - 1; i++) {
            if (flag) {
                if (res.get(i) >= res.get(i + 1)) {
                    res.remove(i);
                    i--;
                }
                else {
                    flag = false;
                }
            }
            else {
                if (res.get(i) <= res.get(i + 1)) {
                    res.remove(i);
                    i--;
                }
                else {
                    flag = true;
                }
            }
        }
        return res.size();
    }

    /*
    动态规划
     */
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    /*
    优化动态规划
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }

    /*
    优化动态规划
     */
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    /*
    贪心
     */
    public int wiggleMaxLength4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}
